package it.university.repository;

import java.util.List;

import it.university.model.CombinationItem;

// INTERFACCIA DESTINATA AI REPOSITORY CHE HANNO COMBINAZIONE DI ID COME CHIAVE PRIMARIA
// T extends CombinationItem --> TYPE SAFETY
public interface ICombinationRepository<T extends CombinationItem> {

    void save(T var);
    
    boolean exists(Integer studentId, Integer courseId);

    T findById(Integer studentId, Integer courseId);

    List<T> findAll();

    void saveToJson(String filePath) throws Exception;
}
