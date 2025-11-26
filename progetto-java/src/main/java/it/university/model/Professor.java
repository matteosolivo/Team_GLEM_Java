package it.university.model;

public class Professor extends Item{
    private String department;

    public Professor(int id, String name, String department) {
        this.id = id;
        this.name = name;
        this.department = department;
    }

    public String getDepartment() { return department; }

    @Override
    public String toString() {
        return "Professor{" + id + ", " + name + ", dept=" + department + "}";
    }
}
