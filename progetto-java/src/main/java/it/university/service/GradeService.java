package it.university.service;

import java.util.List;

import it.university.model.Grade;
import it.university.repository.GradeRepository;

public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public void add(Grade grade) {
        gradeRepository.save(grade);
    }

    public List<Grade> list() {
        List<Grade> gradesList = gradeRepository.findAll();
        if (gradesList.isEmpty()) {
            System.out.println("Nessun voto registrato");
        } 
        return gradesList; 
    }
}
