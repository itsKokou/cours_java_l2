package services;

import java.util.Arrays;

public class Exo1Service {
    public void ajouterNote(double[] tab,double note,int pos){
        tab[pos] = note;
    }
    public String listerNote(double[] tab ){
        return Arrays.toString(tab);
    }
    public String listerNote2(double[] tab, int taille){
        String ch = "";
        for (int i = 0; i < taille; i++) {
            ch = ch + tab[i] + " ";
        }
        return ch;
    }
    public double noteMax(double[] tab, int taille){
        double max = tab[0];
        for (int i=1; i<taille; ++i){
            if (tab[i]> max){
                max = tab[i];
            }
        }
        return max;
    }
    public double noteMin(double[] tab, int taille) {
        double min = tab[0];
        for (int i = 1; i < taille; ++i) {
            if (tab[i] < min) {
                min = tab[i];
            }
        }
        return min;
    }
    public void triCroissant(double[] tab, int taille){
        double temp;
        for (int i = 1; i < taille; ++i) {
            temp =tab[i];
            int j;
            for ( j= i; j>0 && tab[j-1]>temp; --j){
                tab[j] = tab[j-1];
            }
            tab[j]=temp;
        }
    }
    public void supprimerNote(double[] tab, int taille, int pos){
        if (pos < taille-1) {
            for (int i = pos; i < taille-1; ++i) {
                tab[i] = tab[i+1];
            }          
        }
        
    }
    public int transfertTab(double[] tab, int taille, double[] newTab ){
        double som=0;
        for (int i = 0; i < taille; ++i){
            som =som + tab[i];
        }
        double moy = som/taille;
        int j=0;
        for (int i = 0; i < taille; ++i){
           if (tab[i]>moy){
            newTab[j]= tab[i];
            ++j;
           } 
        }
        return j;
    }
}
