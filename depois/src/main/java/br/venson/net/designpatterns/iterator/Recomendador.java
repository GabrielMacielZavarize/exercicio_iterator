package br.venson.net.designpatterns.iterator;

public class Recomendador {

    public void sugerirFavoritas(Playlist playlist) {
        System.out.println("Favoritas:");
        Iterador<Faixa> favoritas = playlist.criarIteradorFavoritas();
        while (favoritas.temProxima()) {
            System.out.println("  * " + favoritas.proxima());
        }
    }
}
