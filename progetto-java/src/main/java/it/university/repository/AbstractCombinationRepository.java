package it.university.repository;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

import it.university.exceptions.Exceptions;
import it.university.exceptions.Exceptions.DuplicateException;
import it.university.model.CombinationItem;

// CLASSE ASTRATTA DESTINATA AI REPOSITORY CHE HANNO COMBINAZIONI DI ID COME CHIAVE PRIMARIA
// T extends CombinationItem --> TYPE SAFETY
public abstract class AbstractCombinationRepository<T extends CombinationItem> implements ICombinationRepository<T> {

    protected final List<T> combinationRepository = new ArrayList<>();

    protected abstract String getItemId(T item);

    // VERIFICA SE ESISTE UN ELEMENTO CON LA COPPIA DI ID FORNITA
    @Override
    public boolean exists(Integer studentId, Integer courseId) {
        for (T item : combinationRepository) {
            if (item.getStudentId().equals(studentId) && item.getCourseId().equals(courseId)) {
                return true;
            }
        }
        return false;
    }

    // 
    @Override
    public void save(T item) {
        // INTEGER E' UNA CLASSE WRAPPER, QUINDI SI PUO' UTILIZZARE ANCHE .equals()
        // LE CLASSI WRAPPER SOVRASCRIVONO IL METODO .equals() PER CONFRONTARE I VALORI E NON I RIFERIMENTI, COME EREDITATO DA Object
        Integer studentId = item.getStudentId();
        Integer courseId = item.getCourseId();

        if (exists(studentId, courseId)) {
            throw new DuplicateException("Elemento con studentId: " + studentId + " e courseId: " + courseId + " già presente.");
        }
        combinationRepository.add(item);
    }

    // RICERCA UN ELEMENTO IN BASE ALLA COPPIA DI ID FORNITA
    @Override
    public T findById(Integer studentId, Integer courseId) {
        for (T item : combinationRepository) {
            if (item.getStudentId().equals(studentId) && item.getCourseId().equals(courseId)) {
                return item;
            }
        }
        throw new Exceptions.ItemNotFoundException("Elemento non trovato con studentId: " + studentId + " e courseId: " + courseId);
    }

    // RESTITUISCE TUTTI GLI ELEMENTI DEL REPOSITORY
    @Override
    public List<T> findAll() {
        return new ArrayList<>(combinationRepository);
    }

    // SALVA TUTTI GLI ELEMENTI DI UN TIPO IN UN FILE JSON
    @Override
    public void saveToJson(String filePath) throws IOException {
        File file = new File(filePath);
        File directory = file.getParentFile();

        // CREAZIONE DELLA DIRECTORY SE NON ESISTE
        if (directory != null && !directory.exists()) {
            directory.mkdirs();
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(file, combinationRepository);
            System.out.println("Dati salvati correttamente in: " + file.getAbsolutePath());
        } catch (IOException e) {
            throw new Exceptions.FileSaveException("Errore durante il salvataggio JSON in: " + file.getAbsolutePath(), e);
        }
    }

}
