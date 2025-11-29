package it.university.repository;

import java.util.ArrayList;
import java.util.List;

import it.university.model.Enrollment;

public class EnrollmentRepository implements ICollectionRepository<Enrollment>{
	
	private static EnrollmentRepository istance;
	
    private final List<Enrollment> enrollments = new ArrayList<>();

    private EnrollmentRepository() {
    	System.out.println("Enrollment Repository creato");
    }
    
    public static EnrollmentRepository getIstance() {
    	if(istance == null) {
    		istance = new EnrollmentRepository();
    	}
    	return istance;
    }
    
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
