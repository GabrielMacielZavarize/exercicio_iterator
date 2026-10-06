package br.venson.net.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {

    private final String nome;
    private final List<Faixa> faixas = new ArrayList<>();

    public Playlist(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void adicionar(Faixa faixa) {
        faixas.add(faixa);
    }

    // ANTI-PATTERN: devolve a própria lista interna (sem cópia, sem proteção).
    public List<Faixa> getFaixas() {
        return faixas;
    }
}
