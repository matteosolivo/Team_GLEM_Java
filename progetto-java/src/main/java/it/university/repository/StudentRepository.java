package it.university.repository;

import it.university.model.Student;

public class StudentRepository extends AbstractRepository<Student, Integer> {

    @Override
    protected Integer extractId(Student student) {
        return student.getId();
    }
}
