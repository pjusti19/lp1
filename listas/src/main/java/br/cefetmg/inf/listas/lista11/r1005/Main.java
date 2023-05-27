package br.cefetmg.inf.listas.lista11.r1005;

import java.util.Scanner;

abstract class Pilha {

    /**
     * Adiciona <code>item</code> no final da pilha.
     */
    public abstract void empilhar(Object item);

    /**
     * Remove um <code>item</code> no topo da pilha. return <code>item</code> no
     * topo da pilha ou <code>null</code> se a pilha estiver vazia.
     */
    public abstract Object desempilhar();

    /**
     * Recupera <code>item</code> no topo da pilha, sem remover.
     *
     * @return <code>item</code> no topo da pilha ou <code>null</code> se a
     * pilha estiver vazia.
     */
    public abstract Object getItem();

    /**
     * Recupera número de itens na pilha.
     *
     * @return Número de itens mantidos na pilha.
     */
    public abstract int tamanho();

    /**
     * Retorna <code>true</code> se a pilha não possuir qualquer
     * <code>item</code>.
     *
     * @return <code>true</code> se a pilha não possuir qualquer
     * <code>item</code>, ou <code>false</code> se possuir.
     */
    public abstract boolean vazia();

    /**
     * Retorna um array contendo todos os itens da pilha.
     *
     * @return um array com todos os elementos da pilha <code>null</code> se a
     * pilha estiver vazia.
     */
    public abstract Object[] toArray();
}

class PilhaEncadeada extends Pilha {
   
    class  No {

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

    public void empilhar(Object item) {

        No novo = new No();
        novo.setValor((Integer)item);
        novo.setProximo(null);

        if (this.vazia()) {
            base = novo;
        } else {
            No topo = getUltimo();
            topo.setProximo(novo);
        }

    }

    private No getUltimo() {
        No aux = base;
        while (aux.getProximo() != null) {
            aux = aux.getProximo();
        }
        return aux;
    }

    public Object desempilhar() {
        if (this.vazia()) {
            return null;
        }

        Integer valor;

        if (base.getProximo() == null) {
            valor = base.getValor();
            base = null;

        } else {
            No penultimo = encontrarPenultimo();
            valor = penultimo.getProximo().getValor();
            penultimo.setProximo(null);
        }

        return valor;

    }

    private No encontrarPenultimo() {
        No auxiliar = base;
        while (auxiliar.getProximo().getProximo() != null) {
            auxiliar = auxiliar.getProximo();
        }
        return auxiliar;
    }

    public Integer getItem() {
        if (this.vazia()) {
            return null;
        }
        return getUltimo().getValor();
    }

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
            array[tamanhoLista - i - 1] = aux.getValor();
            aux = aux.getProximo();
        }

        return array;
    }
}


class PilhaArray extends Pilha {
    
    private int cont;
    private Integer itens[] = new Integer[10];
    
    public void PilhaArray(){
       this.cont = 0;
    }
    
    public void empilhar(Object item){
        PilhaArray pilha_array = new PilhaArray();
        this.itens[this.cont] = (Integer)item;
        this.cont++; 
    }

    public Object desempilhar(){
        if(vazia())
            return null;
        int aux = this.itens[this.cont-1];
        this.itens[this.cont-1]= null;
        this.cont--;
        return aux;
    }

    public Object getItem(){
        if(vazia())
            return null;
        return this.itens[this.cont-1];
    }

    public int tamanho(){
        return this.cont;
    }

    public boolean vazia(){
        return tamanho() == 0;
    }

    public Object[] toArray(){
        if(vazia())
            return null;
        Integer aux[] = new Integer[this.cont];
        int tamanho = this.cont;
        for(int i = 0; i < tamanho ; i++)
            aux[tamanho - i - 1] = this.itens[i];
        return aux;
    }
}


  

class Main {

    private Pilha pilha;

    public Main(Pilha pilha) {
        this.pilha = pilha;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Main main;
        String token;
        Integer valor;

        token = in.next();

        if (token.equals("pe")) {
            main = new Main(new PilhaEncadeada());
        } else {
            main = new Main(new PilhaArray());
        }

        while (!token.equals("Q")) {
            switch (token) {
                case "E":
                    valor = in.nextInt();
                    main.pilha.empilhar(valor);
                    break;
                case "D":
                    valor = (Integer) main.pilha.desempilhar();
                    if (valor == null) {
                        System.out.println("NenhumItemException");
                    }
                    break;
                case "G":
                    valor = (Integer) main.pilha.getItem();
                    if (valor != null) {
                        System.out.println(valor);
                    } else {
                        System.out.println("NenhumItemException");
                    }
                    break;
                case "T":
                    System.out.println(main.pilha.tamanho());
                    break;
                case "V":
                    System.out.println(main.pilha.vazia());
                    break;
                case "P":
                    Integer valores[] = (Integer[]) main.pilha.toArray();
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
