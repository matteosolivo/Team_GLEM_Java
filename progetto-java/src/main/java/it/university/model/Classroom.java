package it.university.model;

public class Classroom {

    private String code;
    private int capacity;

    public Classroom(String code, int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("La capacità non può essere negativa: " + capacity);
        }
        this.code = code;
        this.capacity = capacity;
    }

    // GETTERS
    public String getCode() {
        return code;
    }

    public int getCapacity() {
        return capacity;
    }

    // SETTERS
    public void setCode(String code) {
        this.code = code;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    // METODO TO STRING SOVRASCRITTO DELLA CLASSE PADRE (ASTRATTA)
    @Override
    public String toString() {
        return "Classroom{" + code + ", capacity=" + capacity + "}";
    }
}
