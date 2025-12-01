package it.university.service;

import java.io.IOException;
import java.util.List;

import it.university.model.Item;
import it.university.repository.IRepository;

// T extends Item --> TYPE SAFETY
public abstract class AbstractService<T extends Item> implements IService<T> {

    protected final IRepository<T> repository;

    protected AbstractService(IRepository<T> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T var) {
        repository.save(var);
    }

    @Override
    public T getById(int id) {
        return repository.findById(id);
    }

    @Override
    public List<T> list() {
        return repository.findAll();
    }

    @Override
    public void saveToJson(String path) throws Exception {
        try {
            repository.saveToJson(path);
        } catch (IOException e) {
            System.out.println("Errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}
