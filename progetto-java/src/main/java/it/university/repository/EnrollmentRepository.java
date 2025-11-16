package it.university.repository;

import it.university.model.Enrollment;
import java.util.*;

public class EnrollmentRepository {
    private List<Enrollment> enrollments = new ArrayList<>();

    public void save(Enrollment e) { 
        enrollments.add(e); 
    }
    
    public List<Enrollment> returnAll() { 
        return enrollments;
    }

    public boolean exists(int studentId, int courseId) {
        return enrollments.stream().anyMatch(en -> en.getStudent().getId() == studentId && en.getCourseId().getId() == courseId);
    }
}
