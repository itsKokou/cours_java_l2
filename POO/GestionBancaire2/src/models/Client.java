package models;

import java.util.ArrayList;

public class Client {
    private int id ;
    private String nom;
    private String prenom;
    private static int  nbreClients;
    //attributs naviguationels
    private ArrayList<Compte>comptes=new ArrayList<>();
    public ArrayList<Compte> getComptes() {
        return comptes;
    }
    public void addCompte(Compte compte){
        comptes.add(compte);
    }
    public Client(String nom, String prenom) {
        nbreClients++;
        id=nbreClients;
        this.nom = nom;
        this.prenom = prenom;
    }
    public Client() {
        id=++nbreClients;
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
    public static int getNbreClients() {
        return nbreClients;
    }
    public static void setNbreClients(int nbreClients) {
        Client.nbreClients = nbreClients;
    }
    @Override
    public String toString() {
        return "Id="+ id+ "\nNom="+nom+"\nPrenom=" +prenom ;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Client other = (Client) obj;
        if (id != other.id)
            return false;
        return true;
    }
    
    
}
