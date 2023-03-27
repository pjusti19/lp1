package br.cefetmg.inf.listas.lista04.b1134;
import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        int x=0, a = 0, g = 0, d = 0;
        Scanner input = new Scanner(System.in);

        while (x != 4)
        {
            x= input.nextInt();
            if (x == 1)
                a++;
            if (x == 2)
                g++;
            if (x == 3)
                d++;
        }
            System.out.printf("MUITO OBRIGADO\n");
            System.out.printf("Alcool: %d\n", a);
            System.out.printf("Gasolina: %d\n", g);
            System.out.printf("Diesel: %d\n", d);
 
        }
 
}