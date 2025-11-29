package it.university.repository;

import it.university.model.Course;

public class CourseRepository extends AbstractRepository<Course, Integer> {

	private static CourseRepository istance;
	
	private CourseRepository() {
		System.out.println("Course Repository creato");
	}
	
	public static CourseRepository getIstance() {
		if(istance == null) {
			istance = new CourseRepository();
		}
		return istance;
	}
	
    @Override
    protected Integer extractId(Course course) {
        return course.getId();
    }
}

