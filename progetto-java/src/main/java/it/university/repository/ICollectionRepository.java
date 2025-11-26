package it.university.repository;

import java.util.List;

// INTERFACCIA DESTINATA AI REPOSITORY CHE GESTISCONO COLLEZIONI DI OGGETTI (COMBINAZIONE DI ID)
public interface ICollectionRepository<T> {
    void save(T entity);
    List<T> findAll();
}
