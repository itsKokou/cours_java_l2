package services;

import java.util.ArrayList;

import models.Classe;
import models.Cours;
import models.Module;
import models.Professeur;
import models.Salle;
import models.Session;

public class CoursService {
    private ArrayList<Classe> classes = new ArrayList<>();
    private ArrayList<Cours> cours = new ArrayList<>();
    private ArrayList<Salle> salles = new ArrayList<>();
    private ArrayList<Module> modules = new ArrayList<>();
    private ArrayList<Professeur> professeurs = new ArrayList<>();

    public CoursService() {
        this.PrepareData();
    }


    public Classe getClasseByLibelle(String libelle){
        for (Classe classe : classes) {
            if (classe.getLibelle().equals(libelle)){
                return classe;
            }
        }
        return  null;
    }

    private Boolean checkModule(ArrayList<Module> modules, Module module){
        for (Module mod : modules) {
            if (mod.getLibelle().equals(module.getLibelle())){
                return true;
            }
        }
        return false;
    }

    public Professeur getProfessseurByIdAndModule(int id, Module module){
        for (Professeur prof : professeurs) {
            if (checkModule(prof.getModules(),module) && prof.getId()==id){
                return prof;
            }
        }
        return null;
    }

    public Module getModuleByLibelle(String libelle){
        for (Module mod : modules) {
            if (mod.getLibelle().equals(libelle)){
                return mod;
            }
        }
        return  null;
    }

    public Boolean ajouterClasse(Classe cl){
        if (getClasseByLibelle(cl.getLibelle())==null){
            classes.add(cl);
            return true;
        }
        return false;
    }

    public ArrayList<Classe> listerClasse(){
        return classes;
    }

    public void ajouterCours(Cours cours){
        this.cours.add(cours);
    }

    public void ajouterSession(Cours cr, Session se){
        cr.addSession(se);
    }

    public Cours findCoursById(int id){
        for (Cours cr : this.cours) {
            if (cr.getId()==id){
                return cr;
            }
        }
        return null;
    }
    
    public Salle getSalleByLibelle(String libelle){
        for (Salle s : salles) {
            if (s.getLibelle().equals(libelle)){
                return s;
            }
        }
        return null;
    }















    private void PrepareData(){
        Module m1 = new Module("ALGO");
        Module m2 = new Module("UML");
        Module m3 = new Module("PYTHON");
        Module m4 = new Module("JAVA");
        Module m5 = new Module("SGBD");
        modules.add(m1);
        modules.add(m2);
        modules.add(m3);
        modules.add(m4);
        modules.add(m5);
        Salle s1 = new Salle("Incub");
        Salle s2 = new Salle("102");
        Salle s3 = new Salle("103");
        Salle s4 = new Salle("204");
        Salle s5 = new Salle("401");
        salles.add(s1);
        salles.add(s2);
        salles.add(s3);
        salles.add(s4);
        salles.add(s5);
        Professeur p1 = new Professeur("Baila", "Wane", 2000000);
        p1.addModules(m1);
        p1.addModules(m2);            
        p1.addModules(m4);            
        Professeur p2 = new Professeur("Aly", "Tall", 1500000);
        p2.addModules(m1);        
        p2.addModules(m3);              

        Professeur p3 = new Professeur("MBaye", "Moussa", 400000);
        p3.addModules(m5);
        Professeur p4 = new Professeur("Diaby", "Modou", 200000);
        p4.addModules(m3);
        professeurs.add(p1);
        professeurs.add(p2);
        professeurs.add(p3);
        professeurs.add(p4);
    }

    

}
