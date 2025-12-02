package it.university.service;

import java.util.List;

import it.university.model.CombinationItem;

// T extends CombinationItem --> TYPE SAFETY
public interface ICombinationService<T extends CombinationItem> {

    void add(T combinationItem);

    T findById(Integer studentId, Integer courseId);
    
    List<T> list();

    void saveToJson(String path) throws Exception;
}
