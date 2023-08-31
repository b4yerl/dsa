package com.github.b4yerl.dsa.structure.node;

/**
 * Define os métodos para atribuição e acesso ao nó seguinte.
 *
 * @author b4yerl
 */
public interface NextNodeReference {
    NextNodeReference getNextNode();
    void setNextNode(NextNodeReference next);
}
