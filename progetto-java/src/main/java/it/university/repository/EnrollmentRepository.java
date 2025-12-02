package it.university.repository;

import it.university.model.Enrollment;

public class EnrollmentRepository extends AbstractCombinationRepository<Enrollment> {

    // OTTIENE L'ID UNIVOCO DELL'ISCRIZIONE (COMBINAZIONE DI STUDENTID E COURSEID). UTILE PER LA STAMPA
    @Override
    protected String getItemId(Enrollment enrollment) {
        return enrollment.getStudentId() + " - " + enrollment.getCourseId();
    }
}
