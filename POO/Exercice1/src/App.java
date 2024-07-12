
import java.util.Scanner;

import services.Exo1Service; 

public class App {
    public static void main(String[] args) throws Exception {
        Exo1Service service = new Exo1Service(); 
        double[] tab = {};
        int taille =0;
        int choix;
        Scanner sc = new Scanner(System.in);
        
        do {
            System.out.println("1..Ajouter des notes");
            System.out.println("2..Lister notes");
            System.out.println("3..Rechercher les notes extrêmes");
            System.out.println("4..Trier les notes par ordre croissant");
            System.out.println("5..Supprimer une note à une position");
            System.out.println("6..Transferer valeurs supérieures à la moyenne");
            System.out.println("7..Quitter");

            choix = sc.nextInt();
            switch (choix) {
                case 1:
                    System.out.print("\033c");
                    do {
                        System.out.println("Combien de notes souhaitez-vous ajouter ?");
                        taille = sc.nextInt();
                    } while (taille<0 || taille>10);
                    tab = new double[taille];
                    double note;
                    int i = 0;
                    while (i<taille ) {
                        System.out.println("Entrez la note n°"+(i+1));
                        note = sc.nextDouble();
                        if (note>=0 && note <=20 ){
                            service.ajouterNote(tab, note, i);
                            ++i;
                        } 
                    }
                    break;
            
                case 2:
                    System.out.print("\033c");
                    System.out.println("Liste des notes :");
                    System.out.println(service.listerNote(tab));
                    break;

                case 3:
                    System.out.print("\033c");
                    System.out.println("La note la plus grande est : "+service.noteMax(tab,taille));
                    System.out.println("La note la plus petite est : "+service.noteMin(tab,taille));

                    break;
            
                case 4:
                    System.out.print("\033c");
                    System.out.println("AVANT TRI :");
                    System.out.println(service.listerNote(tab));
                    service.triCroissant(tab, taille);
                    System.out.println("APRES TRI :");
                    System.out.println(service.listerNote(tab));

                    break;
            
                case 5:
                    System.out.print("\033c");
                    int pos;
                    do {
                        System.out.println("Entrez la position de la note à supprimer :");
                        pos = sc.nextInt();
                    } while (pos < 0 || pos > taille-1);
                    service.supprimerNote(tab,taille ,pos);
                    System.out.println("APRES SUPPRESSION DE LA NOTE A LA POSITION :"+pos);
                    taille = taille -1;
                    System.out.println(service.listerNote2(tab,taille));
                    break;
            
                case 6:
                    System.out.print("\033c");
                    System.out.println("NOTES SUPERIEURES A LA MOYENNE :");
                    double[] newTab = new double[taille];
                    int taille2 = service.transfertTab(tab, taille,newTab);
                    System.out.println(service.listerNote2(newTab,taille2));
                    break;
            
            }
        } while (choix!=7);
        sc.close();
    }
}
