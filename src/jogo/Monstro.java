package jogo;

import java.util.Random;

public class Monstro extends Entidades {
	Random random_monstro = new Random();
	private int ID_monstro = random_monstro.nextInt(3) + 1;

	
	//Construtores
	public Monstro() {
		if(ID_monstro == 1){
			setNome("Scarlet");
			setRaca("Fada");
			setNivel(1);
			setVida_max(25);
			setVida_atual(this.getVida_max());
			setDano_base(1);
			setStamina_max(45);
			setStamina_atual(this.getStamina_max());
			setOuro(5);
			setExp_atual(1);
			setExp_max(this.getNivel() * 3);
			setHabilidades("Pó mágico", "Joga um pó mágico que causa um dano considerável.", 10, 20);
		}else if(ID_monstro == 2){
			setNome("Grin");
			setRaca("Goblin");
			setNivel(2);
			setVida_max(30);
			setVida_atual(this.getVida_max());
			setDano_base(5);
			setStamina_max(60);
			setStamina_atual(this.getStamina_max());
			setOuro(10);
			setExp_atual(2);
			setExp_max(this.getNivel() * 3);
			setHabilidades("Ataque duplo", "Seu ataque causa 50% a mais de dano", this.getDano_base() * 1.5, 15);
		}else if(ID_monstro == 3){
			setNome("Drarx");
			setRaca("Demônio");
			setNivel(3);
			setVida_max(80);
			setVida_atual(this.getVida_max());
			setDano_base(10);
			setStamina_max(65);
			setStamina_atual(this.getStamina_max());
			setOuro(15);
			setExp_atual(3);
			setExp_max(this.getNivel() * 3);
			setHabilidades("Arranhão", "Desfere um arranhão poderoso, causando muito dano", 35, 50);
		}
	}

	
	//Getters e Setters
	public int getID_monstro(){
		return ID_monstro;
	}
}
