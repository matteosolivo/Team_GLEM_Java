package it.university.model;

public class Enrollment extends CombinationItem {

    public Enrollment(Integer studentId, Integer courseId) {
        super(studentId, courseId);
    }

    // METODO TO STRING SOVRASCRITTO DELLA CLASSE PADRE (ASTRATTA)
    @Override
    public String toString() {
        return "Enrollment{student=" + studentId + ", course=" + courseId + "}";
    }
}
