package it.university.service;

import it.university.model.Student;
import it.university.repository.IRepository;

public class StudentService extends AbstractService<Student> {

    private static StudentService istance;

    private StudentService(IRepository<Student> studentRepository) {
        super(studentRepository);
    }

    public static StudentService getIstance(IRepository<Student> studentRepository) {
        if (istance == null) {
            istance = new StudentService(studentRepository);
        }
        return istance;
    }

    public void registerStudent(Student student) {
        save(student);
    }
}
