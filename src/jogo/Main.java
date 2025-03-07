package jogo;

public class Main {
	public static void main(String[] args){
		Mundo mundo = new Mundo();

		Heroi hero = new Heroi("Goulor", "Orc");

		//Loop do jogo
		do{
			if(hero.getVida_atual() <= 0){
				break;
			}

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

			hero.listarHeroi();

		}while(mundo.getLevel() != 20);
		
		//Fim de jogo
		if(hero.getVida_atual() <= 0){
			System.out.println("GAME OVER!!");
		}else{
			System.out.println("YOU WIN!!");
		}
		
	}

}
