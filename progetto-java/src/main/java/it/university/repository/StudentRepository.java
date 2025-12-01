package it.university.repository;

import it.university.model.Student;

public class StudentRepository extends AbstractRepository<Student> {

    @Override
    public int getItemId(Student student) {
        return student.getId();
    }
}
