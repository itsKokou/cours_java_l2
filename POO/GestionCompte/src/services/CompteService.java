package services;

import java.util.ArrayList;
import models.Client;
import models.Compte;
import models.Transaction;

public class CompteService {
    private ArrayList<Client> clients = new ArrayList<Client>();
    private ArrayList<Compte> comptes = new ArrayList<Compte>();
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();
    
    public void ajouterClient(Client cl){
        clients.add(cl);
    }

    public ArrayList<Client> listerClient(){
        return clients;
    }

    public Client findClientById(int id){
        for (Client cl : clients) {
            if(cl.getId()==id){
                return cl;
            }
        }
        return null;
    }

    public void creerCompte(Compte compte){
        comptes.add(compte);
    }

    public void faireTransaction(Transaction transaction){
        transactions.add(transaction);
    }

    public Compte findCompteByNumero(String numero){
        for (Compte compte : comptes) {
            if(numero.equals(compte.getNumero())){
                return compte;
            }
        }
        return null;
    }

    
    
}
