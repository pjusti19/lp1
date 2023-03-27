package br.cefetmg.inf.listas.lista05.b1245;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        int n, i, k, count;
        Scanner input = new Scanner(System.in);
    while (input.hasNext())
    {
        int m[] = new int[10000];
        char l[] = new char[10000];
        n = input.nextInt();
        for (i = 0; i < n; i++){
            m[i] = input.nextInt();
            l[i] = input.next().charAt(0);
        }
        count = 0;
        for (i = 0; i < n; i++)
            for (k = 1; i + k < n && l[i]!=0; k++)
            {
                if (m[i] == m[i + k] && ((l[i] == 'D' && l[i + k] == 'E') || (l[i] == 'E' && l[i + k] == 'D')))
                {
                    count += 1;
                    l[i + k] = 0;
                    break;
                }
            }
        System.out.printf("%d\n", count);
    }
 
    }
 
}