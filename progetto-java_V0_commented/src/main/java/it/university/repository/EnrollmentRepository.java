package it.university.repository;

import it.university.model.Enrollment;
import java.util.*;

//Il repository delle iscrizioni è un'arraylist

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    //save aggiunge un'iscrizione alla lista di iscrizioni
    public void save(Enrollment e) { enrollments.add(e); }

    //findAll ti restituisce l'intera lista di iscrizioni
    public List<Enrollment> findAll() { return enrollments; }

    //exists verifica che sia presente una specifica iscrizione dati un studentId e un courseId
    public boolean exists(int studentId, int courseId) {
        return enrollments.stream().anyMatch(en -> en.getStudentId() == studentId && en.getCourseId() == courseId);
    }
}
