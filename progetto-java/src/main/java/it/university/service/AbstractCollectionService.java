package it.university.service;

import java.io.IOException;
import java.util.List;

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
        collectionRepository.save(collectionItem);
    }

    @Override
    public List<T> list() {
        return collectionRepository.findAll();
    }

    @Override
    public void saveToJson(String path) throws Exception {
        try {
            collectionRepository.saveToJson(path);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}
