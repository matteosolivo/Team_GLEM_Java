package it.university.repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// IMPLEMENTAZIONE DELL'INTERFACCIA IRepository
public abstract class AbstractRepository<T, ID> implements IRepository<T, ID> {

    protected final Map<ID, T> storage = new HashMap<>();

    protected abstract ID extractId(T var);

    @Override
    public void save(T var) {
        storage.put(extractId(var), var);
    }

    @Override
    public T findById(ID id) {
        return storage.get(id);
    }

    @Override
    public List<T> findAll() {
        return new ArrayList<>(storage.values());
    }
}
