package it.university.repository;

import java.util.List;

// INTERFACCIA DESTINATA AI REPOSITORY DEI SINGOLI OGGETTI CON ID UNIVOCO
public interface IRepository<T, ID> {
    void save(T entity);
    T findById(ID id);
    List<T> findAll();
    void deleteById(ID id);
}
