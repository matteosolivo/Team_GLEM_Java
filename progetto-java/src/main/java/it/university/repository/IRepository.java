package it.university.repository;

import java.util.List;

// INTERFACCIA DESTINATA AI REPOSITORY DEI SINGOLI OGGETTI CON ID UNIVOCO
// T extends Item --> TYPE SAFETY || NON IMPLEMENTATO PER ESTENDERE ANCHE CLASSROOM
public interface IRepository<T, ID> {

    void save(T var);
    
    boolean exists(ID id);

    T findById(ID id);

    List<T> findAll();

    void saveToJson(String filePath);

}
