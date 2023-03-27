package br.cefetmg.inf.listas.lista01.b1001;

import java.util.Scanner;

public class Main {
    public static void main(String[] args){
 
        int x, y;
        
        Scanner input = new Scanner(System.in);
        
        x = input.nextInt();
        y = input.nextInt();
        
        System.out.printf("X = %d\n", x + y);
 
    }
}
