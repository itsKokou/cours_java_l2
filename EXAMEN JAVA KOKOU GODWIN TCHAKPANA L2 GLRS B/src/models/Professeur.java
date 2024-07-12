package models;

import java.util.ArrayList;

public class Professeur {
    private static int nbreP;
    private int id;
    private String nom;
    private String prenom;
    private double salaire ; 
    private ArrayList<Module> modules = new ArrayList<>();
    
    public Professeur() {
        nbreP += 1;
        id = nbreP;
    }

    public Professeur(String nom, String prenom, double salaire) {
        nbreP += 1;
        id = nbreP;
        this.nom = nom;
        this.prenom = prenom;
        this.salaire = salaire;
    }

    public static int getNbreP() {
        return nbreP;
    }

    public static void setNbreP(int nbreP) {
        Professeur.nbreP = nbreP;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public double getSalaire() {
        return salaire;
    }

    public void setSalaire(double salaire) {
        this.salaire = salaire;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void addModules(Module module) {
        this.modules.add( module);
    }

    @Override
    public String toString() {
        return "Professeur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", salaire=" + salaire + "]";
    }

}
