package service;

import models.Client;
import models.Compte;
import models.Transaction;

public class BanqueService {

    private final int N=10;
    private Client[] clients= new Client[N];
    private int nbrClient;

    private Compte[] comptes = new Compte[N];
    private int nbrCompte;

    private Transaction[] transactions = new Transaction[N];
    private int nbrTransaction;
    
    public void ajouterClient(Client client){
        clients[nbrClient]=client;
        nbrClient++;
    }

    public Client[] listerClient(){
        return clients;
    }


    public void creerCompte(Compte compte){
        comptes[nbrCompte]=compte;
        nbrCompte++;
    }

    public Compte[] listerComptes(){
        return comptes;
    }


    public Client searchClientById(int id){

        for(int i=0;i<nbrClient;i++){

            if(id==clients[i].getId()){
                return clients[i];
            }
        }
        return null;
    }

    public void saveTransaction(Transaction transaction){

        transactions[nbrTransaction]=transaction;
        nbrTransaction++;
    }

    public Compte searchCompteByNumero(String numero){

        for(int i=0;i<nbrCompte;i++){
            if(numero.equals(comptes[i].getNumero())){
                return comptes[i];
            }
        }

        return null;
    }
    

    
}
