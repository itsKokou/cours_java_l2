package models;

public class Cheque extends Compte {

    private double frais;

    public Cheque() {
        super();
    }

    public Cheque(String numero, double solde, double frais) {
        super(numero, solde);
        this.frais = frais;
    }

    public double getFrais() {
        return frais;
    }

    public void setFrais(double frais) {
        this.frais = frais;
    }

    @Override
    public void depot(double montant) {
        solde += (montant-frais);
    }
}
