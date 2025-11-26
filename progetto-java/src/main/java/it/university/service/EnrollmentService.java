package it.university.service;

import java.util.List;

import it.university.model.Enrollment;
import it.university.repository.EnrollmentRepository;

public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;

    public EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }

    public void enrollStudent(Enrollment enrollment) {
        enrollmentRepository.save(enrollment);
    }

    public List<Enrollment> list() { 
        List<Enrollment> enrollmentsList = enrollmentRepository.findAll();

        if (enrollmentsList.isEmpty()) {
            System.out.println("Nessuna iscrizione presente");
        }
        return enrollmentsList;
    }

    public boolean isEnrolled(int studentId, int courseId) {
        return enrollmentRepository.exists(studentId, courseId);
    }
}
