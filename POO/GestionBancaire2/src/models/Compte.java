package models;

import java.util.ArrayList;

public class Compte {
    private int id ;
    private String numero ;
    private static int nbreCompte ;
    
    public static int getNbreCompte() {
        return nbreCompte ;
    }
    public static void setNbreCompte(int nbreCompte){ 
        Compte.nbreCompte = nbreCompte;
    }
    protected double solde ;
    //attributs naviguationels
    private Client client ;
    public Compte(double solde) {
        id=++nbreCompte;
        this.solde = solde;
    }
    public Compte() {
        nbreCompte++;
        id=nbreCompte;
    }
    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNumero() {
        return numero;
    }
    public void setNumero(String numero) {
        this.numero = numero;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    public boolean retrait(double montant){
        if(montant< solde){
            solde-=montant;
            return true ;
        }
        return false ;
    }
    public void depot(double montant){
        solde+=montant;
    }
    public boolean virement(double montant,Compte cptDepot ){
        if(this.retrait(montant)){
            cptDepot.depot(montant);
            return true;
        }
        return false;
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Compte other = (Compte) obj;
        if (id != other.id)
            return false;
        if (numero == null){
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        return true;
    }
    public String consultation(){
        return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
    }
}
