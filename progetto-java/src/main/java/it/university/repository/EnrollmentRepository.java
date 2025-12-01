package it.university.repository;

import it.university.model.Enrollment;

public class EnrollmentRepository extends AbstractCollectionRepository<Enrollment> {

    @Override
    protected String getItemId(Enrollment enrollment) {
        return enrollment.getStudentId() + " - " + enrollment.getCourseId();
    }
}
