package it.university.service;

import java.util.List;

import it.university.model.Enrollment;
import it.university.repository.EnrollmentRepository;

public class EnrollmentService {

	private static EnrollmentService istance;
	
    private static EnrollmentRepository enrollmentRepository;
    
    private EnrollmentService(EnrollmentRepository enrollmentRepository) {
        this.enrollmentRepository = enrollmentRepository;
    }
    
    public static EnrollmentService getIstance(EnrollmentRepository enrollmentRepository) {
    	if(istance == null) {
    		istance = new EnrollmentService(enrollmentRepository);
    	}
    	return istance;
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
