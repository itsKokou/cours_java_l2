package models;

import java.util.ArrayList;

public class Cours {
    private static int nbreC;
    private int id;
    private Professeur professeur;
    private Module module;
    private ArrayList<Classe> classes = new ArrayList<>();
    private ArrayList<Session> sessions = new ArrayList<>();

    public Cours() {
        nbreC+=1;
        id = nbreC;
    }
    
    public Cours(Professeur professeur, Module module) {
        nbreC+=1;
        id = nbreC;
        this.professeur = professeur;
        this.module = module;
    }

    public static int getNbreC() {
        return nbreC;
    }

    public static void setNbreC(int nbreC) {
        Cours.nbreC = nbreC;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Professeur getProfesseur() {
        return professeur;
    }

    public void setProfesseur(Professeur professeur) {
        this.professeur = professeur;
    }

    public Module getModule() {
        return module;
    }

    public void setModule(Module module) {
        this.module = module;
    }

    public ArrayList<Classe> getClasses() {
        return classes;
    }

    public void addClasse(Classe classe) {
        this.classes.add(classe);
    }

    public ArrayList<Session> getSessions() {
        return sessions;
    }

    public void addSession(Session session) {
        this.sessions.add(session);
    }

    @Override
    public String toString() {
        return "Cours [id=" + id + ", professeur=" + professeur + ", module=" + module + "]";
    }
    
    
    
}
