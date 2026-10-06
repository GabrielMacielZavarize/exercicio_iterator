package br.venson.net.designpatterns.iterator;

import java.util.NoSuchElementException;
import java.util.function.Predicate;

/**
 * Decora qualquer outro iterador, entregando só os elementos que passam no filtro.
 * Permite combinar travessias (ex.: favoritas em ordem embaralhada) sem novos laços.
 */
public class IteradorFiltrado<T> implements Iterador<T> {

    private final Iterador<T> origem;
    private final Predicate<? super T> filtro;
    private T proximo;
    private boolean temProximo;

    public IteradorFiltrado(Iterador<T> origem, Predicate<? super T> filtro) {
        this.origem = origem;
        this.filtro = filtro;
        avancar();
    }

    private void avancar() {
        temProximo = false;
        while (origem.temProxima()) {
            T candidato = origem.proxima();
            if (filtro.test(candidato)) {
                proximo = candidato;
                temProximo = true;
                return;
            }
        }
    }

    @Override
    public boolean temProxima() {
        return temProximo;
    }

    @Override
    public T proxima() {
        if (!temProximo) {
            throw new NoSuchElementException();
        }
        T atual = proximo;
        avancar();
        return atual;
    }
}
