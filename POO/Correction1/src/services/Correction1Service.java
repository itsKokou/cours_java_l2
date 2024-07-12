package services;

public class Correction1Service {
    private final int N = 10;
    private double[] notes = new double[N]; // double notes[]; 
    private int nbreNotes; //taille réelle 
    private double[] notesSupMoy = new double[N];
    private int nbreNotesSupMoy;
    // les attributs d'une classe sont initialisés par défaut :
    // objet => null; booleen => false; numerique => 0
    public int getNbreNotes(){
        return nbreNotes;
    }
    
    public int getNbreNotesSupMoy() {
        return nbreNotesSupMoy;
    }
    public void ajouterNote(double note){
        if (nbreNotes <N){
            notes[nbreNotes] = note;
            nbreNotes++;
        }else{
            throw new RuntimeException("Le tableau est plein !");
        }
    }
    public double[] listerNote(){
        return notes;
    }
    public double noteMax(){
        double max = notes[0];
        for (int i=1; i<nbreNotes;++i){
            if (max < notes[i]){
                max = notes[i];
            }
        }
        return max;
    }
    public double noteMin() {
        double min = notes[0];
        for (int i = 1; i < nbreNotes; ++i) {
            if (min > notes[i]) {
                min = notes[i];
            }
        }
        return min;
    }
    public void triCroissant(){
        double temp;
        int j;
        for (int i = 1; i < nbreNotes; ++i){
            temp = notes[i];
            j = i;
            while (j>0 && notes[j-1]>temp){
                notes[j] = notes[j-1];
                j-=1;
            }
            notes[j]= temp;
        }
    }
    public void supprimerNote(int pos){
        if (pos<nbreNotes){
            for (int i = pos; i < nbreNotes-1; i++) {
                notes[i] = notes[i+1];
            }
        }
        nbreNotes--;
    }
    public double[]  transfertTab(){
        double som = 0;
        for (int i = 0; i < nbreNotes; i++) {
            som = som + notes[i];
        }
        double moy = som / nbreNotes;

        for (int i = 0; i < nbreNotes; i++) {
            if (notes[i] > moy) {
                notesSupMoy[nbreNotesSupMoy] = notes[i];
                nbreNotesSupMoy++;
            }
        }
        return notesSupMoy;
    }    
}
