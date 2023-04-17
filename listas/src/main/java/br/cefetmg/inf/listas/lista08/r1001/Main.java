package br.cefetmg.inf.listas.lista08.r1001;

import java.util.Scanner;

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


class Pilha {
    
    private No base;

    /**
     * Adiciona <code>item</code> no final da pilha.
     */
    void empilhar(Integer item) {

        No novo = new No();
		novo.setValor(item);
		novo.setProximo(null);
		
		if (this.vazia())
			base = novo;
		else { 
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

    /**
     * Remove um <code>item</code> no topo da pilha.
     * return <code>item</code> no topo da pilha ou <code>null</code> se a pilha estiver vazia.
    */
    Integer desempilhar() {
        if(this.vazia())
        return null;

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

    /**
     * Recupera <code>item</code> no topo da pilha, sem remover.
     * @return <code>item</code> no topo da pilha ou <code>null</code> se a pilha estiver vazia.
     */
    Integer getItem() {
        if(this.vazia())
        return null;
        return getUltimo().getValor();
    }
    
    /**
     * Recupera número de itens na pilha.
     * @return Número de itens mantidos na pilha.
     */
    int tamanho() {
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
    
    /**
     * Retorna <code>true</code> se a pilha não possuir qualquer <code>item</code>.
     * @return <code>true</code> se a pilha não possuir qualquer <code>item</code>, 
     * ou <code>false</code> se possuir.
     */
    boolean vazia() {
        return this.tamanho() == 0;
    }
    
    /**
     * Retorna um array contendo todos os itens da pilha.
     * @return um array com todos os elementos da pilha <code>null</code> se a pilha estiver vazia.
     */
    Integer[] toArray() {
        if(this.vazia())
        return null;
        
        Integer[] array = new Integer[this.tamanho()];
        No aux = this.base;
        int tamanhoLista = this.tamanho();

		for(int i = 0; i < tamanhoLista; i++) {
            array[tamanhoLista - i - 1] = aux.getValor();
			aux = aux.getProximo();
		}
        
        return array;
    }
}

class Main {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        Pilha pilha = new Pilha();
        String token;
        Integer valor;
        
        token = in.next();
        while (!token.equals("Q")) {
            switch(token) {
                case "E":
                    valor = in.nextInt();
                    pilha.empilhar(valor);
                    break;
                case "D":
                    valor = pilha.desempilhar();
                    if (valor == null)
                        System.out.println("NenhumItemException");
                    break;
                case "G":
                    valor = pilha.getItem();
                    if (valor != null)
                        System.out.println(valor);
                    else
                        System.out.println("NenhumItemException");
                    break;
                case "T":
                    System.out.println(pilha.tamanho());
                    break;
                case "V":
                    System.out.println(pilha.vazia());
                    break;
                case "P":
                    Integer valores[] = pilha.toArray();
                    if (valores != null) {
                        for(Integer item: valores)
                            System.out.println(item);
                    }
                    break;
            }
            token = in.next();
        }
        in.close();
    }
}
