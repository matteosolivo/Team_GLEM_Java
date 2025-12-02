package it.university.service;

import it.university.model.Enrollment;
import it.university.repository.EnrollmentRepository;
import java.util.List;

//L'enrollmentservice gestisce un oggetto di tipo EnrollmentRepository
public class EnrollmentService {
    
    private EnrollmentRepository repo = new EnrollmentRepository();

    //Questo metodo invoca save() di EnrollmentRepository, che a sua volta chiama add() di List, in modo da inserire un oggetto Enrollment nel repository 
    public void enrollStudent(Enrollment e) { repo.save(e); }

    //Questo metodo utilizza findAll() di EnrollmentRepository per restituire la lista intera, solo se la lista non è vuota
    public List<Enrollment> list() { 
        if (repo.findAll().isEmpty()){
            System.out.println("Nessuna iscrizione trovata");
        }
        return repo.findAll(); 
    }

    //Invoca exists() di EnrollmentRepository per verificare la presenza di un'iscrizione nel repository
    public boolean isEnrolled(int studentId, int courseId) { return repo.exists(studentId, courseId); }
}
