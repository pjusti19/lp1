package br.cefetmg.inf.listas.lista07.b1245;

import java.util.Scanner;

class Pe {

    char pe[];

    Pe(int n) {
        pe = new char[10000];
    }
}

class Tamanho {

    int tamanho[];

    Tamanho(int n) {
        tamanho = new int[10000];
    }
}

public class Main {

    public static void main(String[] args) {

        int n, posicaoInicial, posicaoSeguinte, count;
        Scanner input = new Scanner(System.in);

        while (input.hasNext()) {
            n = input.nextInt();
            count = 0;
            Tamanho dimensao = new Tamanho(n);
            Pe pezinho = new Pe(n);

            for (int x = 0; x < n; x++) {
                dimensao.tamanho[x] = input.nextInt();
                pezinho.pe[x] = input.next().charAt(0);
            }

            for (posicaoInicial = 0; posicaoInicial < n; posicaoInicial++) {
                for (posicaoSeguinte = 1; posicaoInicial + posicaoSeguinte < n && pezinho.pe[posicaoInicial] != 0; posicaoSeguinte++) {
                    if (dimensao.tamanho[posicaoInicial] == dimensao.tamanho[posicaoInicial + posicaoSeguinte] && ((pezinho.pe[posicaoInicial] == 'D' && pezinho.pe[posicaoInicial + posicaoSeguinte] == 'E') || (pezinho.pe[posicaoInicial] == 'E' && pezinho.pe[posicaoInicial + posicaoSeguinte] == 'D'))) {
                        count += 1;
                        pezinho.pe[posicaoInicial + posicaoSeguinte] = 0;
                        break;
                    }
                }
            }
            System.out.printf("%d\n", count);
        }
        input.close();
    }

}
