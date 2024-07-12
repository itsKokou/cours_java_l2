package models;

import java.util.ArrayList;

import models.enums.Role;

public class Utilisateur {
    private static int nbreU;
    private int id;
    protected String nom,prenom,email,mdp;
    protected Role role;
    protected ArrayList<Permission> permissions = new ArrayList<>();
    
    public Utilisateur() {
        nbreU+=1;
        id = nbreU;
    }
    
    public Utilisateur(String nom, String prenom, String email, String mdp) {
        nbreU+=1;
        id = nbreU;
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
    }
    public static int getNbreU() {
        return nbreU;
    }
    public static void setNbreU(int nbreU) {
        Utilisateur.nbreU = nbreU;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }
    public String getPrenom() {
        return prenom;
    }
    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public String getMdp() {
        return mdp;
    }
    public void setMdp(String mdp) {
        this.mdp = mdp;
    }
    public Role getRole() {
        return role;
    }
    public void setRole(Role role) {
        this.role = role;
    }

    public ArrayList<Permission> getPermissions() {
        return permissions;
    }

    private boolean checkPermission(Permission permission){
        if(permissions.contains(permission)){
            return true;
        }
        return false;
    }

    public boolean addPermission(Permission permission) {
        if (!checkPermission(permission)){
            this.permissions.add(permission);
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Utilisateur [id=" + id + ", nom=" + nom + ", prenom=" + prenom + ", email=" + email + ", role=" + role
                + "]";
    }


}
