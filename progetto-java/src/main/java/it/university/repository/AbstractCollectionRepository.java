package it.university.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.university.model.CollectionItem;

// CLASSE ASTRATTA DESTINATA AI REPOSITORY CHE HANNO COMBINAZIONE DI ID COME CHIAVE PRIMARIA
// T extends CollectionItem --> TYPE SAFETY
public abstract class AbstractCollectionRepository<T extends CollectionItem> implements ICollectionRepository<T> {

    protected final List<T> collectionRepository = new ArrayList<>();

    protected abstract String getItemId(T item);

    @Override
    public void save(T item) {
        if (findById(item.getStudentId(), item.getCourseId()) != null) {
            System.out.println("Elemento duplicato: " + getItemId(item)); // ECCEZIONE ????
            return;
        }

        collectionRepository.add(item);
    }

    @Override
    public T findById(Integer studentId, Integer courseId) {
        for (T item : collectionRepository) {
            if (item.getStudentId().equals(studentId) && item.getCourseId().equals(courseId)) {
                return item;
            }
        }
        return null; // non trovato
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(collectionRepository);
    }

    @Override
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
