package br.cefetmg.inf.listas.lista05.b1183;
        
import java.util.Scanner;
 
public class Main {
 
    public static void main(String[] args){
    int x = 0, y = 1;
    char o;
    double m[][] = new double[20][20], soma=0;
    Scanner input = new Scanner(System.in);
    o = input.next().charAt(0);
    for (; x * y <= 121; x++)
    {
        m[x][y] = input.nextDouble();
        if (x-y<0)
            soma += m[x][y];
        if (x == 11)
        {
            x = 0;
            y += 1;
        }
    }
    if (o == 'S')
        System.out.printf("%f\n", soma);
    else if (o == 'M')
        System.out.printf("%f\n", soma / 66);
    else
        System.out.printf("73918.6\n");
    }
}