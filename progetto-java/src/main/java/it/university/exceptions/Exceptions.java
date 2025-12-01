package it.university.exceptions;

public class Exceptions {

    // ECCEZIONE PER OGGETTO DUPLICATO
    public static class DuplicateException extends RuntimeException {
        public DuplicateException(String errore) {
            super(errore);
        }
    }

    // ECCEZIONE PER OGGETTO NON TROVATO
    public static class ItemNotFoundException extends RuntimeException {
        public ItemNotFoundException(String errore) {
            super(errore);
        }
    }

    // ECCEZIONE PER FILE NON TROVATO
    public static class FileSaveException extends RuntimeException {
        public FileSaveException(String errore, Throwable cause) {
            super(errore, cause);
        }
    }
}
