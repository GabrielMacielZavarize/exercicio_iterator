package br.venson.net.designpatterns.iterator;

/** Coleção capaz de criar um iterador sobre si mesma. */
public interface Agregado<T> {

    Iterador<T> criarIterador();
}
