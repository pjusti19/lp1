package br.cefetmg.inf.listas.lista11.r1006;

import java.util.Scanner;

abstract class Fila {

    /**
     * Adiciona @code{item} no final da fila.
     */
    public abstract void enfileirar(Object item);

    /**
     * Remove um @code{item} no início da fila. return @code{item} no início da
     * fila ou @code{null} se a fila estiver vazia.
     */
    public abstract Object desenfileirar();

    /**
     * Recupera @code{item} no início da fila, sem remover.
     *
     * @return @code{item} no início da fila ou @code{null} se a fila estiver
     * vazia.
     */
    public abstract Object getItem();

    /**
     * Recupera número de itens na fila.
     *
     * @return Número de itens mantidos na fila.
     */
    public abstract int tamanho();

    /**
     * Retorna @code{true} se a fila não possuir qualquer @code{item}.
     *
     * @return @code{true} se a fila não possuir qualquer @code{item}, ou
     * @code{false} se possuir.
     */
    public abstract boolean estaVazia();

    /**
     * Retorna um array contendo todos os elementos da fila.
     *
     * @return um array com todos os elementos da fila @code{null} se a fila
     * estiver vazia.
     */
    public abstract Object[] toArray();
}

class FilaEncadeada extends Fila {

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

    private No inicio;
    private No fim;

    /**
     * Adiciona @code{item} no final da fila.
     */
    public void enfileirar(Object item) {
        No novo = new No();
        novo.setValor((Integer) item);
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
    public Integer desenfileirar() {
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
    public Integer getItem() {
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
    public int tamanho() {
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
    public boolean estaVazia() {
        return this.tamanho() == 0;
    }

    /**
     * Retorna um array contendo todos os elementos da fila.
     *
     * @return um array com todos os elementos da fila @code{null} se a fila
     * estiver vazia.
     */
    public Integer[] toArray() {
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

class FilaArray extends Fila {

    private int cont;
    private Integer itens[] = new Integer[10];

    public void FilhaArray() {
        this.cont = 0;
    }

    public void enfileirar(Object item) {
        this.itens[this.cont] = (Integer) item;
        this.cont++;
    }

    public Object desenfileirar() {
        if (estaVazia()) {
            return null;
        }
        int aux = this.itens[0];
        int tamanho = tamanho();
        for (int i = 0; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return aux;
    }

    public Object getItem() {
        if (estaVazia()) {
            return null;
        }
        return this.itens[0];
    }

    public int tamanho() {
        return this.cont;
    }

    public boolean estaVazia() {
        return tamanho() == 0;
    }

    public Object[] toArray() {
        if (estaVazia()) {
            return null;
        }
        Integer aux[] = new Integer[this.cont];
        int tamanho = this.cont;
        for (int i = 0; i < tamanho; i++) {
            aux[i] = this.itens[i];
        }
        return aux;
    }
}

class Main {

    private Fila fila;

    public Main(Fila fila) {
        this.fila = fila;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Integer valor;

        token = in.next();
        if (token.equals("FE")) {
            main = new Main(new FilaEncadeada());
        } else {
            main = new Main(new FilaArray());
        }

        while (!token.equals("Q")) {
            switch (token) {
                case "AF":
                    valor = in.nextInt();
                    main.fila.enfileirar(valor);
                    break;
                case "RI":
                    valor = (Integer) main.fila.desenfileirar();
                    if (valor == null) {
                        System.out.println("NenhumItemException");
                    }
                    break;
                case "G":
                    valor = (Integer) main.fila.getItem();
                    if (valor != null) {
                        System.out.println(valor);
                    } else {
                        System.out.println("NenhumItemException");
                    }
                    break;
                case "T":
                    System.out.println(main.fila.tamanho());
                    break;
                case "V":
                    System.out.println(main.fila.estaVazia());
                    break;
                case "P":
                    Integer valores[] = (Integer[]) main.fila.toArray();
                    if (valores != null) {
                        for (Integer item : valores) {
                            System.out.println(item);
                        }
                    }
                    break;
            }
            token = in.next();
        }

    }
}
