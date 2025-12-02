package it.university.repository;

import it.university.model.Grade;

public class GradeRepository extends AbstractCombinationRepository<Grade> {

    // OTTIENE L'ID UNIVOCO DEL VOTO (COMBINAZIONE DI STUDENTID E COURSEID). UTILE PER LA STAMPA
    @Override
    protected String getItemId(Grade grade) {
        return grade.getStudentId() + " - " + grade.getCourseId();
    }
}
