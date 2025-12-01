package it.university.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.university.exceptions.Exceptions;

// CLASSE ASTRATTA DESTINATA AI REPOSITORY DEI SINGOLI OGGETTI CON ID UNIVOCO
// T extends Item --> TYPE SAFETY || NON IMPLEMENTATO PER ESTENDERE ANCHE CLASSROOM
public abstract class AbstractRepository<T, ID> implements IRepository<T, ID> {

    protected final List<T> repository = new ArrayList<>();

    protected abstract ID getItemId(T item);

    @Override
    public boolean exists(ID id) {
        for (T item : repository) {
            if (getItemId(item).equals(id)) {
                return true;
            }
        }
        return false;
    }
    
    @Override
    public void save(T item) {
        ID id = getItemId(item);

        if (exists(id)) {
            throw new Exceptions.DuplicateException("Elemento con id: " + id + " gia' presente.");
        }
        repository.add(item);
    }

    @Override
    public T findById(ID id) {
        for (T item : repository) {
            if (getItemId(item).equals(id)) {
                return item;
            }
        }
        throw new Exceptions.ItemNotFoundException("Elemento non trovato con id: " + id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(repository);
    }

    @Override
    public void saveToJson(String filePath) {
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
