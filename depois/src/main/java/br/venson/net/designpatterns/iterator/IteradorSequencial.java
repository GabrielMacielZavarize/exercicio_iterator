package br.venson.net.designpatterns.iterator;

import java.util.NoSuchElementException;

/** Iterador concreto: guarda a posição atual da travessia em ordem. */
class IteradorSequencial<T> implements Iterador<T> {

    private final T[] itens;
    private final int tamanho;
    private int posicao = 0;

    IteradorSequencial(T[] itens, int tamanho) {
        this.itens = itens;
        this.tamanho = tamanho;
    }

    @Override
    public boolean temProxima() {
        return posicao < tamanho;
    }

    @Override
    public T proxima() {
        if (!temProxima()) {
            throw new NoSuchElementException();
        }
        return itens[posicao++];
    }
}
