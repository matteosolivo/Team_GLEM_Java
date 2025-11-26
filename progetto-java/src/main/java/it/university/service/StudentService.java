package it.university.service;

import java.util.List;

import it.university.model.Student;
import it.university.repository.IRepository;

public class StudentService extends AbstractService<Student, Integer> {
    public StudentService(IRepository<Student, Integer> studentRepository) {
        super(studentRepository);
    }

    public void registerStudent(Student student) { save(student); }

    @Override
    public List<Student> list() {
        List<Student> studentsList = super.list();
        
        if (studentsList.isEmpty()) {
            System.out.println("Nessuno studente presente");
        }
        return studentsList;
    }
}
