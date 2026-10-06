package br.venson.net.designpatterns.iterator;

import java.util.List;
import java.util.Collections;

public class Player {

    public void tocarTudo(Playlist playlist) {
        List<Faixa> faixas = playlist.getFaixas();
        for (int i = 0; i < faixas.size(); i++) {
            System.out.println("Tocando: " + faixas.get(i));
        }
    }

    public void tocarEmbaralhado(Playlist playlist) {
        // Opera direto sobre a lista interna da playlist.
        List<Faixa> faixas = playlist.getFaixas();
        Collections.shuffle(faixas);
        for (int i = 0; i < faixas.size(); i++) {
            System.out.println("Tocando (shuffle): " + faixas.get(i));
        }
    }
}
