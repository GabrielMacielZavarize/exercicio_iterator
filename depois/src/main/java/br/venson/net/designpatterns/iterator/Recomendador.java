package br.venson.net.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Recomendador {

    public List<Faixa> sugerirFavoritas(Playlist playlist) {
        List<Faixa> sugestoes = new ArrayList<>();
        Iterador<Faixa> favoritas = playlist.criarIteradorFavoritas();
        while (favoritas.temProxima()) {
            sugestoes.add(favoritas.proxima());
        }
        return sugestoes;
    }
}
