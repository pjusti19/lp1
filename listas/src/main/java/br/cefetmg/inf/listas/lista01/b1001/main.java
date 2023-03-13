package br.cefetmg.inf.listas.lista01.b1001;

import java.io.IOException;
import java.util.Scanner;

public class main {
    public static void main(String[] args) throws IOException {
 
        int x, y;
        
        Scanner input = new Scanner(System.in);
        
        x = input.nextInt();
        y = input.nextInt();
        
        System.out.printf("X = %d\n", x + y);
 
    }
}
