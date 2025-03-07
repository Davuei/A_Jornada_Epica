package jogo;

import java.util.Random;

public class Arma extends Item{
	Random random_arma = new Random();
	private int ID_arma = random_arma.nextInt(3) + 1;
	private double dano_arma;


	//Retorna as informações da arma
	public void listarArma(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(this.getNome_item());
		System.out.println("Descrição: " + this.getDescricao_item());
		System.out.println("Dano: " + this.getDano_arma());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}


	//Construtores
	public Arma(){
		if(ID_arma == 1){
			this.setNome_item("Espada");
			this.setDescricao_item("Espada iniciante. Bom para iniciantes.");
			this.dano_arma = 5;
		}else if(ID_arma == 2){
			this.setNome_item("Machado");
			this.setDescricao_item("Machado de duas mãos, então dá mais dano!");
			this.dano_arma = 7.5;
		}else{
			this.setNome_item("Adagas");
			this.setDescricao_item("Não causam muito dano, mas são bem estilosas.");
			this.dano_arma = 3.5;
		}
		
	}

	//Getters e Setters
	public double getDano_arma(){
		return dano_arma;
	}

	public void setDano_arma(double dano_arma){
		this.dano_arma = dano_arma;
	}
}

