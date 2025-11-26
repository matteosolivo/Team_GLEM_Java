package it.university.service;

import java.util.List;

import it.university.model.Course;
import it.university.repository.IRepository;

public class CourseService extends AbstractService<Course, Integer> {

    public CourseService(IRepository<Course, Integer> repository) {
        super(repository);
    }

    public void createCourse(Course course) {
        save(course);
    }

    public void assignProfessor(int courseId, int professorId) {
        Course course = getById(courseId);
        
        if (course != null) {
            course.setProfessorId(professorId);
            repository.save(course);
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
