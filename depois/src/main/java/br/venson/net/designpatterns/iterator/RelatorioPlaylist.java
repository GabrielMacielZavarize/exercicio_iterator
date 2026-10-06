package br.venson.net.designpatterns.iterator;

public class RelatorioPlaylist {

    public String gerar(Playlist playlist) {
        StringBuilder sb = new StringBuilder("Relatório da playlist " + playlist.getNome() + System.lineSeparator());
        int numero = 1;
        int total = 0;
        Iterador<Faixa> it = playlist.criarIterador();
        while (it.temProxima()) {
            Faixa faixa = it.proxima();
            sb.append(String.format("  %d. %s (%d:%02d)%n", numero++, faixa,
                    faixa.getDuracaoSegundos() / 60, faixa.getDuracaoSegundos() % 60));
            total += faixa.getDuracaoSegundos();
        }
        sb.append(String.format("  Duração total: %d:%02d%n", total / 60, total % 60));
        return sb.toString();
    }
}
