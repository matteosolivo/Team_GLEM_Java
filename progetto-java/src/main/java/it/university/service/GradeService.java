package it.university.service;

import it.university.model.Grade;
import it.university.repository.ICollectionRepository;

public class GradeService extends AbstractCollectionService<Grade> {

    private static GradeService istance;

    private GradeService(ICollectionRepository<Grade> repository) {
        super(repository);
    }

    public static GradeService getIstance(ICollectionRepository<Grade> repository) {
        if (istance == null) {
            istance = new GradeService(repository);
        }
        return istance;
    }

    // METODO NON USATO PERCHE MAIN USA QUELLO DI AbstractCollectionService.java
    public void assignGrade(Grade grade) {
        add(grade);
    }

}
