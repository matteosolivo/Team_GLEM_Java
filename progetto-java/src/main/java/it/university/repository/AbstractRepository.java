package it.university.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.university.model.Item;

// CLASSE ASTRATTA DESTINATA AI REPOSITORY DEI SINGOLI OGGETTI CON ID UNIVOCO
// T extends Item --> TYPE SAFETY
public abstract class AbstractRepository<T extends Item> implements IRepository<T> {

    protected final List<T> repository = new ArrayList<>();

    protected abstract int getItemId(T var);

    @Override
    public void save(T item) {
        int id = getItemId(item);

        for (T existing : repository) {
            if (getItemId(existing) == id) {
                System.out.println("Elemento duplicato: " + id); // ECCEZIONE ????
                return;
            }
        }

        repository.add(item);
    }

    @Override
    public T findById(int id) {
        for (T item : repository) {
            if (item.getId() == id) {
                return item;
            }
        }
        return null;
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(repository);
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
