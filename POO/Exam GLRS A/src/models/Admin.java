package models;

import models.enums.Role;

public class Admin extends Utilisateur {

    public Admin(){
        super();
        this.role = Role.Admin;
    }

    public Admin(String nom, String prenom, String email,String mdp){
        super(nom,prenom,email,mdp);
        this.role = Role.Admin;
    }


    
}
