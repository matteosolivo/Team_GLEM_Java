package it.university.service;

import java.util.List;

import it.university.repository.IRepository;

public abstract class AbstractService<T, ID> implements IService<T, ID> {

    protected final IRepository<T, ID> repository;

    public AbstractService(IRepository<T, ID> repository) {
        this.repository = repository;
    }

    @Override
    public void save(T var) {
        repository.save(var);
    }

    @Override
    public T getById(ID id) {
        return repository.findById(id);
    }

    @Override
    public List<T> list() {
        return repository.findAll();
    }
}
