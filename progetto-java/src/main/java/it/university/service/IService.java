package it.university.service;

import java.util.List;

// T extends Item --> TYPE SAFETY || NON IMPLEMENTATO PER ESTENDERE ANCHE CLASSROOM
public interface IService<T, ID> {

    void save(T entity);

    T findById(ID id);

    List<T> list();

    void saveToJson(String path);
}
