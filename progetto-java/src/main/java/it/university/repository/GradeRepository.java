package it.university.repository;

import it.university.model.Grade;

public class GradeRepository extends AbstractCollectionRepository<Grade> {

    @Override
    protected String getItemId(Grade grade) {
        return grade.getStudentId() + " - " + grade.getCourseId();
    }
}
