package models;

public class Compte {
    
    private int id;
    private String numero;
    private double solde;

    //Attribut navigationel
    private final int N = 10;
    private Client client;
    private int nbrTransactions;
    private Transaction[] transactions= new Transaction[N];


    public Transaction[] getTransactions() {
        return transactions;
    }

    public void addTransaction(Transaction transaction){
        
        transactions[nbrTransactions]=transaction;
        nbrTransactions++;
    }

    public Client getClient() {
        return client;
    }
    public void setClient(Client client) {
        this.client = client;
    }

    public Compte(int id, String numero, double solde) {
        this.id = id;
        this.numero = numero;
        this.solde = solde;
    }
    public Compte() {
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
    @Override
    public String toString() {
        return "Compte [id=" + id + ", numero=" + numero + ", solde=" + solde + "]";
    }
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result + ((numero == null) ? 0 : numero.hashCode());
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
        Compte other = (Compte) obj;
        if (id != other.id)
            return false;
        if (numero == null) {
            if (other.numero != null)
                return false;
        } else if (!numero.equals(other.numero))
            return false;
        if (Double.doubleToLongBits(solde) != Double.doubleToLongBits(other.solde))
            return false;
        return true;
    }
    
}
