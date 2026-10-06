package br.venson.net.designpatterns.iterator;

import java.util.Random;

public class Main {

    private static final long SEMENTE = 2;

    public static void main(String[] args) {
        Playlist playlist = new Playlist();
        playlist.adicionar(new Faixa("Faixa A", "Artista X", 210, true));
        playlist.adicionar(new Faixa("Faixa B", "Artista Y", 180, false));
        playlist.adicionar(new Faixa("Faixa C", "Artista Z", 240, true));

        Player player = new Player();
        Recomendador recomendador = new Recomendador();
        RelatorioPlaylist relatorio = new RelatorioPlaylist();

        relatorio.resumo(playlist);
        recomendador.sugerirFavoritas(playlist);

        System.out.println("Ordem original: " + playlist);
        // Semente fixa só para a demonstração ser reproduzível.
        player.tocarEmbaralhado(playlist, new Random(SEMENTE));
        // Agora o embaralhamento acontece só no iterador: a playlist não muda.
        System.out.println("Ordem depois do shuffle: " + playlist);

        System.out.println();
        player.tocarTudo(playlist);

        System.out.println();
        // Travessias combinadas sem nenhum laço novo: só favoritas, em ordem embaralhada.
        player.tocar(new IteradorFiltrado<>(playlist.criarIteradorEmbaralhado(new Random(SEMENTE)), Faixa::isFavorita),
                "Tocando (favoritas shuffle): ");
    }
}
