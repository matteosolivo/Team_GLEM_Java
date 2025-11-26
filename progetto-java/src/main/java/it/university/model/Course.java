package it.university.model;

public class Course extends Item{
    private Integer credits;
    private Integer professorId; // optional assignment

    public Course(Integer id, String name, Integer credits) {
        this.id = id;
        this.name = name;
        this.credits = credits;
    }

    public Integer getCredits() { return credits; }
    public Integer getProfessorId() { return professorId; }
    public void setProfessorId(Integer professorId) { this.professorId = professorId; }

    @Override
    public String toString() {
        return "Course{" + id + ", " + name + ", " + credits + " CFU, prof=" + professorId + "}";
    }
}
