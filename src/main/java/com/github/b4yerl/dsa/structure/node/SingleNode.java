package com.github.b4yerl.dsa.structure.node;

/**
 * <p>Os nós simples são os elementos que compõe estruturas como:
 * Listas Encadeadas, Filas e Pilhas.</p>
 * <br>
 * <p>No esquema do nó vemos que ele basicamente carrega o seu conteúdo
 * e uma referência ao próximo nó da estrutura.</p>
 *
 * @author b4yerl
 * @param <T> Tipo do conteúdo carrregado pelo nó.
 */
public class SingleNode<T> implements Content<T>, NextNodeReference {
    private T content;
    private NextNodeReference nextNode = null;


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
    public String toString() {
        return this.getContent().toString();
    }
}
