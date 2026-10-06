package br.venson.net.designpatterns.iterator;

import java.util.ArrayList;
import java.util.List;

public class Playlist {
    private final List<Faixa> faixas = new ArrayList<>();

    public void adicionar(Faixa faixa) {
        faixas.add(faixa);
    }

    // Expoe a estrutura interna: devolve a propria lista, nao uma copia.
    public List<Faixa> getFaixas() {
        return faixas;
    }
}
