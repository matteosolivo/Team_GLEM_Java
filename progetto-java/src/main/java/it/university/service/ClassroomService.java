package it.university.service;

import java.util.List;

import it.university.model.Classroom;
import it.university.repository.IRepository;

public class ClassroomService extends AbstractService<Classroom, String> {

    public ClassroomService(IRepository<Classroom, String> classroomRepository) {
        super(classroomRepository);
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
