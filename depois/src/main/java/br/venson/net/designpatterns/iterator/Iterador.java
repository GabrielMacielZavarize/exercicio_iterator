package br.venson.net.designpatterns.iterator;

/** Interface de iterador: o cliente percorre sem conhecer a estrutura interna. */
public interface Iterador<T> {

    boolean temProxima();

    /** @throws java.util.NoSuchElementException se não houver próximo elemento */
    T proxima();
}
