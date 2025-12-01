package it.university.service;

import java.io.IOException;
import java.util.List;

import it.university.model.Classroom;
import it.university.repository.ClassroomRepository;

public class ClassroomService {

    private static ClassroomService istance;

    private final ClassroomRepository classroomRepository;

    //Private così solo tramite ClassroomService è possibile ottenere un'istanza del service
    private ClassroomService(ClassroomRepository classroomRepository) {
        this.classroomRepository = classroomRepository;
    }

    public static ClassroomService getIstance(ClassroomRepository classroomRepository) {
        if (istance == null) {
            istance = new ClassroomService(classroomRepository);
        }
        return istance;
    }

    public void save(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public Classroom getById(String id) {
        return classroomRepository.findByCode(id);
    }

    public List<Classroom> list() {
        return classroomRepository.findAll();
    }

    public void saveToJson(String path) throws Exception {
        try {
            classroomRepository.saveToJson(path);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}
