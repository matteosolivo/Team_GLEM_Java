package it.university.repository;

import it.university.model.Student;

public class StudentRepository extends AbstractRepository<Student, Integer> {

    // OTTIENE L'ID UNIVOCO DELLO STUDENTE (Integer Id)
    @Override
    public Integer getItemId(Student student) {
        return student.getId();
    }
}
