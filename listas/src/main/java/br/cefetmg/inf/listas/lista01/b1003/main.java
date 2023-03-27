package br.cefetmg.inf.listas.lista01.b1003;
 
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args) {
 
        int primeiroNumero, segundoNumero, terceiroNumero;
        
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextInt();
        segundoNumero = input.nextInt();
        
        terceiroNumero = primeiroNumero + segundoNumero;
        
        System.out.printf("SOMA = %d\n", terceiroNumero);
    }
 
}