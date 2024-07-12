package services;

public class CalculatriceService{
    public int addition(int a,int b){
        return a+b;
    }
    public int multiplication(int a,int b){
        return a*b;
    }
    public int division(int a,int b){
        if (b == 0){
            throw new RuntimeException("Division par zéro impossible !");
        }
        return a/b;
    }
    public int modulo(int a,int b){
        if (b == 0){
            throw new RuntimeException("Division par zéro impossible !");
        }
        return a%b;
    }

}