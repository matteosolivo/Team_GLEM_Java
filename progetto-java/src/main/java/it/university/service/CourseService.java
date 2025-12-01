package it.university.service;

import java.util.List;

import it.university.model.Course;
import it.university.repository.IRepository;

public class CourseService extends AbstractService<Course, Integer> {

    private static CourseService istance;

    private CourseService(IRepository<Course, Integer> repository) {
        super(repository);
    }

    public static CourseService getIstance(IRepository<Course, Integer> repository) {
        if (istance == null) {
            istance = new CourseService(repository);
        }
        return istance;
    }

    public void createCourse(Course course) {
        save(course);
    }

    public void assignProfessor(int courseId, int professorId) {
        Course course = findById(courseId);

        if (course != null) {
            course.setProfessorId(professorId);
        } else {
            System.out.println("Corso non trovato con id " + courseId);
        }
    }

    @Override
    public List<Course> list() {

        List<Course> coursesList = super.list();
        if (coursesList.isEmpty()) {
            System.out.println("Nessun corso trovato");
        }
        return coursesList;
    }
}
