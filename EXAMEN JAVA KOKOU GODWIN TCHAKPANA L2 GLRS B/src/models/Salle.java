package models;

public class Salle {

    private static int nbreS;
    private int id;
    private String libelle;

    public Salle(String libelle) {
        nbreS +=1; 
        id = nbreS;
        this.libelle = libelle;
    }

    public Salle(){
        nbreS +=1; 
        id = nbreS;
    }

    public static int getNbreS() {
        return nbreS;
    }

    public static void setNbreS(int nbreS) {
        Salle.nbreS = nbreS;
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
        return "Salle [id=" + id + ", libelle=" + libelle + "]";
    }
    
}
