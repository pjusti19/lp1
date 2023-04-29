package br.cefetmg.inf.listas.lista08.r1002;

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

class Lista {

    private No base;

    private No getUltimo() {
        No aux = base;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        return aux;
    }

    void adicionarFim(Integer valor) {
        No novo = new No();
        novo.setValor(valor);
        novo.setProximo(null);
        if (this.vazia())
            base = novo;
        else {
            No topo = getUltimo();
            topo.setProximo(novo);
        }
    };

    void adicionarInicio(Integer valor) {
        No novo = new No();
        novo.setValor(valor);
        if (this.vazia()) {
            novo.setProximo(null);
            base = novo;
        } else {
            novo.setProximo(base);
            base = novo;
        }
    };

    void adicionar(Integer valor, Integer posicao, ErroListaWrapper erro) {
        if(posicao == 0){
            adicionarInicio(valor);
            return;
        }
        if (this.tamanho() < posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return;
        }
        No novo = new No();
        novo.setValor(valor);
        if (this.vazia()) {
            novo.setProximo(null);
            base = novo;
        }
        else{
            No aux = base;
            for(int i=0; i<posicao-1;i++){
                aux = aux.getProximo();
            }
            novo.setProximo(aux.getProximo());
            aux.setProximo(novo);
        }
    };

    void removerInicio(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return;
        }
        base = base.getProximo();
    };

    void removerFim(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return;
        }
        No aux = base;
        int tamanhoLista = this.tamanho();
        for (int i = 0; i < tamanhoLista - 1; i++) {
            aux = aux.getProximo();
        }
        aux.setProximo(null);
    };

    void remover(Integer posicao, ErroListaWrapper erro) {
        if(posicao == 0){
            removerInicio(erro);
            return;
        }
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return;
        }
        if (this.tamanho() <= posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return;
        }
        No aux = base;
        for(int i = 0; i < posicao-1; i++){
            aux = aux.getProximo();
        }
            aux.setProximo(aux.getProximo().getProximo());
    };

    Integer getItem(ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        return getUltimo().getValor();
    };

    Integer getItemPos(Integer posicao, ErroListaWrapper erro) {
        if (this.vazia()) {
            erro.setErro(ErroLista.VAZIA);
            return null;
        }
        if (this.tamanho() < posicao) {
            erro.setErro(ErroLista.INDICE_INVALIDO);
            return null;
        }
        No aux = this.base;
        for (int i = 0; i < posicao; i++)
            aux = aux.getProximo();
        return aux.getValor();
    };

    Integer tamanho() {
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
    };

    boolean vazia() {
        return this.tamanho() == 0;
    };

    Integer[] toArray() {
        if (this.vazia())
            return null;

        Integer[] array = new Integer[this.tamanho()];
        No aux = this.base;
        int tamanhoLista = this.tamanho();

        for (int i = 0; i < tamanhoLista; i++) {
            array[i] = aux.getValor();
            aux = aux.getProximo();
        }

        return array;
    };
}

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Lista lista = new Lista();
        String token;
        Integer valor;
        int posicao;
        ErroListaWrapper erro = new ErroListaWrapper();

        token = in.next();
        while (!token.equals("Q")) {
            erro.setErro(ErroLista.SEM_ERRO);
            switch (token) {
                case "AF":
                    valor = in.nextInt();
                    lista.adicionarFim(valor);
                    break;
                case "AI":
                    valor = in.nextInt();
                    lista.adicionarInicio(valor);
                    break;
                case "AP":
                    posicao = in.nextInt();
                    valor = in.nextInt();
                    lista.adicionar(valor, posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "RI":
                    lista.removerInicio(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "RF":
                    lista.removerFim(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "RP":
                    posicao = in.nextInt();
                    lista.remover(posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    break;
                case "G":
                    valor = lista.getItem(erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    else
                        System.out.println(valor);
                    break;
                case "GP":
                    posicao = in.nextInt();
                    valor = lista.getItemPos(posicao, erro);
                    if (erro.getErro() != ErroLista.SEM_ERRO)
                        System.out.println(erro.getErro().getMessage());
                    else
                        System.out.println(valor);
                    break;
                case "T":
                    System.out.println(lista.tamanho());
                    break;
                case "V":
                    System.out.println(lista.vazia());
                    break;
                case "P":
                    Integer valores[] = lista.toArray();
                    if (valores != null) {
                        for (Integer item : valores)
                            System.out.println(item);
                    }
                    break;
            }
            token = in.next();
        }
        in.close();
    }
}
