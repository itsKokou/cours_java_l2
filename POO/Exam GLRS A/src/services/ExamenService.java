package services;

import java.util.ArrayList;

import models.Permission;
import models.Utilisateur;
import models.enums.Role;

public class ExamenService {
    private ArrayList<Utilisateur> users = new ArrayList<>();
    private ArrayList<Permission> permissions = new ArrayList<>();

    public ExamenService() {    
    }

    public Permission getPermissionByLibelle(String libelle){
        for (Permission permission : permissions) {
            if (permission.getLibelle().equals(libelle)){
                return permission;
            }
        }
        return null;
    }

    public boolean ajouterPermission(Permission perm){
        if(getPermissionByLibelle(perm.getLibelle())==null){
            giveAdminNewPermission(perm);
            this.permissions.add(perm);
            return true;
        }
        return false;
    }

    public ArrayList<Permission> listerPermission(){
        return this.permissions;
    }

    public Utilisateur findUtilisateurByEmail(String email){
        for (Utilisateur user : users) {
            if (user.getEmail().equals(email)){
                return user;                
            }
        }
        return null;
    }

    public boolean ajouterUtilisateur(Utilisateur user){
        if(findUtilisateurByEmail(user.getEmail())==null){
            users.add(user);
            return true;
        }
        return false;
    }

    public ArrayList<Utilisateur> listerUtilisateur(){
        return users;
    }

    public Utilisateur findUtilisateurById(int id){
        for (Utilisateur user : users) {
            if (user.getId()==id){
                return user;
            }
        }
        return null;
    }

    public void giveAdminAllPermission(Utilisateur admin){
        for (Permission permission : permissions) {
            admin.addPermission(permission);
        }
    }

    private void giveAdminNewPermission(Permission perm){
        for (Utilisateur user : users) {
            if(user.getRole()==Role.Admin){
                user.addPermission(perm);
            }
        }
    }

    
    
    
}
