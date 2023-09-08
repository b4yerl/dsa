package com.github.b4yerl.dsa.structure;

import com.github.b4yerl.dsa.structure.node.NextNodeReference;
import com.github.b4yerl.dsa.structure.node.SingleNode;

/**
 * <p>
 *     A Pilha na verdade é um conjunto de regras e limitações que restringem o comportamento de uma Lista Encadeada,
 *     no caso a principal característica é o seu comportamento LIFO (Last In First Out).
 * </p>
 * <br>
 * <p>
 *     Pode-se compreender uma Pilha como sendo um cesto de roupa suja. A última peça jogada lá dentro é o que podemos
 *     observar olhando nosso cesto e consequentemente esta peça será a primeira a sair.
 * </p>
 *
 * @author b4yerl
 */
public class Stack<T> {
    private SingleNode<T> top;

    public Stack() {
        this.top = null;
    }
    public Stack(SingleNode<T> top) {
        this.top = top;
    }

    /**
     * <p>
     *     Imagina um cesto de roupa suja fechado, podemos ver apenas a roupa por cima dessa pilha, certo?
     * </p>
     *
     * @return Elemento presente no topo da pilha.
     */
    public SingleNode<T> peek() {
        return this.top;
    }

    /**
     * <p>
     *     Em uma pilha podemos adicionar elementos apenas ao seu topo, para que isso seja feito basta alterar a referência
     *     para este topo com cuidado para não jogar fora o restante dos elementos.
     * </p>
     *
     * @param newElement Novo elemento a ser colocado no topo da pilha.
     */
    public void push(SingleNode<T> newElement) {
        newElement.setNextNode(peek());
        this.top = newElement;
    }

    /**
     * <p>
     *     Para seguir o LIFO, devemos remover somente o último elemento adicionado à pilha, no caso o elemento do topo.
     * </p>
     * <br>
     * <p>
     *     A remoção de um elemento ocorre quando "esquecemos" onde ele está, isso é feito mudando a referência que aponta para ele,
     *     assim tornando-o inacessível para sempre e removendo-o da pilha.
     * </p>
     *
     * @return Elemento removido do topo da pilha.
     */
    public SingleNode<T> pop() {
        SingleNode<T> popped = peek();
        this.top = (SingleNode<T>) this.top.getNextNode();
        return popped;
    }

    public int size() {
        int counter = 0;
        NextNodeReference current = this.top;
        while(current != null) {
            counter++;
            current = current.getNextNode();
        }
        return counter;
    }

    public boolean isEmpty() {
        return this.top == null;
    }
}
