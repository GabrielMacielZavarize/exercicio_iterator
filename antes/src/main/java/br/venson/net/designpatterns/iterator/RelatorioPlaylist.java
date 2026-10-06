package br.venson.net.designpatterns.iterator;

import java.util.List;

public class RelatorioPlaylist {

    public void resumo(Playlist playlist) {
        List<Faixa> faixas = playlist.getFaixas();
        int totalSegundos = 0;
        for (int i = 0; i < faixas.size(); i++) {
            totalSegundos += faixas.get(i).getDuracaoSegundos();
        }
        System.out.printf("Total de faixas: %d | duracao: %d min%n",
                faixas.size(), totalSegundos / 60);
    }
}
