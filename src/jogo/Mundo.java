package jogo;

import java.util.Random;
import java.util.Scanner;

public class Mundo {
    Random random_mundo = new Random();
    private int mapa[] = new int[20];
    private int level = 0;


    //Construtores

    public Mundo() {
        for(int i = 0; i < 20; i++){
            int rand = random_mundo.nextInt(5) + 1;
            mapa[i] = rand;

            System.out.println((i + 1) + "ª fase: " + mapa[i]);
        }
    }


    //Passa para o próximo nível

    public int nextLevel(){
        System.out.println("Nível atual: " + (level + 1));

        return mapa[level];
    }


    //Fases

    public void restLevel(Heroi h){
        System.out.println("Não há nada aqui... Você pode descansar...");
        System.out.println("Stamina restaurada!");

        h.setStamina_atual(h.getStamina_max());
    }

    public void itemLevel(Heroi h){
        System.out.println("Item encontrado!");

        Random gerar_item = new Random();
        int i = gerar_item.nextInt(2) + 1;

        if(i == 1){
            System.out.println("Você encontrou uma arma!");
            Arma a = new Arma();
            a.listarArma();
            h.guardarArma(a);
        }else{
            System.out.println("Você encontrou uma poção!");
            Pocao p = new Pocao();
            p.listarPocao();
            h.guardarPocao(p);
        }
        System.out.println("Item adicionado ao seu inventário!");
    }

    public void monsterLevel(Heroi h){
        System.out.println("CUIDADO! UM MONSTRO!!");

        Scanner cin = new Scanner(System.in);
        int escolha;

        Monstro m = new Monstro();

        do{
            do{
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(h.getNome());
                System.out.println("Vida: " + h.getVida_atual() + "/" + h.getVida_max() + " | Stamina: " + h.getStamina_atual() + "/" + h.getStamina_max());
                System.out.println("Seu turno. Escolha uma opção: ");
                System.out.print("1 - Ataque básico;\n2 - Usar habilidade;\n3 - Usar item;\n4 - Descansar.\n>> ");
                escolha = cin.nextInt();
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            }while(escolha > 4 || escolha < 1);

            if(escolha == 1){
                if(h.getStamina_atual() < 10){
                    System.out.println("Você tenta atacar o monstro... mas está muito cansado.");
                }else{
                    System.out.println("Ataque!");;
                    m.setVida_atual(m.getVida_atual() - h.getDano_base());
                    h.setStamina_atual(h.getStamina_atual() - 10);
                }
            }else if(escolha == 2){
                System.out.println("habilidade kk");
            }else if(escolha == 3){
                System.out.println("hmmmm itenzin");
            }else{
                System.out.println("Sabiamente, você usa seu turno para restaurar suas forças.");
                h.setStamina_atual(h.getStamina_atual() + 20);

                if(h.getStamina_atual() > h.getStamina_max()){
                    h.setStamina_atual(h.getStamina_max());
                }
            }

            if(m.getVida_atual() <= 0){
                break;
            }

            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            System.out.println("Turno do monstro!");
            System.out.println(m.getNome());
            System.out.println("Vida: " + m.getVida_atual() + "/" + m.getVida_max() + " | Stamina: " + m.getStamina_atual() + "/" + m.getStamina_max());
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");

            if(m.getStamina_atual() < 10){
                System.out.println("O monstro estava muito cansado para atacar...");
                m.setStamina_atual(m.getStamina_atual() + 5);
            }else{
                System.out.println(m.getNome() + " ataca, causando " + m.getDano_base() + " de dano!");;
                h.setVida_atual(h.getVida_atual() - m.getDano_base());
                m.setStamina_atual(m.getStamina_atual() - 10);
            }
        }while(h.getVida_atual() > 0 && m.getVida_atual() > 0);

        if(m.getVida_atual() <= 0){
            h.setOuro(h.getOuro() + m.getOuro());
            h.setExp_atual(h.getExp_atual() + m.getExp_atual());
            h.levelUp();
        }
    }

    public void missionLevel(Heroi h){
        System.out.println("Você avança e encontra um humilde fazendeiro");
    }

    public void shopLevel(Heroi h){
        System.out.println("Vendedor: 'Gostaria de gastar essas moedas de ouro?'");
        Loja l = new Loja();
        l.itensAVenda(h);
    }
    
    
    //Getters e Setters

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }

}