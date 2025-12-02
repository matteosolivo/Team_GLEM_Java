package it.university.service;

import java.util.List;

import it.university.model.Student;
import it.university.repository.IRepository;

public class StudentService extends AbstractService<Student, Integer> {

    private static StudentService istance;

    // Private COSI SOLO DAL SERVICE SI PUO' ACCEDERE AL REPOSITORY
    private StudentService(IRepository<Student, Integer> studentRepository) {
        super(studentRepository);
    }

    // METODO PER OTTENERE L'ISTANZA DEL SERVICE (SINGLETON)
    public static StudentService getIstance(IRepository<Student, Integer> studentRepository) {
        if (istance == null) {
            istance = new StudentService(studentRepository);
        }
        return istance;
    }

    // METODO PER REGISTRARE UN NUOVO STUDENTE (si poteva usare anche save() di AbstractService)
    public void registerStudent(Student student) {
        save(student);
    }

    // OVERRIDE DEL METODO LIST PER GESTIONE MESSAGGIO STUDENTE VUOTO
    @Override
    public List<Student> list() {
        List<Student> list = super.list();
        if (list.isEmpty()) {
            System.out.println("Nessuno studente registrato");
        }
        return list;
    }

}
