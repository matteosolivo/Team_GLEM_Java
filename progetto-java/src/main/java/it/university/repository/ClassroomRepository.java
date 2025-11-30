package it.university.repository;

import it.university.model.Classroom;

public class ClassroomRepository extends AbstractRepository<Classroom, String> {

	private static ClassroomRepository istance;
	
	private ClassroomRepository() {
		System.out.println("Classroom repository creato.");
	}
	
	public static ClassroomRepository getIstance() {
		if(istance == null) {
			istance = new ClassroomRepository();
		}
		return istance;
	}
	
    @Override
    protected String extractId(Classroom classroom) {
        return classroom.getCode();
    }
}
