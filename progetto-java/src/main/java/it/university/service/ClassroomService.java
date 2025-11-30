package it.university.service;

import java.util.List;

import it.university.model.Classroom;
import it.university.repository.IRepository;

public class ClassroomService extends AbstractService<Classroom, String> {

	private static ClassroomService istance;
	
	//Private così solo tramite ClassroomService è possibile ottenere un'istanza del service
    private ClassroomService(IRepository<Classroom, String> classroomRepository) {
        super(classroomRepository);
    }
    
    public static ClassroomService getIstance(IRepository<Classroom, String> classroomRepository) {
    	if(istance == null) {
    		istance = new ClassroomService(classroomRepository);
    	}
    	return istance;
    }
    
    public void add(Classroom classroom) {
        save(classroom);
    }

    @Override
    public List<Classroom> list() {
        List<Classroom> classroomsList = super.list();
        
        if (classroomsList.isEmpty()) {
            System.out.println("Nessuna aula presente");
        }
        return classroomsList;
    }
}
