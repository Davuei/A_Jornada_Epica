package jogo;

import java.util.Random;
import java.util.Scanner;
import java.util.ArrayList;

public class Mundo {
    Scanner batalha_cin = new Scanner(System.in);
    Scanner pause_cin = new Scanner(System.in);
    Random random_mundo = new Random();
    private int mapa[] = new int[15];
    private int level = 0;


    //Construtores

    public Mundo() {
        for(int i = 0; i < 15; i++){
            int rand = random_mundo.nextInt(5) + 1;
            mapa[i] = rand;
        }
    }


    //Passa para o próximo nível

    public int nextLevel(){
        System.out.println("==============================================");
        System.out.println("Fase atual: " + (level + 1));

        return mapa[level];
    }


    //Fases
    public void restLevel(Heroi h){
        System.out.println("\n\n\n\n");
        System.out.println("Não há nada aqui... Você pode descansar...");
        System.out.println("Stamina restaurada!");

        h.setStamina_atual(h.getStamina_max());

        System.out.println("Armas:");
        h.chamarListarArmas();

        System.out.println("Poções:");
        h.chamarListarPocoes();

        pause();
    }

    public void itemLevel(Heroi h){
        System.out.println("\n\n\n\n");
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
        pause();
    }

    public void monsterLevel(Heroi h){
        System.out.println("CUIDADO! UM MONSTRO!!");
        pause();

        int escolha;

        Monstro m = new Monstro();

        do{
            do{
                System.out.println("\n\n\n\n\n\n\n\n\n");
                System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
                System.out.println(h.getNome());
                System.out.println("Vida: " + h.getVida_atual() + "/" + h.getVida_max() + " | Stamina: " + h.getStamina_atual() + "/" + h.getStamina_max());
                System.out.println("Seu turno. Escolha uma opção: ");
                System.out.print("1 - Ataque básico;\n2 - Usar habilidade;\n3 - Usar item;\n4 - Descansar.\n>> ");
                escolha = batalha_cin.nextInt();
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
                ArrayList<Habilidade> hab = h.getHabilidades();

                if(h.getStamina_atual() < hab.get(0).getCusto_stamina_hab()){
                    System.out.println("Você tenta usar sua habilidade '" + hab.get(0).getNome_hab() + "'... mas está muito cansado.");
                }else{
                    System.out.println("Habilidade " + hab.get(0).getNome_hab() + " usada!");
                    m.setVida_atual(m.getVida_atual() - hab.get(0).getDano_hab());
                    h.setStamina_atual(h.getStamina_atual() - hab.get(0).getCusto_stamina_hab());
                }
            }else if(escolha == 3){
                int item_escolha;
                do{
                    System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");;
                    System.out.println("Usar: ");
                    System.out.print("1 - Arma\n2 - Poção\n>>");
                    item_escolha = batalha_cin.nextInt();
                }while(item_escolha < 1 || item_escolha > 2);

                if(item_escolha == 1){
                    if(h.getTamanho_armas() == 0){
                        System.out.println("Você busca por uma arma... mas não encontra nada.");
                    }else{
                        ArrayList<Arma> a = h.getArmas();
                        System.out.println(a.get(0).getNome_item() + " usada!");
                        m.setVida_atual(m.getVida_atual() - a.get(0).getDano_arma());
                    }
                }else if(item_escolha == 2){
                    if(h.getTamanho_pocoes() == 0){
                        System.out.println("Você busca por uma poção... mas não encontra nada.");
                    }else{
                        ArrayList<Pocao> p = h.getPocoes();
                        System.out.println(p.get(0).getNome_item() + " usada!");
                        h.setVida_atual(h.getVida_atual() + p.get(0).getCura());
                        h.setStamina_atual(h.getStamina_atual() + p.get(0).getStamina());
                        h.removerPocao();
                    }
                }
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

            System.out.println("\n\n\n\n\n\n\n\n\n");
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
            System.out.println("Monstro derrotado!!");
            System.out.println("+" + m.getOuro() + " ouro!");
            System.out.println("+" + m.getExp_atual() + " exp!");
            h.setOuro(h.getOuro() + m.getOuro());
            h.setExp_atual(h.getExp_atual() + m.getExp_atual());
            h.levelUp();
            h.verificarMissao(m.getID_monstro());
            pause();
        }
    }

    public void missionLevel(Heroi h){
        System.out.println("````````````````````````````````````````````````````````````");
        System.out.println("Você avança e encontra um humilde fazendeiro");
        Missao mi = new Missao();
        mi.listarMissao();
        h.aceitarMissao(mi);
        System.out.println("Missão aceita!");
        pause();
    }

    public void shopLevel(Heroi h){
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
        System.out.println("Vendedor: 'Gostaria de gastar essas moedas de ouro?'");
        Loja l = new Loja();
        l.itensAVenda(h);
        pause();
    }


    //Pause
    public void pause(){
        System.out.println("Aperte 'Enter' para continuar...");
        String pause = pause_cin.nextLine();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    
    
    //Getters e Setters

    public int getLevel(){
        return level;
    }

    public void setLevel(int level){
        this.level = level;
    }
}