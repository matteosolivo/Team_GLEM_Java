package it.university.repository;

import it.university.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor, Integer> {

    @Override
    protected Integer extractId(Professor professor) {
        return professor.getId();
    }
}
