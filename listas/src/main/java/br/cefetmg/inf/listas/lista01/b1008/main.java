package br.cefetmg.inf.listas.lista01.b1008;
 
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        int primeiroNumero, segundoNumero;
        double terceiroNumero;
        
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextInt();
        segundoNumero = input.nextInt();
        terceiroNumero = input.nextDouble();
        
        
        System.out.printf("NUMBER = %d\n", primeiroNumero);
        System.out.printf("SALARY = U$ %.2f\n", segundoNumero*terceiroNumero);
 
    }
 
}