package com.github.b4yerl.dsa.structure;

import com.github.b4yerl.dsa.structure.node.NextNodeReference;
import com.github.b4yerl.dsa.structure.node.SinglyNode;

/**
 * <p>
 *     Composta por uma sequência de nós simples, a Lista Encadeada possui uma flexibilidade de tamanho inexistente nos Arrays.
 * </p>
 * <br>
 * <p>
 *     Em contrapartida perde-se desempenho em operações básicas, já que agora é necessário percorrer os nós da lista.
 * </p>
 *
 * @author b4yerl
 */
public class LinkedList<T> {
    private SinglyNode<T> entryPoint;

    public LinkedList() {
        entryPoint = null;
    }

    public LinkedList(SinglyNode<T> entryPoint) {
        this.entryPoint = entryPoint;
    }

    public void printFullList() {
        if(isEmpty()) {
            System.out.println("[]");
        }
        else {
            NextNodeReference currentNode = entryPoint;
            while(currentNode != null) {
                System.out.println(currentNode);
                currentNode = currentNode.getNextNode();
            }
        }
    }

    public void addNewEntryPoint(SinglyNode<T> newElement) {
        if(entryPoint == null) entryPoint.setNextNode(newElement);
        else {
            newElement.setNextNode(entryPoint);
            entryPoint = newElement;
        }
    }
    public void addToLastPosition(SinglyNode<T> newElement) {
        if(size() == 0) {
            addNewEntryPoint(newElement);
            return;
        }
        NextNodeReference lastNode = get(size() - 1);
        lastNode.setNextNode(newElement);
    }

    /**
     * <p>
     *     A inclusão de elementos na lista encadeada é feita com a alteração das referências de seus nós atuais e do novo nó.
     * </p>
     * <br>
     * <p>
     *     Suponha que iremos adicionar um elemento na posição "i", para isso ser feito de forma segura e sem perder os elementos já existentes,
     *     primeiro garantimos que o novo elemento aponta para o nó que atualmente ocupa a posição "i",
     *     apenas a partir daí iremos atualizar o nó "i - 1" para o nosso novo elemento.
     * </p>
     *
     * @param newElement Novo elemento que será adicionado à lista.
     * @param index Index em que desejamos adicionar o novo elemento.
     */
    public void add(SinglyNode<T> newElement, int index) {
        if(index == 0) {
            addNewEntryPoint(newElement);
            return;
        }
        NextNodeReference previousIndexNode = get(index - 1);
        newElement.setNextNode(previousIndexNode.getNextNode());
        previousIndexNode.setNextNode(newElement);
    }

    public void removeEntryPoint() {
        if(size() > 0) entryPoint = (SinglyNode<T>) entryPoint.getNextNode();
    }
    public void removeLastPosition() {
        if(size() != 0) get(size() - 2).setNextNode(null);
    }

    /**
     * <p>
     *     A remoção de um elemento em listas encadeadas é feita quando descartamos a referência para este nó.
     * </p>
     * <br>
     * <p>
     *     Para remover um elemento presente na posição "i", basta atualizar o nó anterior, ou seja o "i - 1",
     *     fazendo com que este aponte para o nó de índice "i + 1", dessa forma "pulando" o elemento que deseja-se remover.
     * </p>
     *
     * @param index Posição do elemento a ser removido.
     */
    public void remove(int index) {
        if(index == 0) removeEntryPoint();
        NextNodeReference node = get(index - 1);
        node.setNextNode(node.getNextNode().getNextNode());
    }

    /**
     * <p>
     *     Para recuperar um elemento presente em uma posição "i" da lista é necessário percorrer cada elemento anterior a ele,
     *     partindo do index 0, armazenado como referência de entrada da lista encadeada.
     * </p>
     *
     * @param index Índice do nó a ser recuperado.
     * @return O nó presente na posição indicada.
     */
    public NextNodeReference get(int index) {
        if(index >= size() || index < 0) throw new IndexOutOfBoundsException("A lista encadeada vai até o index " + (size() - 1));

        NextNodeReference currentNode = entryPoint;
        for(int i = 0; i < index; i++) {
            currentNode = currentNode.getNextNode();
        }
        return currentNode;
    }

    public int size() {
        if(isEmpty()) return 0;

        int listLength = 0;
        NextNodeReference currentNode = entryPoint;
        while(currentNode != null) {
            listLength++;
            currentNode = currentNode.getNextNode();
        }

        return listLength;
    }

    public boolean isEmpty() {
        return entryPoint == null;
    }
}
