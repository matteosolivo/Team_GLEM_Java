package it.university;

import it.university.model.Classroom;
import it.university.model.Course;
import it.university.model.Enrollment;
import it.university.model.Grade;
import it.university.model.Professor;
import it.university.model.Student;
import it.university.repository.ClassroomRepository;
import it.university.repository.CourseRepository;
import it.university.repository.EnrollmentRepository;
import it.university.repository.GradeRepository;
import it.university.repository.ICollectionRepository;
import it.university.repository.IRepository;
import it.university.repository.ProfessorRepository;
import it.university.repository.StudentRepository;
import it.university.service.ClassroomService;
import it.university.service.CourseService;
import it.university.service.EnrollmentService;
import it.university.service.GradeService;
import it.university.service.ProfessorService;
import it.university.service.StudentService;

public class MainApp {
    public static void main(String[] args) throws Exception {

        IRepository<Student, Integer> studentRepository = new StudentRepository();
        IRepository<Professor, Integer> professorRepository = new ProfessorRepository();
        IRepository<Course, Integer> courseRepository = new CourseRepository();
        IRepository<Classroom, String> classroomRepository = new ClassroomRepository();
        ICollectionRepository<Enrollment> enrollmentRepository = new EnrollmentRepository();
        ICollectionRepository<Grade> gradeRepository = new GradeRepository();
        
        StudentService studentService = StudentService.getIstance(studentRepository);
        ProfessorService professorService = ProfessorService.getIstance(professorRepository);
        CourseService courseService = CourseService.getIstance(courseRepository);
        ClassroomService classroomService = ClassroomService.getIstance(classroomRepository);
        EnrollmentService enrollmentService = EnrollmentService.getIstance(enrollmentRepository);
        GradeService gradeService = GradeService.getIstance(gradeRepository);
        
        System.out.println("Studenti:");
        studentService.list().forEach(System.out::println);

        studentService.registerStudent(new Student(1, "Alice", "alice@mail.com"));
        studentService.registerStudent(new Student(2, "Bob", "bob@mail.com"));
        
        System.out.println("\nStudenti:");
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
        courseService.assignProfessor(1, 1);

        System.out.println("\nCorsi:");
        courseService.list().forEach(System.out::println);


        System.out.println("\nAule:");
        classroomService.list().forEach(System.out::println);

        classroomService.save(new Classroom("A101", 30));

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


        // SALVATAGGIO DATI SU FILE JSON
        String path = "src\\main\\java\\it\\university\\download\\";
        studentService.saveToJson(path + "students.json");
        professorService.saveToJson(path + "professors.json");
        courseService.saveToJson(path + "courses.json");
        classroomService.saveToJson(path + "classrooms.json");
        enrollmentService.saveToJson(path + "enrollments.json");
        gradeService.saveToJson(path + "grades.json");

    }
}

/*
DA IMPLEMENTARE NEL FUTURO:
- Gestione delle eccezioni (Luca)
*/
