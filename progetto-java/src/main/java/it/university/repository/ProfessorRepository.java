package it.university.repository;

import it.university.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor> {

    @Override
    public int getItemId(Professor professor) {
        return professor.getId();
    }
}
