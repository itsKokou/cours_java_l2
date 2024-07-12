package services;
import java.util.ArrayList;

import models.Client;
import models.Compte;

public class CompteServices {
    private ArrayList<Client> clients=new ArrayList<>();
    private ArrayList<Compte> comptes=new ArrayList<>();
    public void ajouterClient (Client client){
        clients.add(client);
    }
    public ArrayList<Client> listerClient(){
        return clients;
    }
}








