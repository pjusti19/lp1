package br.cefetmg.inf.listas.lista01.b1006;
 
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        Double primeiroNumero, segundoNumero, terceiroNumero;
        Scanner input = new Scanner(System.in);
        
        primeiroNumero = input.nextDouble();
        segundoNumero = input.nextDouble();
        terceiroNumero = input.nextDouble();
        
        System.out.printf("MEDIA = %.1f\n", (primeiroNumero*2+segundoNumero*3+terceiroNumero*5)/10);
 
    }
 
}