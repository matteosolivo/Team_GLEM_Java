package it.university.model;

public class Enrollment extends DerivedItem{
   
    public Enrollment(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    @Override
    public String toString() {
        return "Enrollment{student=" + studentId + ", course=" + courseId + "}";
    }
}
