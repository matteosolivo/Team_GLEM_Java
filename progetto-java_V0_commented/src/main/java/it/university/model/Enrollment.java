package it.university.model;

//L'iscrizione è composta dall'Id dello studente e dall'Id del corso di studi

public class Enrollment {
    private int studentId;
    private int courseId;

    public Enrollment(int studentId, int courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    public int getStudentId() { return studentId; }
    public int getCourseId() { return courseId; }

    @Override
    public String toString() {
        return "Enrollment{student=" + studentId + ", course=" + courseId + "}";
    }
}
