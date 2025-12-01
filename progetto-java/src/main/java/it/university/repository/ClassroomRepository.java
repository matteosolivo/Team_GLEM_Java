package it.university.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.university.model.Classroom;

public class ClassroomRepository {

    public List<Classroom> classroomRepository = new ArrayList<>();

    public String getItemId(Classroom classroom) {
        return classroom.getCode();
    }

    public void save(Classroom classroom) {
        String id = getItemId(classroom);

        for (Classroom existing : classroomRepository) {
            if (getItemId(existing).equals(id)) {
                System.err.println("Elemento duplicato: " + id); // ECCEZIONE ????
                return;
            }
        }
        classroomRepository.add(classroom);
    }

    public Classroom findByCode(String id) {
        for (Classroom classroom : classroomRepository) {
            if (classroom.getCode().equals(id)) {
                return classroom;
            }
        }
        return null;
    }

    public List<Classroom> findAll() {
        return new ArrayList<>(classroomRepository);
    }

    public void saveToJson(String filePath) throws IOException {
        File file = new File(filePath);
        File directory = file.getParentFile();

        // CREAZIONE DELLA DIRECTORY SE NON ESISTE
        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();
        mapper.writeValue(file, findAll());
        System.out.println("Dati salvati correttamente in: " + file.getAbsolutePath());
    }
}
