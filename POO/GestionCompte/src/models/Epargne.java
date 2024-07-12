package models;

import java.util.Date;

public class Epargne extends Compte{

    private Date dateDbBlocage;
    private Date dateFinBlocage;
    private double taux;

    public Epargne() {
        super();
    }

    public Epargne(String numero, double solde, Date dateDbBlocage, Date dateFinBlocage, double taux) {
        super(numero, solde);
        this.dateDbBlocage = dateDbBlocage;
        this.dateFinBlocage = dateFinBlocage;
        this.taux = taux;
    }
    
    public Date getDateDbBlocage() {
        return dateDbBlocage;
    }
    public void setDateDbBlocage(Date dateDbBlocage) {
        this.dateDbBlocage = dateDbBlocage;
    }
    public Date getDateFinBlocage() {
        return dateFinBlocage;
    }
    public void setDateFinBlocage(Date dateFinBlocage) {
        this.dateFinBlocage = dateFinBlocage;
    }
    public double getTaux() {
        return taux;
    }
    public void setTaux(double taux) {
        this.taux = taux;
    }
    
}
