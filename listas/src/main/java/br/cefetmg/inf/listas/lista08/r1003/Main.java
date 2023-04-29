package br.cefetmg.inf.listas.lista08.r1003;

import java.util.Scanner;

class No {

    private Integer valor;
    private No proximo;

    public Integer getValor() {
        return valor;
    }

    public void setValor(Integer valor) {
        this.valor = valor;
    }

    public No getProximo() {
        return proximo;
    }

    public void setProximo(No proximo) {
        this.proximo = proximo;
    }

}

class Fila {

    private No inicio;
    private No fim;

    /**
     * Adiciona @code{item} no final da fila.
     */
    void enfileirar(Integer item) {
        No novo = new No();
        novo.setValor(item);
        novo.setProximo(null);
        if (this.estaVazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
    }

    /**
     * Remove um @code{item} no início da fila. return @code{item} no início da
     * fila ou @code{null} se a fila estiver vazia.
     */
    Integer desenfileirar() {
        if (this.estaVazia()) {
            return null;
        }
        No aux = inicio;
        inicio = inicio.getProximo();
        return aux.getValor();
    }

    /**
     * Recupera @code{item} no início da fila, sem remover.
     *
     * @return @code{item} no início da fila ou @code{null} se a fila estiver
     * vazia.
     */
    Integer getItem() {
        if (this.estaVazia()) {
            return null;
        }
        return inicio.getValor();
    }

    /**
     * Recupera número de itens na fila.
     *
     * @return Número de itens mantidos na fila.
     */
    int tamanho() {
        if (inicio == null) {
            return 0;
        }

        int tamanho = 1;
        No auxiliar = inicio;
        while (auxiliar.getProximo() != null) {
            auxiliar = auxiliar.getProximo();
            tamanho++;
        }

        return tamanho;
    }

    /**
     * Retorna @code{true} se a fila não possuir qualquer @code{item}.
     *
     * @return @code{true} se a fila não possuir qualquer @code{item}, ou
     * @code{false} se possuir.
     */
    boolean estaVazia() {
        return this.tamanho() == 0;
    }

    /**
     * Retorna um array contendo todos os elementos da fila.
     *
     * @return um array com todos os elementos da fila @code{null} se a fila
     * estiver vazia.
     */
    Integer[] toArray() {
        if (this.estaVazia()) {
            return null;
        }
        Integer[] array = new Integer[this.tamanho()];
        No aux = this.inicio;
        int tamanhoFila = this.tamanho();

        for (int i = 0; i < tamanhoFila; i++) {
            array[i] = aux.getValor();
            aux = aux.getProximo();
        }

        return array;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Fila fila = new Fila();
        String token;
        Integer valor;

        token = in.next();
        while (!token.equals("Q")) {
            switch (token) {
                case "AF":
                    valor = in.nextInt();
                    fila.enfileirar(valor);
                    break;
                case "RI":
                    valor = fila.desenfileirar();
                    if (valor == null) {
                        System.out.println("NenhumItemException");
                    }
                    break;
                case "G":
                    valor = fila.getItem();
                    if (valor != null) {
                        System.out.println(valor);
                    } else {
                        System.out.println("NenhumItemException");
                    }
                    break;
                case "T":
                    System.out.println(fila.tamanho());
                    break;
                case "V":
                    System.out.println(fila.estaVazia());
                    break;
                case "P":
                    Integer valores[] = fila.toArray();
                    if (valores != null) {
                        for (Integer item : valores) {
                            System.out.println(item);
                        }
                    }
                    break;
            }
            token = in.next();
        }
        in.close();
    }
}
