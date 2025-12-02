package it.university.model;

public class Professor extends Item {

    private String department;

    public Professor(int id, String name, String department) {
        super(id, name);
        this.department = department;
    }

    // GETTERS
    public String getDepartment() {
        return department;
    }

    // SETTERS
    public void setEmail(String department) {
        this.department = department;
    }

    // METODO TO STRING SOVRASCRITTO DELLA CLASSE PADRE (ASTRATTA)
    @Override
    public String toString() {
        return "Professor{" + id + ", " + name + ", dept=" + department + "}";
    }
}
