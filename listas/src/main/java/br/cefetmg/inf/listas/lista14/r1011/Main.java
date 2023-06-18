package br.cefetmg.inf.listas.lista14.r1011;

import java.util.Scanner;

class NenhumItemException extends RuntimeException {

    public NenhumItemException() {
        super("NenhumItemException");
    }
}

@SuppressWarnings("unchecked")
interface ListaCommon<T> {

    T getItem(); // throws NenhumItemException

    int tamanho();

    ;

    boolean vazia();

    Object[] toArray();

    T[] toArray(T[] x); // throws NenhumItemException
}

interface ListaBasica<T> extends ListaCommon<T> {

    void adicionar(T item);

    T remover(); // throws NenhumItemException
}

interface Pilha<T> extends ListaCommon<T> {

    void empilhar(T item);

    T desempilhar(); // throws NenhumItemException
}

class PilhaEncadeada<T> implements Pilha<T> {

    private static class No<T> {

        T item;
        No<T> proximo;

        public No(T item, No<T> proximo) {
            this.item = item;
            this.proximo = proximo;
        }
    }

    private No<T> topo;

    PilhaEncadeada() {
        topo = null;
    }

    @Override
    public void empilhar(T item) {
        No<T> novo = new No<>(item, topo);
        topo = novo;
    }

    @Override
    public T desempilhar() {
        if (vazia()) {
            throw new NenhumItemException();
        }

        No<T> x = topo;
        topo = topo.proximo;
        x.proximo = null;

        return x.item;
    }

    @Override
    public T getItem() {
        if (vazia()) {
            throw new NenhumItemException();
        }

        return topo.item;
    }

    @Override
    public int tamanho() {
        int cont = 0;
        for (No<T> x = topo; x != null; x = x.proximo) {
            cont++;
        }

        return cont;
    }

    @Override
    public boolean vazia() {
        return topo == null;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        if (vazia()) {
            throw new NenhumItemException();
        }

        Object[] items = new Object[tamanho()];

        int i = 0;
        for (No<T> x = topo; x != null; x = x.proximo) {
            items[i++] = x.item;
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray(T[] items) {
        if (vazia()) {
            throw new NenhumItemException();
        }

        if (items.length < tamanho()) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }

        int i = 0;
        for (No<T> aux = topo; aux != null; aux = aux.proximo) {
            items[i++] = aux.item;
        }

        return items;
    }
}

class PilhaArray<T> implements Pilha<T> {

    private int cont;
    private Object arr[];
    private T itens[];

    @SuppressWarnings("unchecked")
    public void PilhaArray() {
        arr = new Object[10];
        itens = (T[]) arr[10];
        this.cont = 0;
    }

    @Override
    public void empilhar(T item) {
        this.itens[this.cont] = item;
        this.cont++;
    }

    @Override
    public T desempilhar() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        T aux = this.itens[this.cont - 1];
        this.itens[this.cont - 1] = null;
        this.cont--;
        return aux;
    }

    @Override
    public T getItem() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        return this.itens[this.cont - 1];
    }

    @Override
    public int tamanho() {
        return this.cont;
    }

    @Override
    public boolean vazia() {
        return tamanho() == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        Object arr[] = new Object[tamanho];
        T items[] = (T[]) arr[tamanho];
        for (int i = 0; i < tamanho; i++) {
            items[tamanho - i - 1] = this.itens[i];
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray(T[] items) {
        if (vazia()) {
            throw new NenhumItemException();
        }
        if (items.length < tamanho()) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        int tamanho = this.cont;
        for (int i = 0; i < tamanho; i++) {
            items[tamanho - i - 1] = this.itens[i];
        }
        return items;
    }

}

interface Fila<T> extends ListaCommon<T> {

    void enfileirar(Object item);

    T desenfileirar(); // throws NenhumItemException
}

class FilaEncadeada<T> implements Fila<T> {

    class No {

        private T valor;
        private No proximo;

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
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

    @SuppressWarnings("unchecked")
    @Override
    public void enfileirar(Object item) {
        No novo = new No();
        novo.setValor((T) item);
        novo.setProximo(null);
        if (this.vazia()) {
            inicio = novo;
            fim = novo;
        } else {
            fim.setProximo(novo);
            fim = novo;
        }
    }

    @Override
    public T desenfileirar() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        No aux = inicio;
        inicio = inicio.getProximo();
        return aux.getValor();
    }

    @Override
    public T getItem() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        return inicio.getValor();
    }

    @Override
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

    @Override
    public boolean vazia() {
        return this.tamanho() == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = this.tamanho();
        Object arr[] = new Object[tamanho];
        T items[] = (T[]) arr[tamanho];
        No aux = this.inicio;

        for (int i = 0; i < tamanho; i++) {
            items[i] = aux.getValor();
            aux = aux.getProximo();
        }
        return items;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] items) {
        if (vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        if (items.length < tamanho) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        No aux = this.inicio;
        for (int i = 0; i < tamanho; i++) {
            items[i] = aux.getValor();
            aux = aux.getProximo();
        }
        return items;
    }
}

