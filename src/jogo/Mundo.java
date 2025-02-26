package jogo;

import java.util.*;

public class Mundo {
    private int[][] mapa;
    private int posicaoX;
    private int posicaoY;
    private Heroi heroi;
    private Random rand = new Random();

    public Mundo(int linhas, int colunas, Heroi heroi) {
        this.mapa = new int[linhas][colunas];
        this.posicaoX = 0;
        this.posicaoY = 0;
        this.heroi = heroi;
        gerarMundo();
    }

    // Geração aleatória do mapa
    private void gerarMundo() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                mapa[i][j] = rand.nextInt(5) + 1; // 1 a 5
            }
        }
        mapa[posicaoX][posicaoY] = 5; // Posição inicial do herói vazia
    }

    // Exibe o mapa com a posição do herói
    public void exibirMapa() {
        for (int i = 0; i < mapa.length; i++) {
            for (int j = 0; j < mapa[0].length; j++) {
                if (i == posicaoX && j == posicaoY) {
                    System.out.print(" H ");
                } else {
                    System.out.print(" [" + mapa[i][j] + "]");
                }
            }
            System.out.println();
        }
    }

/*     // Movimentação
    public void mover(String direcao) {
        switch (direcao.toLowerCase()) {
            case "w": // cima
                if (posicaoX > 0) posicaoX--;
                else System.out.println("Não pode ir mais para cima!");
                break;
            case "s": // baixo
                if (posicaoX < mapa.length - 1) posicaoX++;
                else System.out.println("Não pode ir mais para baixo!");
                break;
            case "a": // esquerda
                if (posicaoY > 0) posicaoY--;
                else System.out.println("Não pode ir mais para a esquerda!");
                break;
            case "d": // direita
                if (posicaoY < mapa[0].length - 1) posicaoY++;
                else System.out.println("Não pode ir mais para a direita!");
                break;
            default:
                System.out.println("Direção inválida. Use W (cima), S (baixo), A (esquerda), D (direita).");
                return;
        }
        interagirComCelula();
    } */

    // Interações com a célula atual
    /* private void interagirComCelula() {
        int evento = mapa[posicaoX][posicaoY];
        switch (evento) {
            case 1 -> { // Item
                Item item = new Item("Poção de Cura", "Restaura 20 de vida");
                System.out.println("Você encontrou um item: " + item.getNome());
                heroi.coletarItem(item);
            }
            case 2 -> { // Monstro
                Monstro monstro = new Monstro("Goblin", 20, 5);
                System.out.println("Você encontrou um monstro: " + monstro.getNome());
                heroi.lutar(monstro);
            }
            case 3 -> { // Missão
                Missao missao = new Missao("Derrote 3 Goblins", 3, 100);
                System.out.println("Nova missão: " + missao.getDescricao());
                heroi.aceitarMissao(missao);
            }
            case 4 -> { // Loja
                System.out.println("Você encontrou uma loja. Aqui você pode comprar e vender itens!");
           // Lógica da loja pode ser expandida
            }
            case 5 -> System.out.println("Caminho livre... Nada por aqui!");
        }
        mapa[posicaoX][posicaoY] = 5; // Define como visitado
    } */

    /* // Simulador de jogo
    public void iniciarJogo() {
        Scanner scanner = new Scanner(System.in);
        String comando;
        System.out.println("Bem-vindo ao mundo de aventuras!");
        while (true) {
            exibirMapa();
            System.out.print("Mova o herói (W/A/S/D) ou 'sair' para encerrar: ");
            comando = scanner.nextLine();
            if (comando.equalsIgnoreCase("sair")) break;
            mover(comando);
        }
        System.out.println("Jogo finalizado. Obrigado por jogar!");
        scanner.close();
    } */
}
