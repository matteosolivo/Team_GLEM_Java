package it.university.service;

import java.util.List;

import it.university.model.CollectionItem;

// T extends CollectionItem --> TYPE SAFETY
public interface ICollectionService<T extends CollectionItem> {

    void add(T collectionItem);

    List<T> list();

    void saveToJson(String path) throws Exception;
}
