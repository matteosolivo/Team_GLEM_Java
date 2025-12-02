package it.university.repository;

import it.university.model.Enrollment;
import java.util.*;

//Gestisce una lista contenente le iscrizioni (oggetti di tipo Enrollment)
public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    //Questo metodo aggiunge un enrollment alla lista tramite il metodo add(), metodo di List
    public void save(Enrollment e) { enrollments.add(e); }

    //Questo metodo restituisce tutta la lista
    public List<Enrollment> findAll() { return enrollments; }

    //Questo metodo controlla se nella lista è presente un enrollment con studentId e courseId passati come parametro
    public boolean exists(int studentId, int courseId) {
        return enrollments.stream().anyMatch(en -> en.getStudentId() == studentId && en.getCourseId() == courseId);
    }
}
