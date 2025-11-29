package it.university.service;

import java.util.List;

import it.university.model.Professor;
import it.university.repository.IRepository;

public class ProfessorService extends AbstractService<Professor, Integer> {

	private static ProfessorService istance;
	
    private ProfessorService(IRepository<Professor, Integer> professorRepository) {
        super(professorRepository);
    }
    
    public static ProfessorService getIstance(IRepository<Professor, Integer> professorRepository) {
    	if(istance == null) {
    		istance = new ProfessorService(professorRepository);
    	}
    	return istance;
    }

    public void add(Professor professor) {
        save(professor);
    }

    @Override
    public List<Professor> list() {
        List<Professor> professorsList = super.list();
        
        if (professorsList.isEmpty()) {
            System.out.println("Nessun professore presente");
        }
        return professorsList;
    }
}
