package it.university.service;

import java.util.List;

import it.university.exceptions.Exceptions.DuplicateException;
import it.university.exceptions.Exceptions.FileSaveException;
import it.university.exceptions.Exceptions.ItemNotFoundException;
import it.university.model.CollectionItem;
import it.university.repository.ICollectionRepository;

// T extends CollectionItem --> TYPE SAFETY
public abstract class AbstractCollectionService<T extends CollectionItem> implements ICollectionService<T> {

    protected final ICollectionRepository<T> collectionRepository;

    protected AbstractCollectionService(ICollectionRepository<T> collectionRepository) {
        this.collectionRepository = collectionRepository;
    }

    @Override
    public void add(T collectionItem) {
        try {
            collectionRepository.save(collectionItem);
        } catch (DuplicateException e) {
            System.err.println("Impossibile registrare l'item': " + e.getMessage());
        }
    }

    @Override
    public T findById(Integer studentId, Integer courseId) {
        try {
            return collectionRepository.findById(studentId, courseId);
        } catch (ItemNotFoundException e) {
            System.err.println("Errore durante la ricerca: " + e.getMessage());
            return null;
        }
    }

    @Override
    public List<T> list() {
        return collectionRepository.findAll();
    }

    @Override
    public void saveToJson(String path) throws Exception {
        try {
            collectionRepository.saveToJson(path);
        } catch (FileSaveException e) {
            System.err.println("Errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}
