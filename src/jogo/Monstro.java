package jogo;

import java.util.Random;

public class Monstro extends Entidades {
	Random random_monstro = new Random();
	private int ID_monstro = random_monstro.nextInt(3) + 1;

	
	//Construtores
	public Monstro() {
		if(ID_monstro == 1){
			this.setNome("Scarlet");
			this.setRaca("Fada");
			this.setNivel(1);
			this.setVida_max(25);
			this.setVida_atual(this.getVida_max());
			this.setDano_base(1);
			this.setStamina_max(45);
			this.setStamina_atual(this.getStamina_max());
			this.setOuro(5);
			this.setExp_atual(1);
			this.setExp_max(this.getNivel() * 3);
			this.setHabilidades("Pó mágico", "Joga um pó mágico que causa um dano considerável.", 10, 20);
		}else if(ID_monstro == 2){
			this.setNome("Grin");
			this.setRaca("Goblin");
			this.setNivel(2);
			this.setVida_max(30);
			this.setVida_atual(this.getVida_max());
			this.setDano_base(5);
			this.setStamina_max(60);
			this.setStamina_atual(this.getStamina_max());
			this.setOuro(10);
			this.setExp_atual(2);
			this.setExp_max(this.getNivel() * 3);
			this.setHabilidades("Ataque duplo", "Seu ataque causa 50% a mais de dano", this.getDano_base() * 1.5, 15);
		}else if(ID_monstro == 3){
			this.setNome("Drarx");
			this.setRaca("Demônio");
			this.setNivel(3);
			this.setVida_max(80);
			this.setVida_atual(this.getVida_max());
			this.setDano_base(10);
			this.setStamina_max(65);
			this.setStamina_atual(this.getStamina_max());
			this.setOuro(15);
			this.setExp_atual(3);
			this.setExp_max(this.getNivel() * 3);
			this.setHabilidades("Arranhão", "Desfere um arranhão poderoso, causando muito dano", 35, 50);
		}
	}

	
}
