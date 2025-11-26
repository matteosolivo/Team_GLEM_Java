package it.university.repository;

import java.util.ArrayList;
import java.util.List;

import it.university.model.Enrollment;

public class EnrollmentRepository implements ICollectionRepository<Enrollment>{
    private final List<Enrollment> enrollments = new ArrayList<>();

    @Override
    public void save(Enrollment enrollment) {
        enrollments.add(enrollment);
    }

    @Override
    public List<Enrollment> findAll() {
        return new ArrayList<>(enrollments);
    }

    public boolean exists(int studentId, int courseId) {
        return enrollments.stream().anyMatch(en -> en.getStudentId() == studentId && en.getCourseId() == courseId);
    }
}
