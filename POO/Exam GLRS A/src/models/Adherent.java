package models;

import models.enums.Role;

public class Adherent extends Utilisateur{
    public Adherent(){
        super();
        this.role = Role.Adherent;
    }

    public Adherent(String nom, String prenom, String email,String mdp){
        super(nom,prenom,email,mdp);
        this.role = Role.Adherent;
    }

}
