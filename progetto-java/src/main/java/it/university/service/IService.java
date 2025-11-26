package it.university.service;

import java.util.List;

public interface IService<T, ID> {
    void save(T entity);
    T getById(ID id);
    List<T> list();
}
