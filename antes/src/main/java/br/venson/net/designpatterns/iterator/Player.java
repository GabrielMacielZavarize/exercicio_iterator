package br.venson.net.designpatterns.iterator;

import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Player {

    public void tocarTudo(Playlist playlist) {
        List<Faixa> faixas = playlist.getFaixas();
        for (int i = 0; i < faixas.size(); i++) {
            System.out.println("  > Tocando: " + faixas.get(i));
        }
    }

    // ANTI-PATTERN: embaralha a lista interna da playlist (efeito colateral).
    public void tocarEmbaralhado(Playlist playlist, Random random) {
        List<Faixa> faixas = playlist.getFaixas();
        Collections.shuffle(faixas, random);
        for (int i = 0; i < faixas.size(); i++) {
            System.out.println("  > Tocando: " + faixas.get(i));
        }
    }
}
