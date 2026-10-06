package br.venson.net.designpatterns.iterator;

public class Main {

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

        System.out.println("Ordem original: " + playlist.getFaixas());
        player.tocarEmbaralhado(playlist);
        // Observe: o embaralhamento alterou a ordem da propria playlist.
        System.out.println("Ordem depois do shuffle: " + playlist.getFaixas());
    }
}
