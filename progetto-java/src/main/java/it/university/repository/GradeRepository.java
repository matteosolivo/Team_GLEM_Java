package it.university.repository;

import java.util.ArrayList;
import java.util.List;

import it.university.model.Grade;

public class GradeRepository implements ICollectionRepository<Grade>{
    private final List<Grade> grades = new ArrayList<>();

    @Override
    public void save(Grade grade) {
        grades.add(grade);
    }
    
    @Override
    public List<Grade> findAll() {
        return new ArrayList<>(grades);

    }
}
