package it.university.model;

public class Enrollment {
    
    private Student student;
    private Course course;

    public Enrollment(Student s, Course c) {
        this.student = s;
        this.course = c;
    }

    public Student getStudent() {
        return student;
    }
    
    public Course getCourseId() {
        return course;
    }

    @Override
    public String toString() {
        return "Iscrizione\n{Studente: " + student.getName() + ", corso di studi: " + course.getName() + "}";
    }
}
