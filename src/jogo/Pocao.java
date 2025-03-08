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
		System.out.println(getNome_item());
		System.out.println("Descrição: " + getDescricao_item());
		System.out.println("Cura: " + getCura());
		System.out.println("Stamina: " + getStamina());
		System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
	}


	//Construtores

	public Pocao(){
		if(ID_pocao == 1){
			setNome_item("Poção de cura");
			setDescricao_item("Pequena poção vermelha que restaura 20 de vida.");
			setCura(20);
			setStamina(0);
		}else if(ID_pocao == 2){
			setNome_item("Poção de stamina");
			setDescricao_item("Pequena poção azul que restaura 25 de stamina.");
			setCura(0);
			setStamina(25);
		}else{
			setNome_item("Poção mista");
			setDescricao_item("Poção de tonalidade violeta que restaura 15 de vida e 20 de stamina.");
			setCura(15);
			setStamina(20);
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

	public int getID_pocao(){
		return ID_pocao;
	}
}
