package it.university;

//Qui ci sono gli import

import it.university.model.Classroom;
import it.university.model.Course;
import it.university.model.Enrollment;
import it.university.model.Grade;
import it.university.model.Professor;
import it.university.model.Student;
import it.university.service.ClassroomService;
import it.university.service.CourseService;
import it.university.service.EnrollmentService;
import it.university.service.GradeService;
import it.university.service.ProfessorService;
import it.university.service.StudentService;

public class MainApp {
    public static void main(String[] args) {

        /*Nella prima parte del main vengono attivati i "service" tramite il quale si può accedere
        a diverse funzionalità
         */
        
        StudentService studentService = new StudentService();
        ProfessorService professorService = new ProfessorService();
        CourseService courseService = new CourseService();
        ClassroomService classroomService = new ClassroomService();
        EnrollmentService enrollmentService = new EnrollmentService();
        GradeService gradeService = new GradeService();
        
        //inserimento e stampa con studentService

        System.out.println("Studenti:");
        studentService.list().forEach(System.out::println);

        studentService.registerStudent(new Student(1, "Alice", "alice@mail.com"));
        studentService.registerStudent(new Student(2, "Bob", "bob@mail.com"));
        
        System.out.println("Studenti:");
        studentService.list().forEach(System.out::println);

        //inserimento e stampa con professorService

        System.out.println("\nProfessori:");
        professorService.list().forEach(System.out::println);

        professorService.add(new Professor(1, "Dr. Rossi", "Informatica"));
        
        System.out.println("\nProfessori:");
        professorService.list().forEach(System.out::println);

        //inserimento e stampa con courseService

        System.out.println("\nCorsi:");
        courseService.list().forEach(System.out::println);

        courseService.createCourse(new Course(1, "Programmazione", 9));
        courseService.createCourse(new Course(2, "Basi di Dati", 6));
        courseService.assignProfessor(courseService.list().get(0), 1);

        System.out.println("\nCorsi:");
        courseService.list().forEach(System.out::println);

        //inserimento e stampa con classroomService

        System.out.println("\nAule:");
        classroomService.list().forEach(System.out::println);

        classroomService.add(new Classroom("A101", 30));

        System.out.println("\nAule:");
        classroomService.list().forEach(System.out::println);

        //inserimento e stampa con enrollmentService

        System.out.println("\nIscrizioni:");
        enrollmentService.list().forEach(System.out::println);

        enrollmentService.enrollStudent(new Enrollment(1,1));
        enrollmentService.enrollStudent(new Enrollment(2,1));

        System.out.println("\nIscrizioni:");
        enrollmentService.list().forEach(System.out::println);

        //inserimento e stampa con gradeService

        System.out.println("\nVoti:");
        gradeService.list().forEach(System.out::println);

        gradeService.add(new Grade(1,1,28));

        System.out.println("\nVoti:");
        gradeService.list().forEach(System.out::println);
        
    }
}
