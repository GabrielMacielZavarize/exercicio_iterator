# Projeto: playlist com anti-pattern (Iterator)

Aplicativo de música simplificado que percorre uma **playlist** de faixas de
várias formas: tocando todas, embaralhando e sugerindo favoritas.

O objetivo deste projeto é **rastrear** o problema de design e propor uma solução
usando o padrão **Iterator**. O código funciona, mas expõe a estrutura interna da
playlist e espalha a travessia pelos clientes.

## Como rodar

O projeto é Maven (Java 17) e abre direto no Eclipse/IntelliJ.

- **Eclipse/IntelliJ:** importe a pasta do projeto e execute a classe `Main`.
- **Linha de comando:**
  ```bash
  mvn compile
  java -cp target/classes br.venson.net.designpatterns.iterator.Main
  ```

## O cenário

- `Faixa`: título, artista, duração e se é favorita.
- `Playlist`: guarda as faixas e expõe a lista interna com `getFaixas()`.
- `Player`: toca todas e toca embaralhado, percorrendo a lista por índice.
- `Recomendador`: percorre as faixas para sugerir as favoritas.
- `RelatorioPlaylist`: percorre as faixas para somar a duração.
- `Main`: monta a playlist e dispara os clientes.

## O que observar

1. `Playlist.getFaixas()` devolve a **própria lista interna** — o encapsulamento
   é quebrado e qualquer cliente pode alterar a coleção.
2. Ao rodar, veja que `tocarEmbaralhado` **muda a ordem da playlist original**
   por operar direto sobre a lista exposta.
3. A **travessia se repete** em três clientes diferentes, cada um refazendo o
   laço por índice.
4. Se a `Playlist` trocar a estrutura interna (array, lista ligada, páginas),
   quantos clientes quebram?
5. Como percorrer a playlist **sem expor** a estrutura e ainda permitir novas
   formas de travessia (embaralhada, só favoritas) sem duplicar laços?

## Tarefa

Rastreie os problemas de design deste código e proponha uma refatoração com o
padrão **Iterator**, deixando claros os papéis: **interface de iterador**
(`temProxima`/`proxima`), **iterador concreto** e o **agregado** que cria o
iterador.
