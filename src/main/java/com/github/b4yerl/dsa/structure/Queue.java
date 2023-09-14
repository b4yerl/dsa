package com.github.b4yerl.dsa.structure;

import com.github.b4yerl.dsa.structure.node.NextNodeReference;
import com.github.b4yerl.dsa.structure.node.SinglyNode;

/**
 * <p>
 *     Filas são a implementação das restrições de FIFO em uma lista, ou seja, nas filas podemos apenas inserir novos elementos
 *     no fim, enquanto pode-se apenas remover o primeiro elemento.
 * </p>
 *
 * @author b4yerl
 */
public class Queue<T> {
    private SinglyNode<T> first;

    public Queue() {
        this.first = null;
    }
    public Queue(SinglyNode<T> first) {
        this.first = first;
    }

    /**
     * <p>
     *     Elementos podem ser adicionados apenas ao final da fila, ou seja, basta iterar pelos elementos existentes até
     *     encontrar uma referência que seja null.
     * </p>
     * @param newElement Elemento adicionado ao fim da fila
     */
    public void enqueue(SinglyNode<T> newElement) {
        if(this.first == null) { this.first = newElement; return; }
        NextNodeReference currentLastNode = this.first;
        while(currentLastNode.getNextNode() != null) {
            currentLastNode = currentLastNode.getNextNode();
        }
        currentLastNode.setNextNode(newElement);
    }

    /**
     * <p>
     *     Seguindo o FIFO, o primeiro da fila deve ser o primeiro a sair, assim, basta atualizar nosso head para o next
     *     do head atual.
     * </p>
     * @return
     */
    public SinglyNode<T> dequeue() {
        SinglyNode<T> removed = this.first;
        this.first = (SinglyNode<T>) removed.getNextNode();
        return removed;
    }

    public SinglyNode<T> peek() {
        return this.first;
    }

    public int size() {
        int counter = 0;
        NextNodeReference current = this.first;
        while(current != null) {
            counter++;
            current = current.getNextNode();
        }
        return counter;
    }

    public boolean isEmpty() {
        return this.first == null;
    }
}
