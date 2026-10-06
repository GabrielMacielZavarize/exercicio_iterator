package br.venson.net.designpatterns.iterator;

public class Faixa {

    private final String titulo;
    private final String artista;
    private final int duracaoSegundos;
    private final boolean favorita;

    public Faixa(String titulo, String artista, int duracaoSegundos, boolean favorita) {
        this.titulo = titulo;
        this.artista = artista;
        this.duracaoSegundos = duracaoSegundos;
        this.favorita = favorita;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getArtista() {
        return artista;
    }

    public int getDuracaoSegundos() {
        return duracaoSegundos;
    }

    public boolean isFavorita() {
        return favorita;
    }

    @Override
    public String toString() {
        return titulo + " - " + artista + (favorita ? " ♥" : "");
    }
}
