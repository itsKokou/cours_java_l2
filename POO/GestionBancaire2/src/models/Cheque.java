package models;

public class Cheque extends Compte {
    private  double frais ;
    public Cheque(double solde, double frais) {
        super(solde);
        this.frais = frais;
    }
    public Cheque() {
        super();
    }
    public double getFrais() {
        return frais;
    }
    public void setFrais(double frais) {
        this.frais = frais;
    }
    @Override
    public void depot(double montant){
       //super.solde+=montant; 
      //this.solde+=montant;
       //solde+=montant-frais;
       super.depot(montant-frais);
    }
    @Override
    public String consultation() {
        return super.consultation()+" Frais= "+frais ;
    }
    
    
}
