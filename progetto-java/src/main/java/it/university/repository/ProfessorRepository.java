package it.university.repository;

import it.university.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor, Integer> {

    @Override
    public Integer getItemId(Professor professor) {
        return professor.getId();
    }
}
