import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import models.Cheque;
import models.Client;
import models.Compte;
import models.Epargne;
import models.Transaction;
import models.TypeTransaction;
import services.CompteService;

public class App {
    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        CompteService service = new CompteService();
        int choix;

        do {
            System.out.println("\033c");
            System.out.println("1...Ajouter un Client");
            System.out.println("2...Lister les Clients");
            System.out.println("3...Lister Comptes d'un Client");
            System.out.println("4...Créer un Compte");
            System.out.println("5...Faire une Transaction");
            System.out.println("6...Lister les Transactions d'un Compte");
            System.out.println("7...Lister les Transactions d'un Client");
            System.out.println("8...Quitter");
            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\033c");
                    Client cl = new Client();
                    System.out.println("Entrez l'Id : ");
                    cl.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Entrez le nom : ");
                    cl.setNom(sc.nextLine());
                    System.out.println("Entrez le prénom : ");
                    cl.setPrenom(sc.nextLine());
                    service.ajouterClient(cl);
                    System.out.println("\n Client Ajouté avec Succès !!! ");
                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

                case 2:
                    System.out.println("\033c");
                    System.out.println("Liste des Clients : ");
                    ArrayList<Client> clients = service.listerClient();
                    for (Client client : clients) {
                        System.out.println(client);
                    }
                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

                case 3:
                    System.out.println("\033c");
                    System.out.println("Entrez l'Id du client :");
                    int id = sc.nextInt();
                    sc.nextLine();
                    cl = service.findClientById(id);
                    if (cl == null) {
                        System.out.println("\n Ce client n'existe pas.");
                    } else {
                        System.out.println("\n Liste des Comptes de " + cl.getNom() + " " + cl.getPrenom());
                        ArrayList<Compte> comptes = cl.getComptes();
                        for (Compte compte : comptes) {
                            System.out.println(compte);
                        }
                    }

                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

                case 4:
                    System.out.println("\033c");
                    System.out.println("Entrez l'Id du client :");
                    id = sc.nextInt();
                    sc.nextLine();
                    cl = service.findClientById(id);
                    if (cl == null) {
                        System.out.println("\n Ce client n'existe pas.");
                    } else {
                        int ch;
                        do {
                            System.out.println("Quel type de compte souhaitez-vous créer ?");
                            System.out.println("1..Chèque");
                            System.out.println("2..Epargne");
                            ch = sc.nextInt();
                        } while (ch != 1 && ch != 2);
                        sc.nextLine();

                        System.out.println("Entrez le numero de compte: ");
                        String numero = sc.nextLine();
                        System.out.println("Entrez le solde : ");
                        double solde = sc.nextDouble();
                        Compte cpte;
                        if (ch == 1) {
                            System.out.println("Entrez les frais de dépôt : ");
                            double frais = sc.nextDouble();
                            cpte = new Cheque(numero, solde, frais);
                            sc.nextLine();
                        } else {
                            System.out.println("Entrez le taux d'intérêt : ");
                            double taux = sc.nextDouble();
                            sc.nextLine();

                            System.out.println("Entrez la date de début du blocage sous format JJ/MM/AAAA :");
                            String str = sc.nextLine();
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            Date dateD = sdf.parse(str);

                            System.out.println("Entrez la date de fin du blocage sous format JJ/MM/AAAA");
                            str = sc.nextLine();
                            Date dateF = sdf.parse(str);

                            cpte = new Epargne(numero, solde, dateD, dateF, taux);
                        }
                        cpte.setClient(cl);
                        cl.addCompte(cpte);
                        service.creerCompte(cpte);
                        System.out.println("Compte créé avec succès !");

                    }
                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("\033c");
                    int choice;
                    do {
                        System.out.println("Quel type de compte souhaitez-vous créer ?");
                        System.out.println("1..Dépôt");
                        System.out.println("2..Retrait");
                        System.out.println("3..Virement");
                        System.out.println("4..Consultation");
                        choice = sc.nextInt();
                    } while (choice != 1 && choice != 2 && choice != 3 && choice != 4);
                    sc.nextLine();
                    System.out.println("Entrez le numéro de compte :");
                    String numero = sc.nextLine();
                    Compte compte = service.findCompteByNumero(numero);

                    if (compte == null) {
                        System.out.println("ce compte n'existe pas !");
                    } else {
                        if (choice == 4) {
                            System.out.println("Votre solde est : " + compte.consultation());
                            Transaction transaction = new Transaction(0, TypeTransaction.Consultation);
                            compte.addTransaction(transaction);
                            transaction.setCompte(compte);
                            service.faireTransaction(transaction);
                        } else {
                            if (compte instanceof Epargne) {
                                if (choice == 1 || choice == 2 || choice == 3) {
                                    System.out.print("Vous êtes sur un compte bloqué");
                                }
                            } else {
                                if (choice == 1) {
                                    System.out.println("Entrez le montant déposer :");
                                    double montant = sc.nextDouble();
                                    Transaction transaction = new Transaction(montant, TypeTransaction.Depot);
                                    compte.depot(montant);
                                    compte.addTransaction(transaction);
                                    transaction.setCompte(compte);
                                    service.faireTransaction(transaction);

                                } else if (choice == 2) {
                                    System.out.println("Entrez le montant à retirer :");
                                    double montant = sc.nextDouble();
                                    Transaction transaction = new Transaction(montant, TypeTransaction.Retrait);
                                    compte.retrait(montant);
                                    compte.addTransaction(transaction);
                                    transaction.setCompte(compte);
                                    service.faireTransaction(transaction);
                                } else if (choice == 3) {
                                    System.out.println("Entrez le montant à virer :");
                                    double montant = sc.nextDouble();
                                    System.out.println("Entrez le numero du compte receveur :");
                                    numero = sc.nextLine();
                                    Compte receveur = service.findCompteByNumero(numero);
                                    if (receveur == null) {
                                        System.out.println("ce compte n'existe pas !");
                                    } else {
                                        Transaction transaction = new Transaction(montant, TypeTransaction.Virement);
                                        compte.virement(montant, receveur);
                                        compte.addTransaction(transaction);
                                        transaction.setCompte(compte);
                                        service.faireTransaction(transaction);
                                    }
                                }
                            }
                        }
                    }
                    sc.nextLine();
                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

                case 6:
                    System.out.println("\033c");
                    System.out.println("Entrez le numéro de compte :");
                    numero = sc.nextLine();
                    compte = service.findCompteByNumero(numero);
                    if (compte == null) {
                        System.out.println("ce compte n'existe pas !");
                    } else {
                        System.out.println("Voici vos transactions :");
                        ArrayList<Transaction> transactions = compte.getTransactions();
                        for (Transaction transaction : transactions) {
                            System.out.println(transaction);
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

                case 7:
                    System.out.println("\033c");
                    System.out.println("Entrez l'Id du client :");
                    id = sc.nextInt();
                    sc.nextLine();
                    cl = service.findClientById(id);
                    if (cl == null) {
                        System.out.println("\n Ce client n'existe pas.");
                    } else {
                        System.out.println("Voici vos Transactions :");
                        ArrayList<Compte> comptes = cl.getComptes();
                        for (Compte cpte : comptes) {
                            ArrayList<Transaction> transactions = cpte.getTransactions();
                            for (Transaction transaction : transactions) {
                                System.out.println(transaction);
                            }
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer...");
                    sc.nextLine();
                    break;

            }
        } while (choix != 8);
        sc.close();
    }
}
