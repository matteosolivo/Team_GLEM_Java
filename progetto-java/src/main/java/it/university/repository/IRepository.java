package it.university.repository;

import java.io.IOException;
import java.util.List;

import it.university.model.Item;

// INTERFACCIA DESTINATA AI REPOSITORY DEI SINGOLI OGGETTI CON ID UNIVOCO
// T extends Item --> TYPE SAFETY
public interface IRepository<T extends Item> {

    void save(T var);

    T findById(int id);

    List<T> findAll();

    void saveToJson(String filePath) throws IOException;
}
