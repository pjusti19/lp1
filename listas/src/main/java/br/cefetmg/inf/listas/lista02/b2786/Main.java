package br.cefetmg.inf.listas.lista02.b2786;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
    Double c,l,a,b;
    Scanner input = new Scanner(System.in);
    
    c = input.nextDouble();
    l = input.nextDouble();
    
    b=(2*(c-1))+(2*(l-1));
    a=((c*l)-0.5-(b*0.25))/0.5;

    System.out.printf("%.0f\n",a);
    System.out.printf("%.0f\n",b);
 
    }
 
}