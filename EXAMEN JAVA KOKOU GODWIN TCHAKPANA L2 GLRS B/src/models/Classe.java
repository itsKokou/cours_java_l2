package models;

import java.util.ArrayList;

public class Classe {
    private static int nbreCl;
    private int id;
    private String libelle;
    private ArrayList<Cours> cours = new ArrayList<>();


    public Classe() {
        nbreCl+=1;
        id = nbreCl;
    }

    public Classe(String libelle) {
        nbreCl+=1;
        id = nbreCl;
        this.libelle = libelle;
    }

    public static int getNbreCl() {
        return nbreCl;
    }

    public static void setNbreCl(int nbreCl) {
        Classe.nbreCl = nbreCl;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }

    @Override
    public String toString() {
        return "Classe [id=" + id + ", libelle=" + libelle + "]";
    }

    public ArrayList<Cours> getCours() {
        return cours;
    }

    public void addCours(Cours cours) {
        this.cours.add(cours);
    }
}
