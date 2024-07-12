package models;

public class Transaction {
    private static int nbreTransaction = 0; 
    private int id;
    private double montant;
    private TypeTransaction type;

    public Transaction() {
    }

    public Transaction(double montant, TypeTransaction type) {
        Transaction.nbreTransaction ++;
        this.id = Transaction.nbreTransaction;
        this.montant = montant;
        this.type = type;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getMontant() {
        return montant;
    }
    public void setMontant(double montant) {
        this.montant = montant;
    }
    public TypeTransaction getType() {
        return type;
    }
    public void setType(TypeTransaction type) {
        this.type = type;
    }
    
    @Override
    public String toString() {
        return "Transaction [id=" + id + ", montant=" + montant + ", type=" + type + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Transaction other = (Transaction) obj;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(montant) != Double.doubleToLongBits(other.montant))
            return false;
        if (type != other.type)
            return false;
        return true;
    }

    //Attributs et méthodes relationnels

    private Compte compte;

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        //Transaction ---> Compte
        this.compte = compte;
    }

}
