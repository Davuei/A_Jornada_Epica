package jogo;

import java.util.Random;

public class Arma extends Item{
	Random random_arma = new Random();
	private int ID_arma = random_arma.nextInt(3) + 1;
	private double dano_arma;
	private double custo_stamina_arma;

	//Construtores
	public Arma(){
		if(ID_arma == 1){
			this.setNome_item("Espada");
			this.setDescricao_item("Espada iniciante. Bom para iniciantes.");
			this.dano_arma = 5;
			this.custo_stamina_arma = 10;
		}else if(ID_arma == 2){
			this.setNome_item("Machado");
			this.setDescricao_item("Machado de duas mãos, então dá mais dano!");
			this.dano_arma = 7.5;
			this.custo_stamina_arma = 25;
		}else if(ID_arma == 3){
			this.setNome_item("Adagas");
			this.setDescricao_item("Pouco dano, mas gasta menos stamina.");
			this.dano_arma = 3.5;
			this.custo_stamina_arma = 5;
		}else{
			this.setNome_item("Nada...");
			this.setDescricao_item("Você encontrou um belo de um nada!");
			this.dano_arma = 0;
			this.custo_stamina_arma = 0;
		}
	}

	//Getters e Setters
	public double getDano_arma(){
		return dano_arma;
	}

	public void setDano_arma(double dano_arma){
		this.dano_arma = dano_arma;
	}

	public double getCusto_stamina(){
		return custo_stamina_arma;
	}

	public void setCusto_stamina(double custo_stamina){
		this.custo_stamina_arma = custo_stamina;
	}
}

