import java.util.ArrayList;
import java.util.Scanner;

import models.Client;
import services.CompteServices;

public class App {
    private static Scanner sc = new Scanner (System.in);
    private static CompteServices services=new CompteServices();
    public static void main(String[] args) throws Exception {
        int choix ;
        do {
            choix=menu();
            switch (choix){
                case 1:
                sc.nextLine();
                    Client client =new Client();
                    System.out.println("enter le nom du client");
                    client.setNom(sc.nextLine());
                    System.out.println("entrer le prenom");
                    client.setPrenom(sc.nextLine());
                    services.ajouterClient(client);

                    break;
                case 2:
                    ArrayList<Client>clients=services.listerClient();
                    for (Client cl  : clients) {
                        System.out.println(cl);
                    }

                    break;
                case 3:
                    
                    break;
                default:
                    break;
            }
        } while (choix!=3);
    }
    public static int menu(){
        System.out.println("1:ajouter client");
        System.out.println("2:Lister clients");
        int choix=sc.nextInt();
        return choix ;
    }

   
}
