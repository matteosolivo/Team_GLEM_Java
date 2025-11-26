package it.university.service;

import java.util.List;

import it.university.model.Professor;
import it.university.repository.IRepository;

public class ProfessorService extends AbstractService<Professor, Integer> {

    public ProfessorService(IRepository<Professor, Integer> professorRepository) {
        super(professorRepository);
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
