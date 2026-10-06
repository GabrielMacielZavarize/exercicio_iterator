package br.venson.net.designpatterns.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class PlaylistIteradorTest {

    private Playlist playlist;
    private final List<Faixa> esperado = new ArrayList<>();

    @BeforeEach
    void setUp() {
        playlist = new Playlist("Teste");
        for (int i = 1; i <= 6; i++) { // passa da capacidade inicial do array (4)
            Faixa faixa = new Faixa("Faixa " + i, "Artista", 100 + i, i % 2 == 0);
            playlist.adicionar(faixa);
            esperado.add(faixa);
        }
    }

    private static List<Faixa> coletar(Iterador<Faixa> it) {
        List<Faixa> lista = new ArrayList<>();
        while (it.temProxima()) {
            lista.add(it.proxima());
        }
        return lista;
    }

    @Test
    void sequencialPercorreNaOrdemDeInsercao() {
        assertEquals(esperado, coletar(playlist.criarIterador()));
    }

    @Test
    void embaralhadoVisitaTodasSemAlterarAPlaylist() {
        List<Faixa> embaralhadas = coletar(playlist.criarIteradorEmbaralhado(new Random(42)));
        assertEquals(new HashSet<>(esperado), new HashSet<>(embaralhadas));
        assertEquals(esperado.size(), embaralhadas.size());
        assertNotEquals(esperado, embaralhadas);
        assertEquals(esperado, coletar(playlist.criarIterador()), "ordem original preservada");
    }

    @Test
    void favoritasEntregaApenasFavoritas() {
        List<Faixa> favoritas = coletar(playlist.criarIteradorFavoritas());
        assertEquals(3, favoritas.size());
        assertTrue(favoritas.stream().allMatch(Faixa::isFavorita));
    }

    @Test
    void iteradoresSaoIndependentes() {
        Iterador<Faixa> a = playlist.criarIterador();
        Iterador<Faixa> b = playlist.criarIterador();
        a.proxima();
        a.proxima();
        assertEquals(esperado.get(0), b.proxima());
        assertEquals(esperado.get(2), a.proxima());
    }

    @Test
    void proximaSemElementosLancaExcecao() {
        Iterador<Faixa> vazio = new Playlist("Vazia").criarIterador();
        assertFalse(vazio.temProxima());
        assertThrows(NoSuchElementException.class, vazio::proxima);
        assertThrows(NoSuchElementException.class,
                new IteradorFiltrado<>(playlist.criarIterador(), f -> false)::proxima);
    }
}
