package it.university.repository;

import java.util.List;

import it.university.model.CollectionItem;

// INTERFACCIA DESTINATA AI REPOSITORY CHE HANNO COMBINAZIONE DI ID COME CHIAVE PRIMARIA
// T extends CollectionItem --> TYPE SAFETY
public interface ICollectionRepository<T extends CollectionItem> {

    void save(T var);
    
    boolean exists(Integer studentId, Integer courseId);

    T findById(Integer studentId, Integer courseId);

    List<T> findAll();

    void saveToJson(String filePath) throws Exception;
}
