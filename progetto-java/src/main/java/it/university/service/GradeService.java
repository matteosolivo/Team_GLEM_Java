package it.university.service;

import java.util.List;

import it.university.model.Grade;
import it.university.repository.GradeRepository;

public class GradeService {

	private static GradeService istance;
	
    private final GradeRepository gradeRepository;

    private GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public static GradeService getIstance(GradeRepository gradeRepository) {
    	if(istance == null) {
    		istance = new GradeService(gradeRepository);
    	}
    	return istance;
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
