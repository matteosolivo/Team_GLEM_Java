package it.university.model;

public class Course extends Item {

    private int credits;
    private Integer professorId; // optional assignment

    public Course(int id, String name, int credits) {
        super(id, name);
        this.credits = credits;
    }

    // GETTERS
    public int getCredits() {
        return credits;
    }

    public Integer getProfessorId() {
        return professorId;
    }

    // SETTERS
    public void setCredits(int credits) {
        this.credits = credits;
    }

    public void setProfessorId(Integer professorId) {
        this.professorId = professorId;
    }

    @Override
    public String toString() {
        return "Course{" + id + ", " + name + ", " + credits + " CFU, prof=" + professorId + "}";
    }
}
