package jogo;

import java.util.Scanner;

public class Loja {
    Scanner loja_cin = new Scanner(System.in);
    private int i1_preco;
    private int i2_preco;
    
    public void itensAVenda(Heroi h){
        int escolha_loja;
        Arma i1 = new Arma();
        Pocao i2 = new Pocao();

        System.out.println("Itens a venda:");
        i1.listarArma();
        i2.listarPocao();

        if(i1.getID_arma() == 1){
            i1_preco = 30;
        }else if(i1.getID_arma() == 2){
            i1_preco = 45;
        }else if(i1.getID_arma() == 3){
            i1_preco = 20;
        }

        if(i2.getID_pocao() == 1){
            i2_preco = 20;
        }else if(i2.getID_pocao() == 2){
            i2_preco = 15;
        }else if(i2.getID_pocao() == 3){
            i2_preco = 35;
        }

        do{
            do{
                System.out.println("*****************************************************");
                System.out.println("Seu ouro: " + h.getOuro());
                System.out.println("Qual você gostaria de comprar?");
                System.out.println("1 - " + i1.getNome_item() + " | Preço: " + i1_preco);
                System.out.println("2 - " + i2.getNome_item() + " | Preço: " + i2_preco);
                System.out.println("3 - Sair.");
                System.out.print(">> ");
                escolha_loja = loja_cin.nextInt();
            }while(escolha_loja > 3 || escolha_loja < 1);
            
            if(escolha_loja == 1){
                if(h.getOuro() < i1_preco){
                    System.out.println("\n\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println("Ouro insuficiente...");
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n\n");
                }else{
                    System.out.println(i1.getNome_item() + " comprado!");
                    h.guardarArma(i1);
                    h.setOuro(h.getOuro() - i1_preco);
                    break;
                }
            }else if(escolha_loja == 2){
                if(h.getOuro() < i2_preco){
                    System.out.println("\n\nXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX");
                    System.out.println("Ouro insuficiente...");
                    System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX\n\n");
                }else{
                    System.out.println(i2.getNome_item() + " comprado!");
                    h.guardarPocao(i2);
                    h.setOuro(h.getOuro() - i1_preco);
                    break;
                }
            }else{
                break;
            }
        }while(true);
        
    }
}
