package models;


public class Transaction {

    private int id;
    private double solde;
    private TypeTransaction type;

    //Attribut navigationnel

    public TypeTransaction getType() {
        return type;
    }

    public void setType(TypeTransaction type) {
        this.type = type;
    }
    private Compte compte ;

    public Compte getCompte() {
        return compte;
    }

    public void setCompte(Compte compte) {
        this.compte = compte;
    }

    public Transaction(int id, double solde, TypeTransaction type) {
        this.id = id;
        this.solde = solde;
        this.type = type;
    }

    public Transaction() {
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getSolde() {
        return solde;
    }
    public void setSolde(double solde) {
        this.solde = solde;
    }
    @Override
    public String toString() {
        return "Transaction [id=" + id + ", solde=" + solde + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        long temp;
        temp = Double.doubleToLongBits(solde);
        result = prime * result + (int) (temp ^ (temp >>> 32));
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
        Transaction other = (Transaction) obj;
        if (id != other.id)
            return false;
        if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
            return false;
        return true;
    }
    
}
