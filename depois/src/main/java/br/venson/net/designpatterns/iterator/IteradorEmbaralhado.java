package br.venson.net.designpatterns.iterator;

import java.util.NoSuchElementException;
import java.util.Random;

/**
 * Embaralha apenas uma permutação de ÍNDICES própria deste iterador
 * (Fisher-Yates): a coleção original nunca é alterada.
 */
class IteradorEmbaralhado<T> implements Iterador<T> {

    private final T[] itens;
    private final int[] ordem;
    private int posicao = 0;

    IteradorEmbaralhado(T[] itens, int tamanho, Random random) {
        this.itens = itens;
        this.ordem = new int[tamanho];
        for (int i = 0; i < tamanho; i++) {
            ordem[i] = i;
        }
        for (int i = tamanho - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int tmp = ordem[i];
            ordem[i] = ordem[j];
            ordem[j] = tmp;
        }
    }

    @Override
    public boolean temProxima() {
        return posicao < ordem.length;
    }

    @Override
    public T proxima() {
        if (!temProxima()) {
            throw new NoSuchElementException();
        }
        return itens[ordem[posicao++]];
    }
}
