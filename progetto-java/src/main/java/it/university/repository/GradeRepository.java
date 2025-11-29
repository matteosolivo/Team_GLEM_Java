package it.university.repository;

import java.util.ArrayList;
import java.util.List;

import it.university.model.Grade;

public class GradeRepository implements ICollectionRepository<Grade>{
    
	private static GradeRepository istance;
	
	private final List<Grade> grades = new ArrayList<>();

    private GradeRepository() {
    	System.out.println("Grade Repository creato");
    }
    
    public static GradeRepository getIstance() {
    	if(istance == null) {
    		istance = new GradeRepository();
    	}
    	return istance;
    }
    
    @Override
    public void save(Grade grade) {
        grades.add(grade);
    }
    
    @Override
    public List<Grade> findAll() {
        return new ArrayList<>(grades);

    }
}
