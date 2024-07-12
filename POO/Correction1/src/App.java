import java.util.Scanner;

import services.Correction1Service;

public class App {
    public static void afficherNotes(double[] tab, int taille) {
        for (int i = 0; i < taille; ++i) {
            System.out.println(tab[i]);
        }
    }

    public static void main(String[] args) throws Exception {
        Scanner sc;
        sc = new Scanner(System.in);
        int choix;
        Correction1Service service = new Correction1Service();
        do {
            System.out.println("\033c");
            System.out.println("1.Ajouter une note ");
            System.out.println("2.Lister les notes ");
            System.out.println("3.Min et Max ");
            System.out.println("4.Trier les notes par ordre Croissant ");
            System.out.println("5.Supprimer une note ");
            System.out.println("6.Transferer les notes > à la moyenne");
            System.out.println("7.Quitter");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\033c");
                    System.out.println("Entrer la note :");
                    double note = sc.nextDouble();
                    sc.nextLine();
                    service.ajouterNote(note);
                    break;

                case 2:
                    System.out.println("\033c");
                    System.out.println("Liste des notes :");
                    double[] notes = service.listerNote();
                    int nbreNotes = service.getNbreNotes();
                    afficherNotes(notes, nbreNotes);
                    System.out.println("\nTapez une touche pour continuer...\n");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("\033c");
                    System.out.println("La plus grande note est : " + service.noteMax());
                    System.out.println("La plus petite note est : " + service.noteMin());
                    System.out.println("\nTapez une touche pour continuer...\n");
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println("\033c");
                    System.out.println("AVANT LE TRI");
                    notes = service.listerNote();
                    nbreNotes = service.getNbreNotes();
                    afficherNotes(notes, nbreNotes);
                    service.triCroissant();
                    System.out.println("APRES LE TRI");
                    notes = service.listerNote();
                    nbreNotes = service.getNbreNotes();
                    afficherNotes(notes, nbreNotes);
                    System.out.println("\nTapez une touche pour continuer...\n");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("\033c");
                    System.out.println("Entrez la position de la note à supprimer:");
                    int position = sc.nextInt();
                    sc.nextLine();
                    nbreNotes = service.getNbreNotes();
                    if (position >= 0 && position < nbreNotes) {
                        service.supprimerNote(position);
                    } else {
                        System.out.println("La position n'existe pas");
                    }
                    System.out.println("\nTapez une touche pour continuer...\n");
                    sc.nextLine();

                    break;

                case 6:
                    System.out.println("\033c");
                    double[] notesSup = service.transfertTab();
                    int nbreNotesSup = service.getNbreNotesSupMoy();
                    System.out.println("Les Notes supérieures à la moyenne");
                    afficherNotes(notesSup, nbreNotesSup);
                    System.out.println("\nTapez une touche pour continuer...\n");
                    sc.nextLine();
                    break;
            }
        } while (choix != 7);

        sc.close();
    }
}
