import java.util.Scanner;

import models.Client;
import models.Compte;
import models.Transaction;
import models.TypeTransaction;
import service.BanqueService;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        BanqueService service = new BanqueService();
        int choix;

        do {
            System.out.println("\033c");
            System.out.println("1. Ajouter un Client");
            System.out.println("2. Lister clients");
            System.out.println("3. Creer compte");
            System.out.println("4. Lister Comptes");
            System.out.println("5. lister les comptes d'un client");
            System.out.println("6. Faire une transactions");
            System.out.println("7. Lister les transactions d'un compte");
            System.out.println("8. Quitter");
            System.out.println("Faites votre choix");

            choix = sc.nextInt();
            sc.nextLine();
            switch (choix) {
                case 1:
                    System.out.println("\033c");
                    Client client = new Client();
                    System.out.println("Entrer l'id");
                    client.setId(sc.nextInt());
                    sc.nextLine();
                    System.out.println("Entrer le Nom & Prenom du client");
                    client.setNomComplet(sc.nextLine());
                    System.out.println("Entrer le numero de telephone");
                    client.setTel(sc.nextLine());
                    service.ajouterClient(client);
                    break;

                case 2:
                    System.out.println("\033c");
                    System.out.println("Liste des clients :");
                    Client[] clients = service.listerClient();
                    for (Client cl : clients) {
                        if (cl != null) {
                            System.out.println(cl);
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;
                case 3:
                    System.out.println("\033c");
                    System.out.println("Entrer l'id du client");
                    int id = sc.nextInt();
                    client = service.searchClientById(id);
                    if (client == null) {
                        System.out.println("Le Client n'existe pas");
                    } else {

                        Compte compte = new Compte();

                        System.out.println("entrer l'id du compte");
                        compte.setId(sc.nextInt());
                        sc.nextLine();

                        System.out.println("Entrer le numero du compte");
                        String num = sc.nextLine();
                        compte.setNumero(num);

                        System.out.println("Entrer le solde du compte");
                        compte.setSolde(sc.nextDouble());

                        // Relation Compte->Client
                        compte.setClient(client);
                        // relation Client -> Compte
                        client.addCompte(compte);

                        service.creerCompte(compte);

                    }
                    break;
                case 4:
                    System.out.println("\033c");
                    System.out.println("Liste des Comptes");
                    Compte[] comptes = service.listerComptes();
                    for (Compte cpt : comptes) {
                        if (cpt != null) {
                            System.out.println(cpt);
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;

                case 5:
                    System.out.println("\033c");
                    System.out.println("entrer l'id du Client");
                    client = service.searchClientById(sc.nextInt());

                    if (client == null) {
                        System.out.println("Le client n'existe pas");

                    } else {
                        comptes = client.getTabComptes();

                        for (Compte cpt : comptes) {
                            if (cpt != null) {
                                System.out.println(cpt);
                            }
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;
                case 6:
                    System.out.println("\033c");
                    System.out.println("Quelle opération souhaitez-vous effectuer ?");
                    int ch;
                    do {
                        System.out.println("1...Dépôt");
                        System.out.println("2...Retrait");
                        System.out.println("1...Virement");
                        ch = sc.nextInt();
                    } while (ch != 1 && ch != 2 && ch != 3);
                    sc.nextLine();
                    System.out.println("Entrez le numéro du compte");
                    String numero = sc.nextLine();
                    Compte cpte = service.searchCompteByNumero(numero);
                    if (cpte == null) {
                        System.out.println("Ce compte n'existe pas.");
                    } else {
                        if (ch == 1) {
                            System.out.println("Entrez le montant à déposer");
                            double montant = sc.nextDouble();
                            Transaction transac = new Transaction(1, montant, TypeTransaction.Depot);
                            cpte.setSolde(cpte.getSolde() + montant);
                            cpte.addTransaction(transac);
                            service.saveTransaction(transac);

                        } else if (ch == 2) {
                            System.out.println("Entrez le montant à retirer");
                            double montant = sc.nextDouble();
                            if (montant > cpte.getSolde()) {
                                System.out.println("Solde insuffisant!");
                            } else {
                                Transaction transac = new Transaction(2, montant, TypeTransaction.Retrait);
                                cpte.setSolde(cpte.getSolde() - montant);
                                cpte.addTransaction(transac);
                                service.saveTransaction(transac);
                            }
                        } else {
                            System.out.println("Entrez le numéro du compte receveur");
                            numero = sc.nextLine();
                            Compte cpte2 = service.searchCompteByNumero(numero);
                            if (cpte2 == null) {
                                System.out.println("Ce compte n'existe pas.");
                            } else {
                                System.out.println("Entrez le montant à virer");
                                double montant = sc.nextDouble();
                                if (montant > cpte.getSolde()) {
                                    System.out.println("Solde insuffisant!");
                                } else {
                                    Transaction transac = new Transaction(3, montant, TypeTransaction.Virement);
                                    cpte.setSolde(cpte.getSolde() - montant);
                                    cpte2.setSolde(cpte2.getSolde() + montant);
                                    cpte.addTransaction(transac);
                                    // cpte2.addTransaction(transac);
                                    service.saveTransaction(transac);
                                }
                            }
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;

                case 7:
                    System.out.println("\033c");
                    System.out.println("Entrez le numéro du Compte :");
                    numero = sc.nextLine();
                    cpte = service.searchCompteByNumero(numero);
                    if (cpte == null) {
                        System.out.println("Ce compte n'existe pas.");
                    } else {
                        for (Transaction transac : cpte.getTransactions()) {
                            System.out.println(transac);
                        }
                    }
                    System.out.println("\nTaper une touche pour continuer..");
                    sc.nextLine();
                    break;
            }

        } while (choix != 8);
        sc.close();

    }
}
