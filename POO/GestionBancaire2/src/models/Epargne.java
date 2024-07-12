package models;

import java.time.LocalDate;


public class Epargne extends Compte {
    private static double taux=0.10 ;
    private LocalDate dateDbBlocage;
    private LocalDate dateFinBlocage ;
    public boolean periodeBlocage(){
        LocalDate dateActuelle = LocalDate.now();
        if(dateActuelle.isBefore(dateDbBlocage) ||dateActuelle.isAfter(dateFinBlocage)){
            return true;
        }
        return false;
    }
    
    @Override
    public String consultation() {
        return super.consultation()+" Date debut Blocage="+dateDbBlocage+" Date Fin Blocage="+dateFinBlocage;
    }

    public double getTaux() {
        return taux;
    }

    public LocalDate getDateDbBlocage() {
        return dateDbBlocage;
    }

    public void setDateDbBlocage(LocalDate dateDbBlocage) {
        this.dateDbBlocage = dateDbBlocage;
    }

    public LocalDate getDateFinBlocage() {
        return dateFinBlocage;
    }

    public void setDateFinBlocage(LocalDate dateFinBlocage) {
        this.dateFinBlocage = dateFinBlocage;
    }

    @Override
    public void depot(double montant) {
        if(periodeBlocage()){
             super.depot(montant);
        }
    }

    @Override
    public boolean retrait(double montant) {
        if(periodeBlocage()){
            return super.retrait(montant);
        }
        return false;
    }

    @Override
    public boolean virement(double montant, Compte cptDepot) {
        if(periodeBlocage()){
            return super.virement(montant, cptDepot);
        }
        return false;
    }

   

}
