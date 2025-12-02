package it.university.service;

import java.util.List;

import it.university.model.Professor;
import it.university.repository.IRepository;

public class ProfessorService extends AbstractService<Professor, Integer> {

    private static ProfessorService istance;

    // Private COSI SOLO DAL SERVICE SI PUO' ACCEDERE AL REPOSITORY
    private ProfessorService(IRepository<Professor, Integer> professorRepository) {
        super(professorRepository);
    }

    // METODO PER OTTENERE L'ISTANZA DEL SERVICE (SINGLETON)
    public static ProfessorService getIstance(IRepository<Professor, Integer> professorRepository) {
        if (istance == null) {
            istance = new ProfessorService(professorRepository);
        }
        return istance;
    }

    // METODO PER AGGIUNGERE UN NUOVO PROFESSORE
    public void add(Professor professor) {
        save(professor);
    }

    // OVERRIDE DEL METODO LIST PER GESTIONE MESSAGGIO PROFESSORE VUOTO
    @Override
    public List<Professor> list() {
        List<Professor> professorsList = super.list();

        if (professorsList.isEmpty()) {
            System.out.println("Nessun professore presente");
        }
        return professorsList;
    }
}
