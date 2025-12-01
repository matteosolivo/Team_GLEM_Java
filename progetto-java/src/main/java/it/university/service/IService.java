package it.university.service;

import java.util.List;

import it.university.model.Item;

// T extends Item --> TYPE SAFETY
public interface IService<T extends Item> {

    void save(T entity);

    T getById(int id);

    List<T> list();

    void saveToJson(String path) throws Exception;
}
