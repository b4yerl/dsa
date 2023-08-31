package com.github.b4yerl.dsa.structure.node;

/**
 * Define os métodos básicos para manipulação do conteúdo de um nó.
 *
 * @author b4yerl
 * @param <T> Define o tipo do conteúdo carregado.
 */
public interface Content<T> {
    T getContent();
    void setContent(T content);
}
