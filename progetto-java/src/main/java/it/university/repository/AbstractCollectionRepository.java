package it.university.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.university.exceptions.Exceptions;
import it.university.exceptions.Exceptions.DuplicateException;
import it.university.model.CollectionItem;

// CLASSE ASTRATTA DESTINATA AI REPOSITORY CHE HANNO COMBINAZIONE DI ID COME CHIAVE PRIMARIA
// T extends CollectionItem --> TYPE SAFETY
public abstract class AbstractCollectionRepository<T extends CollectionItem> implements ICollectionRepository<T> {

    protected final List<T> collectionRepository = new ArrayList<>();

    protected abstract String getItemId(T item);

    @Override
    public boolean exists(Integer studentId, Integer courseId) {
        for (T item : collectionRepository) {
            if (item.getStudentId().equals(studentId) && item.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void save(T item) {
        // INTEGER E' UNA CLASSE WRAPPER, QUINDI PUO ESSERE NULL
        Integer studentId = item.getStudentId();
        Integer courseId = item.getCourseId();

        if (exists(studentId, courseId)) {
            throw new DuplicateException("Elemento con studentId: " + studentId + " e courseId: " + courseId + " già presente.");
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
        throw new Exceptions.ItemNotFoundException("Elemento non trovato con studentId: " + studentId + " e courseId: " + courseId);
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
        try {
            mapper.writeValue(file, findAll());
            System.out.println("Dati salvati correttamente in: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new Exceptions.FileSaveException("Errore durante il salvataggio JSON in: " + file.getAbsolutePath(), e);
        }
    }

}
