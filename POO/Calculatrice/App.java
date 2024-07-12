import java.util.Scanner; // Importer la classe Scanner
public class App{
    public static void main(String[] args){
        Scanner sc; 
        sc = new Scanner(System.in);
        int choix;
        do{
            System.out.println("Entrez deux nombres");
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            System.out.println("1-Addition");
            System.out.println("2-Multiplication");
            System.out.println("3-Division");
            System.out.println("4-Modulo");
            System.out.println("5-Quitter");
            choix = sc.nextInt(); //lire l'entier et le mettre dans la variable
            switch(choix){
                case 1 : 
                    int som = n1 + n2 ;
                    System.out.println("La somme est "+ som);
                break;            
                case 2 : 
                    int prod = n1 * n2 ;
                    System.out.println("Le produit vaut "+ prod);
                break;            
                case 3 : 
                    if (n2!=0){
                        int div = n1 / n2 ;
                        System.out.println("Le quotient vaut "+ div);
                    }else{
                        System.out.println("Impossible de diviser par 0");
                    }  
                break;            
                case 4 :
                    if (n2!=0){
                        int div = n1 % n2 ;
                        System.out.println("Le reste de la divison vaut "+ div);
                    }else{
                        System.out.println("Impossible de diviser par 0");
                    }   
                break;                       
            }
        }while(choix != 5);
        sc.close();
    }
}