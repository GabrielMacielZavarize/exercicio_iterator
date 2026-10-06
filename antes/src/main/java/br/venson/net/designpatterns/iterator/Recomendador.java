package br.venson.net.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Recomendador {

    // ANTI-PATTERN: mesma travessia por índice, acoplada a List.
    public List<Faixa> sugerirFavoritas(Playlist playlist) {
        List<Faixa> faixas = playlist.getFaixas();
        List<Faixa> sugestoes = new ArrayList<>();
        for (int i = 0; i < faixas.size(); i++) {
            if (faixas.get(i).isFavorita()) {
                sugestoes.add(faixas.get(i));
            }
        }
        return sugestoes;
    }
}
