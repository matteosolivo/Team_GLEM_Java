package it.university.model;

public class Enrollment extends CollectionItem {

    public Enrollment(Integer studentId, Integer courseId) {
        super(studentId, courseId);
    }

    @Override
    public String toString() {
        return "Enrollment{student=" + studentId + ", course=" + courseId + "}";
    }
}
