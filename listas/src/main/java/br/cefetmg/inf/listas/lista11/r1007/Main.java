package br.cefetmg.inf.listas.lista11.r1007;

import java.util.Scanner;

enum ErroLista {
    INDICE_INVALIDO("PosicaoInvalidaException"),
    VAZIA("NenhumItemException"),
    SEM_ERRO("NenhumErro");

    String msgErro;

    ErroLista(String msg) {
        msgErro = msg;
    }

    public String getMessage() {
        return msgErro;
    }
}

class ErroListaWrapper {

    private ErroLista erro;

    public ErroListaWrapper() {
        this(ErroLista.SEM_ERRO);
    }

    public ErroListaWrapper(ErroLista erro) {
        this.erro = erro;
    }

    public ErroLista getErro() {
        return erro;
    }

    public void setErro(ErroLista erro) {
        this.erro = erro;
    }
}

abstract class Lista {

    public abstract void adicionarFim(Object item);

    public abstract void adicionarInicio(Object item);

    public abstract void adicionar(Object valor, int posicao, ErroListaWrapper erro);

    public abstract Object removerInicio(ErroListaWrapper erro);

    public abstract Object removerFim(ErroListaWrapper erro);

    public abstract Object remover(int posicao, ErroListaWrapper erro);

    public abstract Object getItem(ErroListaWrapper erro);

    public abstract Object getItem(int posicao, ErroListaWrapper erro);

    public abstract int tamanho();

    public abstract boolean vazia();

    public abstract Object[] toArray();
}

class ListaEncadeada extends Lista {

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
    private No base;

    private No getUltimo() {
        No aux = base;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        return aux;
    }

    public void adicionarFim(Object valor) {
        No novo = new No();
        novo.setValor((Integer) valor);
        novo.setProximo(null);
        if (this.vazia()) {
            base = novo;
        } else {
            No topo = getUltimo();
            topo.setProximo(novo);
        }
    }

    public void adicionarInicio(Object valor) {
        No novo = new No();
        novo.setValor((Integer) valor);
        if (this.vazia()) {
            novo.setProximo(null);
            base = novo;
        } else {
            novo.setProximo(base);
            base = novo;
        }
    }

    public void adicionar(Object valor, int posicao, ErroListaWrapper erro) {
        if (posicao == 0) {
            adicionarInicio(valor);
            return;
        }
        if (this.tamanho() < posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return;
        }
        No novo = new No();
        novo.setValor((Integer) valor);
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

    public Object removerInicio(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return 0;
        }
        base = base.getProximo();
        return 0;
    }

    public Object removerFim(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return 0;
        }
        No aux = base;
        int tamanhoLista = this.tamanho();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            aux = aux.getProximo();
        }
        aux.setProximo(null);
        return 0;
    }

    public Object remover(int posicao, ErroListaWrapper erro) {
        if (posicao == 0) {
            removerInicio(erro);
            return 0;
        }
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return 0;
        }
        if (this.tamanho() <= posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return 0;
        }
        No aux = base;
        for (int i = 0; i < posicao - 1; i++) {
            aux = aux.getProximo();
        }
        aux.setProximo(aux.getProximo().getProximo());
        return 0;
    }

    public Object getItem(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        return getUltimo().getValor();
    }

    ;

    public Object getItem(int posicao, ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        if (this.tamanho() < posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return null;
        }
        No aux = this.base;
        for (int i = 0; i < posicao; i++) {
            aux = aux.getProximo();
        }
        return aux.getValor();
    }

    ;

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

    public boolean vazia() {
        return this.tamanho() == 0;
    }

    public Integer[] toArray() {
        if (this.vazia()) {
            return null;
        }

        Integer[] array = new Integer[this.tamanho()];
        No aux = this.base;
        int tamanhoLista = this.tamanho();

        for (int i = 0; i < tamanhoLista; i++) {
            array[i] = aux.getValor();
            aux = aux.getProximo();
        }

        return array;
    }

}

