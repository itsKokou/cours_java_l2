import java.util.ArrayList;
import java.util.Scanner;

import models.Classe;
import models.Cours;
import models.Session;
import services.CoursService;
import models.Module;
import models.Professeur;
import models.Salle;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        CoursService service = new CoursService();
        int choix,id,choice;
        String libelle,date,heureD,heureF;
        Session s;

        do {
            System.out.println("\033c");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("                  MENU GENERAL");
            System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
            System.out.println("1...............Ajouter classe");
            System.out.println("2...............Lister les classes");
            System.out.println("3...............Planifier un cours");
            System.out.println("4...............Lister les cours d'une classe");
            System.out.println("5...............Ajouter Une session de cours à un cours");
            System.out.println("6...............Lister sessions de cours d'un cours");
            System.out.println("7...............Quitter");
            System.out.println("Faites votre choix");
            
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\033c");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("              Ajout de Classe");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");

                    System.out.println("Entrez le libelle de la classe");
                    libelle = sc.nextLine();
                    Classe cl = new Classe(libelle);
                    if (service.ajouterClasse(cl)){
                        System.out.print("\n\n         **Classe ajoutée avec succès**");
                    }
                    
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("\033c");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("              Liste des classe");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");
                    ArrayList<Classe> classes = service.listerClasse();
                    for (Classe classe : classes) {
                        System.out.println(classe);
                    }
                    
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("\033c");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("            Planification de cours");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");

                    System.out.println("Entrez le libelle de la classe");
                    libelle = sc.nextLine();
                    Classe cl2 = service.getClasseByLibelle(libelle);
                    if (cl2==null){
                        System.out.println("Cette classe n'existe pas");
                    }else{
                        System.out.println("Entrez le Module");
                        libelle = sc.nextLine();
                        Module module = service.getModuleByLibelle(libelle);
                        if( module == null){
                            System.out.println("Ce module n'existe !");
                        }else{
                            System.out.println("Entrez l'id du professeur");
                            id = sc.nextInt();
                            sc.nextLine();
                            Professeur prof = service.getProfessseurByIdAndModule(id, module);
                            if (prof==null){
                                System.out.println("Le professeur n'enseigne pas ce module");
                            }else{
                                do {
                                    System.out.println("Souhaiter vous ajouter une session à ce cours ? [1=>Oui / 0 =>Non]");
                                    choice = sc.nextInt();
                                } while (choice !=1 && choice !=2);
                                sc.nextLine();
                                Cours cour;
                                if (choice == 0 ){
                                    cour = new Cours(prof, module);
                                }else{
                                    System.out.println("Entrez la date de la session");
                                    date = sc.nextLine();
                                    System.out.println("Entrez l'heure de debut de la session");
                                    heureD = sc.nextLine();
                                    System.out.println("Entrez l'heure de fin de la session");
                                    heureF = sc.nextLine();
                                    do {
                                        System.out.println("Où se fera la session ?");
                                        System.out.println("1.....En ligne");
                                        System.out.println("2.....En presentiel");
                                        choice = sc.nextInt();
                                    } while (choice!=1 &&  choice!=2);
                                    if (choice == 1){
                                        s = new Session(date, heureD, heureF);
                                    }else{
                                        System.out.println("Entrez le libelle de la classe");
                                        libelle = sc.nextLine();
                                        Salle sal = service.getSalleByLibelle(libelle);
                                        if (sal == null){
                                            System.out.println("cette salle n'existe pas ");
                                            s = new Session(date, heureD, heureF);
                                        }else{
                                            s = new Session(date, sal, heureD, heureF);
                                        }
                                    }
                                    cour = new Cours(prof, module); 
                                    cour.addSession(s);
                                }
                                cl2.addCours(cour);
                                service.ajouterCours(cour);
                            }
                        }

                    }
                    
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;
                case 4:
                    System.out.println("\033c");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("       Liste des cours d'une classe");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");

                    System.out.println("Entrez le libelle de la classe");
                    libelle = sc.nextLine();
                    Classe cla = service.getClasseByLibelle(libelle);
                    if (cla==null){
                        System.out.println("Cette classe n'existe pas");
                    }else{
                        ArrayList<Cours> cours = cla.getCours();
                        for (Cours cr : cours) {
                            System.out.println(cr);
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;

                case 5:
                   System.out.println("\033c");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("         Ajout de session à un cours");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");
                    
                    System.out.println("Entrez l'id du cours");
                    id = sc.nextInt();
                    Cours cour = service.findCoursById(id);
                    if (cour == null ){
                       System.out.println("cours n'existe pas ");
                    }else{
                        System.out.println("Entrez la date de la session");
                        date = sc.nextLine();
                        System.out.println("Entrez l'heure de debut de la session");
                        heureD = sc.nextLine();
                        System.out.println("Entrez l'heure de fin de la session");
                        heureF = sc.nextLine();
                        do {
                            System.out.println("Où se fera la session ?");
                            System.out.println("1.....En ligne");
                            System.out.println("2.....En presentiel");
                            choice = sc.nextInt();
                        } while (choix!=1 && choice!=2);
                        if (choice == 1){
                            s = new Session(date, heureD, heureF);
                        }else{
                            System.out.println("Entrez le libelle de la classe");
                            libelle = sc.nextLine();
                            Salle sal = service.getSalleByLibelle(libelle);
                            if (sal == null){
                                System.out.println("cette salle n'existe pas ");
                                s = new Session(date, heureD, heureF);
                            }else{
                                s = new Session(date, sal, heureD, heureF);
                            }
                        }
                        cour.addSession(s);
                    }

                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;

                case 6:
                   System.out.println("\033c");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++");
                    System.out.println("         Liste des sessions d'un cours ");
                    System.out.println("+++++++++++++++++++++++++++++++++++++++++++++++\n");
                    
                    System.out.println("Entrez l'id du cours");
                    id = sc.nextInt();
                    sc.nextLine();
                    Cours cr = service.findCoursById(id);
                    if (cr==null){
                        System.out.println("Ce cours n'existe pas");
                    }else{
                        ArrayList<Session> sessions = cr.getSessions();
                        for (Session se : sessions) {
                            System.out.println(se);
                        }
                    }

                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;
            }

        } while (choix != 7);
        sc.close();
    }
}
