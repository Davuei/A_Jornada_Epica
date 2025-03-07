package jogo;

import java.util.Random;

public class Pocao extends Item {
	Random random_pocao = new Random();
	private int ID_pocao = random_pocao.nextInt(3) + 1;
	private double cura;
	private double stamina;


	//Retorna as informações da poção
	public void listarPocao(){
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		System.out.println(this.getNome_item());
		System.out.println("Descrição: " + this.getDescricao_item());
		System.out.println("Cura: " + this.getCura());
		System.out.println("Stamina: " + this.getStamina());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}


	//Construtores

	public Pocao(){
		if(ID_pocao == 1){
			this.setNome_item("Poção de cura");
			this.setDescricao_item("Pequena poção vermelha que restaura 20 de vida.");
			this.setCura(20);
			this.setStamina(0);
		}else if(ID_pocao == 2){
			this.setNome_item("Poção de stamina");
			this.setDescricao_item("Pequena poção azul que restaura 25 de stamina.");
			this.setCura(0);
			this.setStamina(25);
		}else{
			this.setNome_item("Poção mista");
			this.setDescricao_item("Poção de tonalidade violeta que restaura 15 de vida e 20 de stamina.");
			this.setCura(15);
			this.setStamina(20);
		}
	}


	//Getters e Setters

	public double getCura(){
		return cura;
	}

	public void setCura(double cura){
		this.cura = cura;
	}

	public double getStamina(){
		return stamina;
	}

	public void setStamina(double stamina){
		this.stamina = stamina;
	}
}
