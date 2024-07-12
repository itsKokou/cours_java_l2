package models;

import java.util.ArrayList;

public class Compte {
    protected String numero;
    protected double solde;

    public Compte() {
    }

    public Compte(String numero, double solde) {
        this.numero = numero;
        this.solde = solde;
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

    @Override
    public String toString() {
        return "Compte [numero=" + numero + ", solde=" + solde + "]";
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
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
            return false;
        return true;
    }

    public void retrait(double montant){
        if (montant<solde){
            solde-=montant;
        }else{
            throw new RuntimeException("Solde insuffisant");
        }
    }

    public void depot(double montant){
        solde += montant;
    }

    public void virement(double montant, Compte cpte){
        if (montant < solde) {
            solde -= montant;
            cpte.depot(montant);  
        } else {
            throw new RuntimeException("Solde insuffisant");
        }
    }

    public double consultation(){
        return solde;
    }

    // Attributs et méthodes relationnels 
    private Client client;
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    public Client getClient() {
        return client;
    }

    public void setClient(Client cl) {
        // Compte ---> Client
        this.client = cl;
    }
    
    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public void addTransaction(Transaction transaction){
        //Compte ---> Transaction
        transactions.add(transaction);
    }

}
