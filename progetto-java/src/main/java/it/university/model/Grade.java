package it.university.model;

public class Grade extends CombinationItem {

    private int value;

    public Grade(int studentId, int courseId, int value) {
        super(studentId, courseId);
        this.value = value;
    }

    // GETTERS
    public int getValue() {
        return value;
    }

    // SETTERS
    public void setValue(int value) {
        this.value = value;
    }

    // METODO TO STRING SOVRASCRITTO DELLA CLASSE PADRE (ASTRATTA)
    @Override
    public String toString() {
        return "Grade{student=" + studentId + ", course=" + courseId + ", value=" + value + "}";
    }
}
