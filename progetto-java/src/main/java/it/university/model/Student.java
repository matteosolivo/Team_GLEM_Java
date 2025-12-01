package it.university.model;

public class Student extends Item {

    private String email;

    public Student(int id, String name, String email) {
        super(id, name);
        this.email = email;
    }

    // GETTERS
    public String getEmail() {
        return email;
    }

    // SETTERS
    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Student{" + id + ", " + name + ", " + email + "}";
    }
}
