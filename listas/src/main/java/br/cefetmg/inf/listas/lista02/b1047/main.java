package br.cefetmg.inf.listas.lista02.b1047;

import java.util.Scanner;

public class Main {
 
    public static void main(String[] args){
 
        int A,B,C,D,R,X,TMAX,r;

    Scanner input = new Scanner(System.in);
    A = input.nextInt();
    B = input.nextInt();
    C = input.nextInt();
    D = input.nextInt();
    
    TMAX = 24 * 60;
    
    X = (C * 60 + D) - (A * 60 + B);
    
    X = X - 1;
    
    X = (X + TMAX) % TMAX;
    
    X = X + 1;
    
    R = X / 60;
    
    r = X % 60;

    System.out.printf("O JOGO DUROU %d HORA(S) E %d MINUTO(S)\n",R,r);
 
    }
 
}