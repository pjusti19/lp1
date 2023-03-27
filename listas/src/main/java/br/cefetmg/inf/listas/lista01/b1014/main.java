package br.cefetmg.inf.listas.lista01.b1014;
 
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
       Double primeiroNumero, segundoNumero;
        
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextDouble();
        segundoNumero = input.nextDouble();
        
        
        System.out.printf("%.3f km/l\n", primeiroNumero/segundoNumero );
 
    }
 
}