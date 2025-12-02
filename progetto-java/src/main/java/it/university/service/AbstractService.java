package it.university.service;

import java.util.List;

import it.university.exceptions.Exceptions.DuplicateException;
import it.university.exceptions.Exceptions.FileSaveException;
import it.university.exceptions.Exceptions.ItemNotFoundException;
import it.university.repository.IRepository;

// CLASSE ASTRATTA DESTINATA AI SERVICES DEI SINGOLI OGGETTI CON ID UNIVOCO
// T extends Item --> TYPE SAFETY || NON IMPLEMENTATO PER ESTENDERE ANCHE CLASSROOM
public abstract class AbstractService<T, ID> implements IService<T, ID> {

    protected final IRepository<T, ID> repository;

    protected AbstractService(IRepository<T, ID> repository) {
        this.repository = repository;
    }

    // METODO PER AGGIUNGERE UN NUOVO ELEMENTO CON ID UNIVOCO
    @Override
    public void save(T item) {
        try {
            repository.save(item);
        } catch (DuplicateException e) {
            System.err.println("Impossibile registrare l'item: " + e.getMessage());
        }
    }

    // RICERCA UN ELEMENTO IN BASE ALL'ID FORNITO
    @Override
    public T findById(ID id) {
        try {
            return repository.findById(id);
        } catch (ItemNotFoundException e) {
            System.err.println("Errore durante la ricerca: " + e.getMessage());
            return null;
        }
    }

    // RESTITUISCE TUTTI GLI ELEMENTI DEL REPOSITORY
    @Override
    public List<T> list() {
        return repository.findAll();
    }

    // SALVA TUTTI GLI ELEMENTI DI UN TIPO IN UN FILE JSON
    @Override
    public void saveToJson(String path) {
        try {
            repository.saveToJson(path);
        } catch (FileSaveException e) {
            System.err.println("Errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}
