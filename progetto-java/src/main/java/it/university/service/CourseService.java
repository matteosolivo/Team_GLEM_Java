package it.university.service;

import java.util.List;

import it.university.model.Course;
import it.university.repository.IRepository;

public class CourseService extends AbstractService<Course, Integer> {

    private static CourseService istance;

    // Private COSI SOLO DAL SERVICE SI PUO' ACCEDERE AL REPOSITORY
    private CourseService(IRepository<Course, Integer> repository) {
        super(repository);
    }

    // METODO PER OTTENERE L'ISTANZA DEL SERVICE (SINGLETON)
    public static CourseService getIstance(IRepository<Course, Integer> repository) {
        if (istance == null) {
            istance = new CourseService(repository);
        }
        return istance;
    }

    // METODO PER CREARE UN NUOVO CORSO
    public void createCourse(Course course) {
        save(course);
    }

    // METODO PER ASSEGNARE UN PROFESSORE AD UN CORSO E CONTROLLARE SE IL CORSO ESISTE
    public void assignProfessor(int courseId, int professorId) {
        Course course = findById(courseId);

        if (course != null) {
            course.setProfessorId(professorId); // optional assignment
        } else {
            System.out.println("Corso non trovato con id " + courseId);
        }
    }

    // OVERRIDE DEL METODO LIST PER GESTIONE MESSAGGIO CORSO VUOTO
    @Override
    public List<Course> list() {

        List<Course> coursesList = super.list();
        if (coursesList.isEmpty()) {
            System.out.println("Nessun corso trovato");
        }
        return coursesList;
    }
}
