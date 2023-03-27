package br.cefetmg.inf.listas.lista04.b1067;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        int i = 1, x;
        Scanner input = new Scanner(System.in);
        x = input.nextInt();
        while (i <= x)
        {
            if (i % 2 != 0)
                System.out.printf("%d\n", i);
            i++;
        }
 
    }
 
}