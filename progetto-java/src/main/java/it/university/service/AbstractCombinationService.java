package it.university.service;

import java.util.List;

import it.university.exceptions.Exceptions.DuplicateException;
import it.university.exceptions.Exceptions.FileSaveException;
import it.university.exceptions.Exceptions.ItemNotFoundException;
import it.university.model.CombinationItem;
import it.university.repository.ICombinationRepository;

// CLASSE ASTRATTA DESTINATA AI SERVICES CHE HANNO COMBINAZIONI DI ID COME CHIAVE PRIMARIA
// T extends CombinationItem --> TYPE SAFETY
public abstract class AbstractCombinationService<T extends CombinationItem> implements ICombinationService<T> {

    protected final ICombinationRepository<T> combinationRepository;

    protected AbstractCombinationService(ICombinationRepository<T> combinationRepository) {
        this.combinationRepository = combinationRepository;
    }

    // METODO PER AGGIUNGERE UN NUOVO ELEMENTO CON COMBINAZIONE DI ID
    @Override
    public void add(T combinationItem) {
        try {
            combinationRepository.save(combinationItem);
        } catch (DuplicateException e) {
            System.err.println("Impossibile registrare l'item': " + e.getMessage());
        }
    }

    // RICERCA UN ELEMENTO IN BASE ALLA COPPIA DI ID FORNITA
    @Override
    public T findById(Integer studentId, Integer courseId) {
        try {
            return combinationRepository.findById(studentId, courseId);
        } catch (ItemNotFoundException e) {
            System.err.println("Errore durante la ricerca: " + e.getMessage());
            return null;
        }
    }

    // RESTITUISCE TUTTI GLI ELEMENTI DEL REPOSITORY
    @Override
    public List<T> list() {
        return combinationRepository.findAll();
    }

    // SALVA TUTTI GLI ELEMENTI DI UN TIPO (CON COMBINAZIONE DI ID) IN UN FILE JSON
    @Override
    public void saveToJson(String path) throws Exception {
        try {
            combinationRepository.saveToJson(path);
        } catch (FileSaveException e) {
            System.err.println("Errore durante il salvataggio dei dati: " + e.getMessage());
        }
    }
}
