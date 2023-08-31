package com.github.b4yerl.dsa.structure.node;

/**
 * Define os métodos para atribuição e acesso ao nó anterior.
 *
 * @author b4yerl
 */
public interface PreviousNodeReference {
    PreviousNodeReference getPreviousNode();
    void setPreviousNode(PreviousNodeReference previous);
}
