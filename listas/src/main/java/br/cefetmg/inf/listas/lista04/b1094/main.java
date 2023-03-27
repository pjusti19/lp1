package br.cefetmg.inf.listas.lista04.b1094;

import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args){
 
    int n, i = 1, q, tc=0, tr=0, ts=0;
    char t;
    Scanner input = new Scanner(System.in);
    n = input.nextInt();
    while (i <= n)
    {
        q = input.nextInt();
        t = input.next().charAt(0);
            if (t == 'C')
                tc+=q;
            if (t == 'R')
                tr+=q;
            if (t == 'S')
                ts+=q;
        i++;
    }
    System.out.printf("Total: %d cobaias\n", tc + tr + ts);
    System.out.printf("Total de coelhos: %d\n", tc);
    System.out.printf("Total de ratos: %d\n", tr);
    System.out.printf("Total de sapos: %d\n", ts);
    System.out.printf("Percentual de coelhos: %.2f %%\n", (double) (tc * 100) / (tc + tr + ts));
    System.out.printf("Percentual de ratos: %.2f %%\n", (double) (tr * 100) / (tc + tr + ts));
    System.out.printf("Percentual de sapos: %.2f %%\n", (double) (ts * 100) / (tc + tr + ts));
 
    }
 
}