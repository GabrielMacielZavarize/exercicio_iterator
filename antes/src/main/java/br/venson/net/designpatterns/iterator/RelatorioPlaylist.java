package br.venson.net.designpatterns.iterator;

import java.util.List;

public class RelatorioPlaylist {

    // ANTI-PATTERN: terceira cópia do laço por índice.
    public String gerar(Playlist playlist) {
        List<Faixa> faixas = playlist.getFaixas();
        StringBuilder sb = new StringBuilder("Relatório da playlist " + playlist.getNome() + System.lineSeparator());
        int total = 0;
        for (int i = 0; i < faixas.size(); i++) {
            Faixa faixa = faixas.get(i);
            sb.append(String.format("  %d. %s (%d:%02d)%n", i + 1, faixa,
                    faixa.getDuracaoSegundos() / 60, faixa.getDuracaoSegundos() % 60));
            total += faixa.getDuracaoSegundos();
        }
        sb.append(String.format("  Duração total: %d:%02d%n", total / 60, total % 60));
        return sb.toString();
    }
}
