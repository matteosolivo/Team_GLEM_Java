package it.university.repository;

import it.university.model.Professor;

public class ProfessorRepository extends AbstractRepository<Professor, Integer> {

    // OTTIENE L'ID UNIVOCO DEL PROFESSORE (Integer Id)
    @Override
    public Integer getItemId(Professor professor) {
        return professor.getId();
    }
}
