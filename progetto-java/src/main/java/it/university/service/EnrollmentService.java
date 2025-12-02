package it.university.service;

import it.university.model.Enrollment;
import it.university.repository.ICombinationRepository;

public class EnrollmentService extends AbstractCombinationService<Enrollment> {

    private static EnrollmentService istance;

    // Private COSI SOLO DAL SERVICE SI PUO' ACCEDERE AL REPOSITORY
    private EnrollmentService(ICombinationRepository<Enrollment> repository) {
        super(repository);
    }

    // METODO PER OTTENERE L'ISTANZA DEL SERVICE (SINGLETON)
    public static EnrollmentService getIstance(ICombinationRepository<Enrollment> repository) {
        if (istance == null) {
            istance = new EnrollmentService(repository);
        }
        return istance;
    }

    // METODO USATO PERCHE MAIN USA QUESTA FIRMA E NON QUELLA DI AbstractCombinationService.java
    public void enrollStudent(Enrollment enrollment) {
        add(enrollment);
    }
}