class ListaArray extends Lista {

    private int cont;
    private Integer itens[] = new Integer[10];

    public void ListaArray() {
        this.cont = 0;
    }

    public void adicionarFim(Object item) {
        int tamanho = tamanho();
        this.itens[tamanho] = (Integer) item;
        this.cont++;
    }

    public void adicionarInicio(Object item) {
        int tamanho = tamanho();
        for (int i = tamanho - 1; i >= 0; i--) {
            this.itens[i + 1] = this.itens[i];
        }
        this.itens[0] = (Integer) item;
        this.cont++;
    }

    public void adicionar(Object valor, int posicao, ErroListaWrapper erro) {
        int tamanho = tamanho();
        if (tamanho < posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return;
        }
        if (posicao == 0) {
            adicionarInicio(valor);
        } else {
            for (int i = tamanho; i >= posicao; i--) {
                this.itens[i] = this.itens[i - 1];
            }
            this.itens[posicao] = (Integer) valor;
            this.cont++;
        }              
    }

    public Object removerInicio(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return 0;
        }
        int tamanho = tamanho();
        for (int i = 0; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return 0;
    }

    public Object removerFim(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return 0;
        }
        int tamanho = tamanho();
        this.itens[tamanho - 1] = null;
        this.cont--;
        return 0;
    }

    public Object remover(int posicao, ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return 0;
        }
        int tamanho = tamanho();
        if (tamanho <= posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return 0;
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            this.itens[i] = this.itens[i + 1];
        }
        this.cont--;
        return 0;
    }

    public Object getItem(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        int tamanho = tamanho();
        return this.itens[tamanho - 1];
    }

    public Object getItem(int posicao, ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        int tamanho = tamanho();
        if (tamanho <= posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return null;
        }
        return this.itens[posicao];
    }

    public int tamanho() {
        return this.cont;
    }

    public boolean vazia() {
        return tamanho() == 0;
    }

    public Object[] toArray() {
        if (vazia()) {
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

    private Lista lista;

    public Main(Lista lista) {
        this.lista = lista;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Integer valor;
        int posicao;
        ErroListaWrapper erro = new ErroListaWrapper();

        token = in.next();

        if (token.equals("LE")) {
            main = new Main(new ListaEncadeada());
        } else {
            main = new Main(new ListaArray());
        }

        while (!token.equals("Q")) {
            erro.setErro(ErroLista.SEM_ERRO);
            switch (token) {
                case "AF":
                    valor = in.nextInt();
                    main.lista.adicionarFim(valor);
                    break;
                case "AI":
                    valor = in.nextInt();
                    main.lista.adicionarInicio(valor);
                    break;
                case "AP":
                    posicao = in.nextInt();
                    valor = in.nextInt();
                    main.lista.adicionar(valor, posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO) {
                        System.out.println(erro.getErro().getMessage());
                    }
                    break;
                case "RI":
                    main.lista.removerInicio(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO) {
                        System.out.println(erro.getErro().getMessage());
                    }
                    break;
                case "RF":
                    main.lista.removerFim(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO) {
                        System.out.println(erro.getErro().getMessage());
                    }
                    break;
                case "RP":
                    posicao = in.nextInt();
                    main.lista.remover(posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO) {
                        System.out.println(erro.getErro().getMessage());
                    }
                    break;
                case "G":
                    valor = (Integer) main.lista.getItem(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO) {
                        System.out.println(erro.getErro().getMessage());
                    } else {
                        System.out.println(valor);
                    }
                    break;
                case "GP":
                    posicao = in.nextInt();
                    valor = (Integer) main.lista.getItem(posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO) {
                        System.out.println(erro.getErro().getMessage());
                    } else {
                        System.out.println(valor);
                    }
                    break;
                case "T":
                    System.out.println(main.lista.tamanho());
                    break;
                case "V":
                    System.out.println(main.lista.vazia());
                    break;
                case "P":
                    Integer valores[] = (Integer[]) main.lista.toArray();
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
