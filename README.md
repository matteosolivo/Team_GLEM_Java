# Team_GLEM_Java
Lavoro di gruppo in cui analizzare e migliorare un progetto java creato con Gradle.

#### CONSEGNA:
1) Esaminare il progetto in allegato e riorganizzare il codice in modo più elegante e manutenibile.
2) Descrivere il funzionamento dell'applicativo (versione originale)
3) Effettuare refactoring del codice (utilizzo di interfacce e classi astratte)
4) Gestire le "empty response" con eccezioni custom da catturare nel Main
5) Descrivere la soluzione finale

La presentazione sarà oggetto di valutazione e sarà effettuata tramite meet.
Per la presentazione si lascia libera scelta sugli strumenti da utilizzare, a patto che sia presentabile tramite meet. 

***

#### STRUTTURA

1. **Classi Astratte per Models:** Eliminare codice duplicato, semplificare la manutenzione e modifica delle classi
   1. *Item.java* (Student.java, Professor.java, Course.java)
   2. *CombinationItem.java* (Enrollment.java, Grade.java)
2. **Interfacce per Repositories:** Definizione del contratto per gestire due tipologie di oggetti "Repository" diversi
   1. *IRepository<T, ID>.java* (Student.java, Professor.java, Course.java, Classroom.java) ---> identificate da un solo Id anche di tipo diverso (int, String)
   2. *ICombinationRrepository<T extends CombinationItem>.java* (Enrollment.java, Grade.java) ---> identificate da due Id combinati
3. **Classi Astratte per Repository:** Utilizzate per definire un'implementazione comune cosi da non scrivere gli stessi metodi per classi "Repository" diverse.
   1. *AbstractRepository<T, ID>.java* (Student.java, Professor.java, Course.java, Classroom.java)
   2. *AbstractCombinationRepository<T extends CombinationItem>.java* (Enrollment.java, Grade.java)
4. **Interfacce per Services:** Definizione del contratto per gestire due tipologie di oggetti "Service" diversi
   1. *IService<T, ID>.java* (Student.java, Professor.java, Course.java, Classroom.java)
   2. *ICombinationService<T extends CombinationItem>.java* (Enrollment.java, Grade.java)
5. **Classi Astratte per Services:** Utilizzate per definire un'implementazione comune cosi da non scrivere gli stessi metodi per classi "Service" diverse.
   1. *AbstractService<T, ID>.java* (Student.java, Professor.java, Course.java, Classroom.java)
   2. *AbstractCombinationService<T extends CombinationItem>.java* (Enrollment.java, Grade.java)

***

#### SCELTE IMPLEMENTATIVE
##### La revisione del codice ha consistito nell'adottare le seguenti scelte implementative per presentare un migliore prodotto, più elegante, dinamico e manutenibile.
1. **Introduzione delle Classi Astratte**</br>Abbiamo deciso di introdurla per centralizzare la logica comune evitando di duplicare il codice e, allo stesso tempo, obbligare le sottoclassi ad implementare i metodi che necessitano di maggiori specifiche legate al tipo specifico degli oggetti. Lavorano spesso in parallelo, con le interfacce.

2. **Introduzione delle Interfacce**</br>Introdurre l'utilizzo di interfacce nel proprio codice permette di definire un "contratto", ovvero definire quello che una classe, che implementa una determinata interfaccia, debba avere in termini di metodi. Questa scelta aumenta la modularita del codice, permettendo un aggiunta (tipo plug-n-play) di altre classi che implementano la stessa interfaccia.

3. **Utilizzo dei Generics**</br>L'utilizzo dei generics permette di "parametrizzare" una classe o un metodo, seguendo le specifiche di un tipo predefinito (come int, String, ...) oppure di un tipo personalizzato (quindi una classe creata da noi). I generics aumentano anche la flessibilità del codice e la duplicazione di metodi.</br>Nel nostro caso, per interfacce e classi astratte, legate alla gestione degli oggetti identificati con la combinazione di due Id (Enrollment e Grade), abbiamo optato per adottare la pratica del *type safety* in modo da condizionare l'interfaccia o la classe astratta all'utilizzo di sottoclassi di "CombinationItem" predefinendo i tipi di oggetti con cui andranno a interfacciarsi

4. **Gestione degli errori con le Eccezioni**</br>L'uso delle eccezioni serve per identificare quei casi in cui il codice avrebbe un comportamento anomalo. Nel nostro caso specifico abbiamo deciso di raggrupparle tutte come classi statiche dentro un unico file *Exceptions.java* per evitare di disperderle in singoli file nel progetto, mantenendo la struttura più ordinata e pulita.</br>Abbiamo deciso anche, di personalizzare i nomi per rendere più parlante l'eccezione, spiegando immediatamente l'origine dell'errore.

5. **Utilizzo dell'interfaccia per dichiarare i repository**</br>Viene utilizzata per dinamizzare il software, ovvero, in questo modo, qualora volessi cambiare implementazione di un repository, a parità di interfaccia, posso farlo. Quindi non lego l'istanziazione del repository alla sua specifica classe.

6. **Aggiunta del pattern Singleton**</br>Questa tecnica è molto efficace per evitare molteplici istanze dei services, ognuno collegato alla propria entità di riferimento. In questo modo evitiamo di avere più liste che contengono lo stesso tipo di dato minimizzando l'inconsistenza dei dati.

7. **Salvataggio dei dati in un file JSON**</br>Questa implementazione è una *feature* aggiuntiva, scelta per garantire la persistenza dei dati anche al di fuori dell'esecuzione del programma (runtime). I dati sono organizzasi secondo il formato standard JSON (JavaScript Object Notation). Ogni repository scrive in un file dedicato quindi alla fine del processo avremo tanti file quanti sono i repository che immagazzinano gli InMemoryData.
