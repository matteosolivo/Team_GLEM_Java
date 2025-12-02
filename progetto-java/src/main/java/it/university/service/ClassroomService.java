package it.university.service;

import java.util.List;

import it.university.model.Classroom;
import it.university.repository.IRepository;

public class ClassroomService extends AbstractService<Classroom, String> {

    private static ClassroomService istance;

    // Private COSI SOLO DAL SERVICE SI PUO' ACCEDERE AL REPOSITORY
    private ClassroomService(IRepository<Classroom, String> repository) {
        super(repository);
    }

    // METODO PER OTTENERE L'ISTANZA DEL SERVICE (SINGLETON)
    public static ClassroomService getIstance(IRepository<Classroom, String> classroomRepository) {
        if (istance == null) {
            istance = new ClassroomService(classroomRepository);
        }
        return istance;
    }

    // METODO PER REGISTRARE UNA NUOVA AULA CON GESTIONE ECCEZIONE SULLA CAPACITA' NEGATIVA (IllegalArgumentException)
    public void registerClassroom(String code, int capacity) {
        try {
            save(new Classroom(code, capacity));
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Errore nella creazione dell'aula: " + e.getMessage());
        }
    }

    // OVERRIDE DEL METODO LIST PER GESTIONE MESSAGGIO AULA VUOTA
    @Override
    public List<Classroom> list() {
        List<Classroom> list = super.list();
        if (list.isEmpty()) {
            System.out.println("Nessuna aula presente");
        }
        return list;
    }
}
