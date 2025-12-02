package it.university.model;

// CLASSE ASTRATTA PER RAPPRESENTARE GLI OGGETTI CHE COMBINANO DUE ID (studenteId E corsoId)
public abstract class CombinationItem {

    protected Integer studentId;
    protected Integer courseId;

    public CombinationItem(Integer studentId, Integer courseId) {
        this.studentId = studentId;
        this.courseId = courseId;
    }

    // GETTERS
    public Integer getStudentId() {
        return studentId;
    }

    public Integer getCourseId() {
        return courseId;
    }

    // SETTERS
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

}
