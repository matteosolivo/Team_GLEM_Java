package it.university.repository;

import it.university.model.Grade;
import java.util.*;

public class GradeRepository {
    //CREA UNA LIST DI OGGETTI DI TIPO GRADE
    private List<Grade> grades = new ArrayList<>();

    public void save(Grade g) { grades.add(g); } //SALVA UN OGGETTO GRADE AGGIUNGENDOLO ALLA LIST
    public List<Grade> findAll() { return grades; } //RITORNA LA LIST DI OGGETTI GRADE
}
