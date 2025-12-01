package it.university.model;

public class Classroom {

    private String code;
    private int capacity;

    public Classroom(String code, int capacity) {
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

    @Override
    public String toString() {
        return "Classroom{" + code + ", capacity=" + capacity + "}";
    }
}
