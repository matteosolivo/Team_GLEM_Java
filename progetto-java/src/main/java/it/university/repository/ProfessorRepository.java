package it.university.repository;

import it.university.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor, Integer> {

	private static ProfessorRepository istance;
	
	private ProfessorRepository() {
		System.out.println("Professor Repository creato");
	}
	
	public static ProfessorRepository getIstance() {
		if(istance == null) {
			istance = new ProfessorRepository();
		}
		return istance;
	}
	
    @Override
    protected Integer extractId(Professor professor) {
        return professor.getId();
    }
}
