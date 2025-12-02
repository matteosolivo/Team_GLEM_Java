package it.university.repository;

import it.university.model.Classroom;

public class ClassroomRepository extends AbstractRepository<Classroom, String> {

    // OTTIENE L'ID UNIVOCO DELL'AULA (String CODE)
    @Override
    protected String getItemId(Classroom classroom) {
        return classroom.getCode();
    }
}
