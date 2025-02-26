package jogo;

public class Main {
	public static void main(String[] args) {
		Heroi hero = new Heroi("Goulor", "Orc");
		
		hero.listarHeroi();

		hero.levelUp();

		System.out.println("UPOU DE NIVEL!!!!");

		hero.listarHeroi();
	}

}
