package jogo;

import java.util.Random;

// Classe Missao
class Missao {
    Random random_missao = new Random();
    private int ID_missao = random_missao.nextInt(3) + 1;
    private String descricao;
    private int expRecompensa;
    private int ouroRecompensa;

    public Missao(){
        if(ID_missao == 1){
            descricao = "Consiga as asas de uma fada para mim e irei te recompensar!!!";
            expRecompensa = 2;
            ouroRecompensa = 0;
        }else if(ID_missao == 2){
            descricao = "Derrote um goblim e te darei muita experiência e muito ouro!";
            expRecompensa = 4;
            ouroRecompensa = 10;
        }else if(ID_missao == 3){
            descricao = "Traga-me a cabeça de um demônio e você será bem recompensado.";
            expRecompensa = 6;
            ouroRecompensa = 30;
        }
    }

    
    //Mostra as características da missão
    public void listarMissao(){
        System.out.println("Descrição: " + this.descricao);
        System.out.println("Exp recompensa: " + this.expRecompensa);
        System.out.println("Ouro recompensa: " + this.ouroRecompensa);
    }


    //Getters e Setters
    public int getID_missao(){
        return ID_missao;
    }

    public int getExpRecompensa(){
        return expRecompensa;
    }

    public int getOuroRecompensa(){
        return ouroRecompensa;
    }
}