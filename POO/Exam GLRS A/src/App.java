import java.util.ArrayList;
import java.util.Scanner;

import models.Adherent;
import models.Admin;
import models.Permission;
import models.Utilisateur;
import services.ExamenService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        ExamenService service = new ExamenService();
        int choix,id,choice;
        String nom,prenom,email,mdp,libelle;
        Utilisateur utilisateur;

        do {
            
            System.out.println("1.....Ajouter Permission");
            System.out.println("2.....Lister Permissions");
            System.out.println("3.....Ajouter Utilisateur");
            System.out.println("4.....Lister user");
            System.out.println("5.....Lister permissions d'un user");
            System.out.println("6.....Affecter permission à utilisateur");
            System.out.println("7.....Quitter");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\033c");
                    System.out.println("Entrez le libelle de la permission");
                    libelle = sc.nextLine();
                    Permission perm = new Permission(libelle);
                    if (service.ajouterPermission(perm)){
                        System.out.println("Permission ajouter avec succès");
                    }else{
                        System.err.println("La permission existe déjà");
                    }
                    break;
            
                case 2:
                    System.out.println("\033c");
                    System.out.println("Liste des permissions");
                    ArrayList<Permission> permissions = service.listerPermission();
                    listerP(permissions);
                    break;
            
                case 3:
                    System.out.println("\033c");
                    System.out.println("Entrez le nom");
                    nom = sc.nextLine();
                    System.out.println("Entrez le prenom");
                    prenom = sc.nextLine();
                    System.out.println("Entrez l'email");
                    email = sc.nextLine();
                    System.out.println("Entrez le mot de passe");
                    mdp = sc.nextLine();
                    System.out.println("Quel est le rôle de l'utilisateur ?");
                    do {
                        System.out.println("1.....Admin");
                        System.out.println("2.....Adherent");
                        choice = sc.nextInt();
                    } while (choice!=1 && choice !=2);
                    sc.nextLine();
                    boolean result = false;
                    if(choice == 1){
                        utilisateur = new Admin(nom, prenom, email, mdp);
                        service.giveAdminAllPermission(utilisateur);
                        result = service.ajouterUtilisateur(utilisateur);
                    }else{
                        System.out.println("Entrez le libelle de la permission à lui attribuer :");
                        libelle = sc.nextLine();
                        perm = service.getPermissionByLibelle(libelle);
                        if (perm == null){
                            System.out.println("Cette permission n'existe pas !");
                        }else{
                            utilisateur = new Adherent(nom, prenom, email, mdp);
                            utilisateur.addPermission(perm);
                            result = service.ajouterUtilisateur(utilisateur);
                        } 
                    }
                    if (result){
                        System.out.println("L'utilisateur a été ajouté avec succès!");
                    }else{
                        System.out.println("Cet email a déjà été utilisé");
                    }
                    break;
                    
            
                case 4:
                    System.out.println("\033c");
                    System.out.println("Liste des utilisateurs");
                    ArrayList<Utilisateur> users = service.listerUtilisateur();
                    for (Utilisateur user : users) {
                        System.out.println(user);
                    }
                    break;
            
                case 5:
                    System.out.println("\033c");
                    System.out.println("Entrez l'id de l'utilisateur");
                    id = sc.nextInt();
                    sc.nextLine();
                    utilisateur = service.findUtilisateurById(id);
                    if (utilisateur == null){
                        System.out.println("Cet utilisateur n'existe pas");
                    }else{
                        permissions = utilisateur.getPermissions();
                        listerP(permissions);
                    }
                    break;
                    
                case 6:
                    System.out.println("\033c");
                    System.out.println("Entrez le libelle de la permission à lui attribuer :");
                    libelle = sc.nextLine();
                    perm = service.getPermissionByLibelle(libelle);
                    if (perm == null){
                        System.out.println("Cette permission n'existe pas !");
                    }else{
                        System.out.println("Entrez l'id de l'utilisateur");
                        id = sc.nextInt();
                        utilisateur = service.findUtilisateurById(id);
                        if (utilisateur == null){
                            System.out.println("Cet utilisateur n'existe pas");
                        }else{
                           boolean r = utilisateur.addPermission(perm);
                           if (r){
                            System.out.println("Permission ajoutée");
                           }else{
                            System.out.println("Il a déjà cette permission");
                           }
                        }
                    } 
                
                    break;
            
            }
        } while (choix!=7);
        sc.close();
    }

    public static void listerP (ArrayList<Permission> permissions){
        for (Permission permission : permissions) {
            System.out.println(permission);
        }
    }
}
