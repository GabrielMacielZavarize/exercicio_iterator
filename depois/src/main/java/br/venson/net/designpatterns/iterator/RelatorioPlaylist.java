package br.venson.net.designpatterns.iterator;

public class RelatorioPlaylist {

    public void resumo(Playlist playlist) {
        int quantidade = 0;
        int totalSegundos = 0;
        Iterador<Faixa> it = playlist.criarIterador();
        while (it.temProxima()) {
            totalSegundos += it.proxima().getDuracaoSegundos();
            quantidade++;
        }
        System.out.printf("Total de faixas: %d | duracao: %d min%n", quantidade, totalSegundos / 60);
    }
}
