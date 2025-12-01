package it.university.repository;

import it.university.model.Student;

public class StudentRepository extends AbstractRepository<Student, Integer> {

    @Override
    public Integer getItemId(Student student) {
        return student.getId();
    }
}
