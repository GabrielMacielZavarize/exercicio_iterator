package br.venson.net.designpatterns.iterator;

import java.util.Arrays;
import java.util.Random;

/**
 * Agregado concreto. A estrutura interna (aqui, um array que cresce sob demanda,
 * no lugar da List original) é totalmente privada: os clientes só recebem iteradores.
 */
public class Playlist implements Agregado<Faixa> {

    private Faixa[] faixas = new Faixa[4];
    private int tamanho = 0;

    public void adicionar(Faixa faixa) {
        if (tamanho == faixas.length) {
            faixas = Arrays.copyOf(faixas, faixas.length * 2);
        }
        faixas[tamanho++] = faixa;
    }

    /** Travessia padrão: ordem de inserção. */
    @Override
    public Iterador<Faixa> criarIterador() {
        return new IteradorSequencial<>(faixas, tamanho);
    }

    /** Ordem aleatória, sem alterar a ordem da playlist. */
    public Iterador<Faixa> criarIteradorEmbaralhado() {
        return criarIteradorEmbaralhado(new Random());
    }

    /** Versão com Random injetável (permite ordem determinística em testes). */
    public Iterador<Faixa> criarIteradorEmbaralhado(Random random) {
        return new IteradorEmbaralhado<>(faixas, tamanho, random);
    }

    /** Só as favoritas, na ordem da playlist. */
    public Iterador<Faixa> criarIteradorFavoritas() {
        return new IteradorFiltrado<>(criarIterador(), Faixa::isFavorita);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterador<Faixa> it = criarIterador();
        while (it.temProxima()) {
            sb.append(it.proxima());
            if (it.temProxima()) {
                sb.append(", ");
            }
        }
        return sb.append(']').toString();
    }
}
