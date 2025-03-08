package jogo;

import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		Scanner inicio = new Scanner(System.in);
		System.out.print("Seu nome: ");
		String nome = inicio.nextLine();
		int raca;
		String raca_nome;

		do{
			System.out.print("Escolha sua raça:\n1 - Orc;\n2 - Mago\n>>");
			raca = inicio.nextInt();
		}while(raca < 1 || raca >2);

		if(raca == 1){
			raca_nome = "Orc";
		}else{
			raca_nome = "Mago";
		}

		Mundo mundo = new Mundo();

		Heroi hero = new Heroi(nome, raca_nome);

		//Loop do jogo
		do{
			if(hero.getVida_atual() <= 0){
				break;
			}

			hero.listarHeroi();

			switch (mundo.nextLevel()) {
				case 1:
					mundo.restLevel(hero);
					break;
				
				case 2:
					mundo.itemLevel(hero);
					break;

				case 3:
					mundo.monsterLevel(hero);
					break;
				
				case 4:
					mundo.missionLevel(hero);
					break;
				
				case 5:
					mundo.shopLevel(hero);
					break;
			
				default:
					break;
			}

			mundo.setLevel(mundo.getLevel() + 1); //Configura para ir para a próxima fase

		}while(mundo.getLevel() != 15);

		System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
		
		//Fim de jogo
		if(hero.getVida_atual() <= 0){
			System.out.println("GAME OVER!!");
		}else{
			System.out.println("YOU WIN!!");
		}
		inicio.close();
	}

}
