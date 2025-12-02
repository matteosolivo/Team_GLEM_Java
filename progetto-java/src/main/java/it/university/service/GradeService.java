package it.university.service;

import it.university.model.Grade;
import it.university.repository.ICombinationRepository;

public class GradeService extends AbstractCombinationService<Grade> {

    private static GradeService istance;

    // Private COSI SOLO DAL SERVICE SI PUO' ACCEDERE AL REPOSITORY
    private GradeService(ICombinationRepository<Grade> repository) {
        super(repository);
    }

    // METODO PER OTTENERE L'ISTANZA DEL SERVICE (SINGLETON)
    public static GradeService getIstance(ICombinationRepository<Grade> repository) {
        if (istance == null) {
            istance = new GradeService(repository);
        }
        return istance;
    }

    // METODO NON USATO PERCHE MAIN USA QUELLO DI AbstractCombinationService.java
    public void assignGrade(Grade grade) {
        add(grade);
    }

}