class FilaArray<T> implements Fila<T> {

    private int cont;
    private Object arr[];
    private T itens[];

    @SuppressWarnings("unchecked")
    public void FilaArray() {
        arr = new Object[10];
        itens = (T[]) arr[10];
        this.cont = 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public void enfileirar(Object item) {
        this.itens[this.cont] = (T) item;
        this.cont++;
    }

    @Override
    public T desenfileirar() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        T aux = this.itens[0];
        int tamanho = tamanho();
        for (int i = 0; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return aux;
    }

    @Override
    public T getItem() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        return this.itens[0];
    }

    @Override
    public int tamanho() {
        return this.cont;
    }

    @Override
    public boolean vazia() {
        return tamanho() == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = this.cont;
        Object arr[] = new Object[tamanho];
        T items[] = (T[]) arr[tamanho];
        for (int i = 0; i < tamanho; i++) {
            items[i] = this.itens[i];
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray(T[] items) {
        if (vazia()) {
            throw new NenhumItemException();
        }
        if (items.length < tamanho()) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        int tamanho = this.cont;
        for (int i = 0; i < tamanho; i++) {
            items[i] = this.itens[i];
        }
        return items;
    }
}

interface Lista<T> extends ListaBasica<T> {

    void adicionarInicio(Object item);

    void adicionarFim(Object item);

    void adicionar(Object item, int posicao); // throws PosicaoInvalidaException

    Object removerInicio(); // throws NenhumItemException

    Object removerFim(); // throws NenhumItemException

    Object remover(int posicao); // throws NenhumItemException, PosicaoInvalidaExeption

    Object getItem(int posicao); // throws PosicaoInvalidaExeption
}

class ListaEncadeada<T> implements Lista<T> {

    class No {

        private T valor;
        private No proximo;

        public T getValor() {
            return valor;
        }

        public void setValor(T valor) {
            this.valor = valor;
        }

        public No getProximo() {
            return proximo;
        }

        public void setProximo(No proximo) {
            this.proximo = proximo;
        }

    }
    private No base;

    private No getUltimo() {
        No aux = base;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        return aux;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionarFim(Object valor) {
        No novo = new No();
        novo.setValor((T) valor);
        novo.setProximo(null);
        if (this.vazia()) {
            base = novo;
        } else {
            No topo = getUltimo();
            topo.setProximo(novo);
        }
    }

    @Override
    public void adicionar(T valor) {
        No novo = new No();
        novo.setValor(valor);
        novo.setProximo(null);
        if (this.vazia()) {
            base = novo;
        } else {
            No topo = getUltimo();
            topo.setProximo(novo);
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionarInicio(Object valor) {
        No novo = new No();
        novo.setValor((T) valor);
        if (this.vazia()) {
            novo.setProximo(null);
            base = novo;
        } else {
            novo.setProximo(base);
            base = novo;
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionar(Object valor, int posicao) {
        if (posicao == 0) {
            adicionarInicio(valor);
            return;
        }
        if (this.tamanho() < posicao) {

        }
        No novo = new No();
        novo.setValor((T) valor);
        if (this.vazia()) {
            novo.setProximo(null);
            base = novo;
        } else {
            No aux = base;
            for (int i = 0; i < posicao - 1; i++) {
                aux = aux.getProximo();
            }
            novo.setProximo(aux.getProximo());
            aux.setProximo(novo);
        }
    }

    @Override
    public Object removerInicio() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        base = base.getProximo();
        return 0;
    }

    @Override
    public T remover() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        T aux = base.getValor();
        base = base.getProximo();
        return aux;
    }

    @Override
    public Object removerFim() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        No aux = base;
        int tamanhoLista = this.tamanho();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            aux = aux.getProximo();
        }
        aux.setProximo(null);
        return 0;
    }

    @Override
    public Object remover(int posicao) {
        if (posicao == 0) {
            removerInicio();
            return 0;
        }
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        if (this.tamanho() <= posicao) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        No aux = base;
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.getProximo();
        }
        aux.setProximo(aux.getProximo().getProximo());
        return 0;
    }

    @Override
    public T getItem() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        return getUltimo().getValor();
    }

    @Override
    public Object getItem(int posicao) {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        if (this.tamanho() < posicao) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        No aux = this.base;
        for (int i = 0; i < posicao; i++) {
            aux = aux.getProximo();
        }
        return aux.getValor();
    }

    @Override
    public int tamanho() {
        if (base == null) {
            return 0;
        }

        int tamanho = 1;
        No auxiliar = base;
        while (auxiliar.getProximo() != null) {
            auxiliar = auxiliar.getProximo();
            tamanho++;
        }

        return tamanho;
    }

    @Override
    public boolean vazia() {
        return this.tamanho() == 0;
    }

    @Override
    @SuppressWarnings("unchecked")
    public Object[] toArray() {
        if (this.vazia()) {
            return null;
        }
        No aux = this.base;
        int tamanho = this.tamanho();
        Object arr[] = new Object[tamanho];
        T items[] = (T[]) arr[tamanho];
        for (int i = 0; i < tamanho; i++) {
            items[i] = aux.getValor();
            aux = aux.getProximo();
        }

        return items;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T[] toArray(T[] items) {
        if (vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        if (items.length < tamanho) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        No aux = this.base;
        for (int i = 0; i < tamanho; i++) {
            items[i] = aux.getValor();
            aux = aux.getProximo();
        }
        return items;
    }
}

class ListaArray<T> implements Lista<T> {

    private int cont;
    private Object arr[];
    private T itens[];

    public void ListaArray() {
        this.cont = 0;
        arr = new Object[10];
        itens = (T[]) arr[10];
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionarFim(Object item) {
        int tamanho = tamanho();
        this.itens[tamanho] = (T) item;
        this.cont++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionar(T item) {
        int tamanho = tamanho();
        this.itens[tamanho] = (T) item;
        this.cont++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionarInicio(Object item) {
        int tamanho = tamanho();
        for (int i = tamanho - 1; i >= 0; i--) {
            this.itens[i + 1] = this.itens[i];
        }
        this.itens[0] = (T) item;
        this.cont++;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void adicionar(Object valor, int posicao) {
        int tamanho = tamanho();
        if (tamanho < posicao) {
            throw new NenhumItemException();
        }
        if (posicao == 0) {
            adicionarInicio(valor);
        } else {
            for (int i = tamanho; i >= posicao; i--) {
                this.itens[i] = this.itens[i - 1];
            }
            this.itens[posicao] = (T) valor;
            this.cont++;
        }
    }

    @Override
    public Object removerInicio() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        for (int i = 0; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return 0;
    }

    @Override
    public T remover() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        T aux = this.itens[0];
        for (int i = 0; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return aux;
    }

    @Override
    public Object removerFim() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        this.itens[tamanho - 1] = null;
        this.cont--;
        return 0;
    }

    @Override
    public Object remover(int posicao) {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        if (tamanho <= posicao) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return 0;
    }

    @Override
    public T getItem() {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        return this.itens[tamanho - 1];
    }

    @Override
    public Object getItem(int posicao) {
        if (this.vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = tamanho();
        if (tamanho <= posicao) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        return this.itens[posicao];
    }

    @Override
    public int tamanho() {
        return this.cont;
    }

    @Override
    public boolean vazia() {
        return tamanho() == 0;
    }

    @SuppressWarnings("unchecked")
    @Override
    public Object[] toArray() {
        if (vazia()) {
            throw new NenhumItemException();
        }
        int tamanho = this.cont;
        Object arr[] = new Object[tamanho];
        T items[] = (T[]) arr[tamanho];
        for (int i = 0; i < tamanho; i++) {
            items[i] = this.itens[i];
        }
        return items;
    }

    @SuppressWarnings("unchecked")
    @Override
    public T[] toArray(T[] items) {
        if (vazia()) {
            throw new NenhumItemException();
        }
        if (items.length < tamanho()) {
            throw new RuntimeException("Array de destino deve ser maior ou igual ao tamanho da pilha.");
        }
        int tamanho = this.cont;
        for (int i = 0; i < tamanho; i++) {
            items[i] = this.itens[i];
        }
        return items;
    }
}

class PilhaAdapter<T> implements ListaBasica<T> {

    private final Pilha<T> pilha;

    public PilhaAdapter(Pilha<T> pilha) {
        this.pilha = pilha;
    }

    @Override
    public void adicionar(T item) {
        pilha.empilhar(item);
    }

    @Override
    public T remover() {
        return pilha.desempilhar();
    }

    @Override
    public T getItem() {
        return pilha.getItem();
    }

    @Override
    public int tamanho() {
        return pilha.tamanho();
    }

    @Override
    public boolean vazia() {
        return pilha.vazia();
    }

    @Override
    public Object[] toArray() {
        return pilha.toArray();
    }

    @Override
    public T[] toArray(T[] items) {
        return pilha.toArray(items);
    }
}

class FilaAdapter<T> implements ListaBasica<T> {

    private final Fila<T> fila;

    public FilaAdapter(Fila<T> fila) {
        this.fila = fila;
    }

    @Override
    public void adicionar(T item) {
        fila.enfileirar(item);
    }

    @Override
    public T remover() {
        return fila.desenfileirar();
    }

    @Override
    public T getItem() {
        return fila.getItem();
    }

    @Override
    public int tamanho() {
        return fila.tamanho();
    }

    @Override
    public boolean vazia() {
        return fila.vazia();
    }

    @Override
    public Object[] toArray() {
        return fila.toArray();
    }

    @Override
    public T[] toArray(T[] items) {
        return fila.toArray(items);
    }
}

class Main {

    private final ListaBasica<Integer> lista;

    public Main(ListaBasica<Integer> lista) {
        this.lista = lista;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Integer valor;

        token = in.next();

        switch (token) {
            case "PE":
                main = new Main(new PilhaAdapter<>(new PilhaEncadeada<>()));
                break;
            case "PA":
                main = new Main(new PilhaAdapter(new PilhaArray()));
                break;
            case "FE":
                main = new Main(new FilaAdapter(new FilaEncadeada()));
                break;
            case "FA":
                main = new Main(new FilaAdapter(new FilaArray()));
                break;
            case "LE":
                main = new Main(new ListaEncadeada());
                break;
            default:
                main = new Main(new ListaArray());
        }

        while (!token.equals("Q")) {
            switch (token) {
                case "A": // adiciona um item
                    valor = in.nextInt();
                    main.lista.adicionar(valor);
                    break;
                case "R": // remove um item
                    try {
                    main.lista.remover();
                } catch (NenhumItemException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "G": // retorna um item, sem remover
                    try {
                    valor = main.lista.getItem();
                    System.out.println(valor);
                } catch (NenhumItemException e) {
                    System.out.println(e.getMessage());
                }
                break;
                case "T": // numero de itens na estrutura
                    System.out.println(main.lista.tamanho());
                    break;
                case "V": // indica se a estrutura esta vazia
                    System.out.println(main.lista.vazia());
                    break;
                case "P": // imprime os itens da estrutura, sem remover
                    try {
                    Integer valores[] = new Integer[main.lista.tamanho()];
                    valores = main.lista.toArray(valores);
                    if (valores != null) {
                        for (Integer item : valores) {
                            System.out.println(item);
                        }
                    }
                } catch (NenhumItemException e) {
                }
                break;
            }
            token = in.next();
        }
        in.close();
    }
}
