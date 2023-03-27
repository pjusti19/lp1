package br.cefetmg.inf.listas.lista01.b1018;
 
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        int n, n100, n50, n20, n10, n5, n2, n1, r;
        
        
        Scanner input = new Scanner(System.in);
        
        n = input.nextInt();
        
        n100 = n / 100;
        r = n - n100 * 100;
    
        n50 = r / 50;
        r = r - n50 * 50;
    
        n20 = r / 20;
        r = r - n20 * 20;

        n10 = r / 10;
        r = r - n10 * 10;
    
        n5 = r / 5;
        r = r - n5 * 5;
    
        n2 = r / 2;
        r = r - n2 * 2;
    
        n1= r;
    
        
    System.out.printf("%d\n", n);
    System.out.printf("%d nota(s) de R$ 100,00\n", n100);
    System.out.printf("%d nota(s) de R$ 50,00\n", n50);
    System.out.printf("%d nota(s) de R$ 20,00\n", n20);
    System.out.printf("%d nota(s) de R$ 10,00\n", n10);
    System.out.printf("%d nota(s) de R$ 5,00\n", n5);
    System.out.printf("%d nota(s) de R$ 2,00\n", n2);
    System.out.printf("%d nota(s) de R$ 1,00\n", n1);
        
    }
 
}