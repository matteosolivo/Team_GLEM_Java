package it.university.repository;

import it.university.model.Student;

public class StudentRepository extends AbstractRepository<Student, Integer> {

	private static StudentRepository istance;
	
	private StudentRepository() {
		System.out.println("Student Repository creato");
	}
	
	public static StudentRepository getIstance() {
		if(istance == null) {
			istance = new StudentRepository();
		}
		return istance;
	}
	
    @Override
    protected Integer extractId(Student student) {
        return student.getId();
    }
}
