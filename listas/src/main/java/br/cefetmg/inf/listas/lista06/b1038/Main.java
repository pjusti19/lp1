package br.cefetmg.inf.listas.lista06.b1038;

import java.util.Scanner;

class Lanche{
    
    double preco[];
    int codigo, quantidade;
    
    Lanche() {
       preco = new double [] {0, 4.0, 4.5, 5.0, 2.0, 1.5};
    }
    double defTotal(){
        return preco[codigo] * quantidade;
    }
}

public class Main
{
	public static void main(String[] args) {
	    
		Scanner input = new Scanner(System.in);
		Lanche lanchinho = new Lanche();
		
		lanchinho.codigo = input.nextInt();
		lanchinho.quantidade = input.nextInt();
		
		System.out.printf("Total: R$ %.2f\n", lanchinho.defTotal());
	}
}