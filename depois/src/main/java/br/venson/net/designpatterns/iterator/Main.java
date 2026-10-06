package br.venson.net.designpatterns.iterator;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Playlist playlist = new Playlist("Rock Nacional");
        playlist.adicionar(new Faixa("Tempo Perdido", "Legião Urbana", 302, true));
        playlist.adicionar(new Faixa("Primeiros Erros", "Capital Inicial", 254, false));
        playlist.adicionar(new Faixa("Lanterna dos Afogados", "Paralamas", 216, true));
        playlist.adicionar(new Faixa("Pro Dia Nascer Feliz", "Barão Vermelho", 223, false));
        playlist.adicionar(new Faixa("Exagerado", "Cazuza", 191, true));

        Player player = new Player();

        System.out.println("Ordem original: " + playlist);

        System.out.println("\nTocar tudo:");
        player.tocar(playlist.criarIterador());

        System.out.println("\nTocar embaralhado:");
        player.tocar(playlist.criarIteradorEmbaralhado(new Random(42)));

        System.out.println("\nOrdem depois do embaralhado: " + playlist);
        System.out.println("(a ordem original foi preservada)");

        System.out.println("\nSó favoritas, embaralhadas (iteradores combinados):");
        player.tocar(new IteradorFiltrado<>(playlist.criarIteradorEmbaralhado(new Random(7)), Faixa::isFavorita));

        System.out.println("\nFavoritas sugeridas: " + new Recomendador().sugerirFavoritas(playlist));

        System.out.println();
        System.out.print(new RelatorioPlaylist().gerar(playlist));
    }
}
