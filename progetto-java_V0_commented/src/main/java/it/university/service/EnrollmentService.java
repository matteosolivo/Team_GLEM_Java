package it.university.service;

import it.university.model.Enrollment;
import it.university.repository.EnrollmentRepository;
import java.util.List;

//EnrollmentService è la classe con cui si può agire sul repository
//(io nel main non credo un repo. creo un service con cui agisco su un repo a cui non posso altrimenti accedere in maniera diretta)

public class EnrollmentService {
    private EnrollmentRepository repo = new EnrollmentRepository();

    //enrollStudent inserisce un enrollment nella lista all'interno dell'oggetto repository repo
    public void enrollStudent(Enrollment e) { repo.save(e); }
    
    //list utilizza findAll dal repository per restituire la lista intera di iscrizioni
    public List<Enrollment> list() { 
        if (repo.findAll().isEmpty()){
            System.out.println("Nessuna iscrizione trovata");
        }
        return repo.findAll(); 
    }

    //controlla se esiste nel repository un'iscrizione con un certo studentId e courseId
    public boolean isEnrolled(int studentId, int courseId) { return repo.exists(studentId, courseId); }
}
