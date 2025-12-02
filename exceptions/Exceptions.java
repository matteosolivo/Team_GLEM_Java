package it.university.exceptions;

public class Exceptions {
    // ECCEZIONE PER OGGETTO DUPLICATO
    public static class DuplicateException extends RuntimeException {
        public DuplicateException(String errore) {
            super(errore);
        }
    }

    // ECCEZIONE PER OGGETTO NON TROVATO
    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String errore) {
            super(errore);
        }
    }

    // ECCEZIONE PER FILE NON TROVATO
    public static class FileSaveException extends RuntimeException {
        public FileSaveException(String errore, Throwable cause) {
            super(errore, cause);
        }
    }
}
/*
1. Definizione (Come sono strutturate le eccezioni)
Tutte le eccezioni sono definite come classi statiche interne nel file Exceptions.java. Estendono tutte RuntimeException (sono quindi unchecked), il che ti permette di decidere liberamente dove catturarle senza obblighi rigidi del compilatore.
Sono divise in tre categorie:
    • DuplicateException: Segnala che stai provando a salvare un oggetto con un ID già esistente.
    • ItemNotFoundException: Segnala che una ricerca per ID non ha prodotto risultati.
    • FileSaveException: È un "wrapper". Serve a catturare errori tecnici di sistema (come IOException durante il salvataggio file) e trasformarli in un errore del tuo programma, mantenendo però la causa originale (Throwable cause) per il debugging.
2. Innesco (Chi le lancia)
È il Repository Layer a lanciare le eccezioni, agendo come "guardiano" dei dati:
    • Il metodo save() controlla se l'elemento esiste: se sì, lancia DuplicateException.
    • Il metodo findById() cerca l'elemento: se il ciclo finisce senza trovarlo, lancia ItemNotFoundException.
    • Il metodo saveToJson() prova a scrivere su disco: se fallisce, cattura l'errore di Java e lancia una FileSaveException.
3. Gestione (Chi le risolve)
È il Service Layer a decidere come reagire agli errori, proteggendo il Main dai crash improvvisi:
    • Per i duplicati: Il metodo add cattura la DuplicateException e stampa un messaggio di errore rosso (System.err), permettendo al programma di continuare l'esecuzione con gli altri inserimenti.
    • Per le ricerche fallite: Il metodo findById cattura la ItemNotFoundException, stampa un errore e restituisce null.
    • Per i file: Il metodo saveToJson cattura la FileSaveException ma la stampa solo come errore, oppure in alcuni casi (come definito nelle interfacce) lascia che l'eccezione risalga fino al main.
In sintesi, questa struttura di eccezioni ti permette di gestire gli errori in modo chiaro e organizzato, separando la logica di rilevamento degli errori (Repository) dalla logica di gestione degli errori (Service), mantenendo il Main pulito e focalizzato sul flusso principale dell'applicazione.
*/
