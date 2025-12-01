package it.university.repository;

import it.university.model.Classroom;

public class ClassroomRepository extends AbstractRepository<Classroom, String> {

    @Override
    protected String getItemId(Classroom classroom) {
        return classroom.getCode();
    }
}
