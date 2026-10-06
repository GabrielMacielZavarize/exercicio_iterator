package br.venson.net.designpatterns.iterator;

/** Um único laço serve para qualquer ordem: quem decide é o iterador recebido. */
public class Player {

    public void tocar(Iterador<Faixa> faixas) {
        while (faixas.temProxima()) {
            System.out.println("  > Tocando: " + faixas.proxima());
        }
    }
}
