package it.university.service;

import it.university.model.Enrollment;
import it.university.repository.ICollectionRepository;

public class EnrollmentService extends AbstractCollectionService<Enrollment> {

    private static EnrollmentService istance;

    private EnrollmentService(ICollectionRepository<Enrollment> repository) {
        super(repository);
    }

    public static EnrollmentService getIstance(ICollectionRepository<Enrollment> repository) {
        if (istance == null) {
            istance = new EnrollmentService(repository);
        }
        return istance;
    }

    // METODO USATO PERCHE MAIN USA QUESTA FIRMA E NON QUELLA DI AbstractCollectionService.java
    public void enrollStudent(Enrollment enrollment) {
        add(enrollment);
    }
}
