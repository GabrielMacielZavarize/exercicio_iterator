package br.venson.net.designpatterns.iterator;

import java.util.Random;

/** Um único laço serve para qualquer ordem: quem decide é o iterador recebido. */
public class Player {

    public void tocarTudo(Playlist playlist) {
        tocar(playlist.criarIterador(), "Tocando: ");
    }

    public void tocarEmbaralhado(Playlist playlist) {
        tocarEmbaralhado(playlist, new Random());
    }

    public void tocarEmbaralhado(Playlist playlist, Random random) {
        tocar(playlist.criarIteradorEmbaralhado(random), "Tocando (shuffle): ");
    }

    public void tocar(Iterador<Faixa> faixas, String rotulo) {
        while (faixas.temProxima()) {
            System.out.println(rotulo + faixas.proxima());
        }
    }
}
