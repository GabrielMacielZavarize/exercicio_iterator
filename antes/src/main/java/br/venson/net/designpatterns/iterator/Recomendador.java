package br.venson.net.designpatterns.iterator;

import java.util.List;

public class Recomendador {

    public void sugerirFavoritas(Playlist playlist) {
        List<Faixa> faixas = playlist.getFaixas();
        System.out.println("Favoritas:");
        for (int i = 0; i < faixas.size(); i++) {
            Faixa faixa = faixas.get(i);
            if (faixa.isFavorita()) {
                System.out.println("  * " + faixa);
            }
        }
    }
}
