package it.university;

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

        //Inizializzazione dei singoli Service
        StudentService studentService = new StudentService();
        ProfessorService professorService = new ProfessorService();
        CourseService courseService = new CourseService();
        ClassroomService classroomService = new ClassroomService();
        EnrollmentService enrollmentService = new EnrollmentService();
        GradeService gradeService = new GradeService();

        /*In questa parte, utilizzando i rispettivi service, viene fatta una prima
        stampa di ogni repository, vengono inseriti uno o più oggetti nel repository
        e viene rifatta la stampa una volta finito l'inserimento*/
        
        System.out.println("Studenti:");
        studentService.list().forEach(System.out::println);

        studentService.registerStudent(new Student(1, "Alice", "alice@mail.com"));
        studentService.registerStudent(new Student(2, "Bob", "bob@mail.com"));
        
        System.out.println("Studenti:");
        studentService.list().forEach(System.out::println);


        System.out.println("\nProfessori:");
        professorService.list().forEach(System.out::println);

        professorService.add(new Professor(1, "Dr. Rossi", "Informatica"));
        
        System.out.println("\nProfessori:");
        professorService.list().forEach(System.out::println);


        System.out.println("\nCorsi:");
        courseService.list().forEach(System.out::println);

        courseService.createCourse(new Course(1, "Programmazione", 9));
        courseService.createCourse(new Course(2, "Basi di Dati", 6));
        //Oltre all'inserimento nel repository dei corsi, viene anche assegnato al corso con indice 0 nel repository dei corsi il professore con id 1
        courseService.assignProfessor(courseService.list().get(0), 1);

        System.out.println("\nCorsi:");
        courseService.list().forEach(System.out::println);


        System.out.println("\nAule:");
        classroomService.list().forEach(System.out::println);

        classroomService.add(new Classroom("A101", 30));

        System.out.println("\nAule:");
        classroomService.list().forEach(System.out::println);


        System.out.println("\nIscrizioni:");
        enrollmentService.list().forEach(System.out::println);

        enrollmentService.enrollStudent(new Enrollment(1,1));
        enrollmentService.enrollStudent(new Enrollment(2,1));

        System.out.println("\nIscrizioni:");
        enrollmentService.list().forEach(System.out::println);



        System.out.println("\nVoti:");
        gradeService.list().forEach(System.out::println);

        gradeService.add(new Grade(1,1,28));

        System.out.println("\nVoti:");
        gradeService.list().forEach(System.out::println);
        
    }
}
