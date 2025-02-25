package jogo;

import java.util.*;

// Classe Missao
class Missao {
    private String descricao;
    private int objetivoMonstros;
    private int monstrosDerrotados;
    private int xpRecompensa;
    private boolean concluida;

    public Missao(String descricao, int objetivoMonstros, int xpRecompensa) {
        this.descricao = descricao;
        this.objetivoMonstros = objetivoMonstros;
        this.monstrosDerrotados = 0;
        this.xpRecompensa = xpRecompensa;
        this.concluida = false;
    }

    public int getObjetivoMonstros() {
    return objetivoMonstros;
}

    public int getMonstrosDerrotados() {
    return monstrosDerrotados;
}
    public void atualizarProgresso() {
        monstrosDerrotados++;
        if (monstrosDerrotados >= objetivoMonstros) {
            concluida = true;
            System.out.println("Missão concluída: " + descricao);
        } else {
            System.out.println("Progresso da missão: " + monstrosDerrotados + "/" + objetivoMonstros);
        }
    }

    public boolean isConcluida() {
        return concluida;
    }

    public int getXpRecompensa() {
        return xpRecompensa;
    }

    public String getDescricao() {
        return descricao;
    }
}

//heroi.ganharXp(missao.getXpRecompensa()); para dar recompensa da missao para o heroi
