package com.github.b4yerl.dsa.structure.node;

/**
 * <p>Nós duplos são o elemento básico de uma Lista Duplamente Encadeada, de uma Árvore Binária, etc.</p>
 * <br>
 * <p>Além do seu conteúdo, estes nós levam consigo uma referência tanto do próximo nó, quanto do anterior.</p>
 *
 * @author b4yerl
 * @param <T> Tipo do conteúdo carregado pelo nó duplo.
 */
public class DoubleNode<T> implements Content<T>, NextNodeReference, PreviousNodeReference {
    private T content;
    private NextNodeReference nextNode;
    private PreviousNodeReference previousNode;

    @Override
    public T getContent() {
        return this.content;
    }

    @Override
    public void setContent(T content) {
        this.content = content;
    }

    @Override
    public NextNodeReference getNextNode() {
        return this.nextNode;
    }

    @Override
    public void setNextNode(NextNodeReference next) {
        this.nextNode = next;
    }

    @Override
    public PreviousNodeReference getPreviousNode() {
        return this.previousNode;
    }

    @Override
    public void setPreviousNode(PreviousNodeReference previous) {
        this.previousNode = previous;
    }

    @Override
    public String toString() {
        return this.getContent().toString();
    }
}
