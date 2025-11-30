package it.university.model;

public class Student extends Item {
    private String email;

    public Student(int id, String name, String email) {
        this.id = id;
        this.name = name;
        this.email = email;
    }

    public String getEmail() { return email; }

    @Override
    public String toString() {
        return "Student{" + id + ", " + name + ", " + email + "}";
    }
}
