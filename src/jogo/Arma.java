package jogo;

public class Arma extends Item{
	private double dano_arma;
	private String tipo_arma; //machado, espada, lança


	public double getdano_arma(){
		return dano_arma;
	}

	public double setdano_arma(double dano_arma){
		this.dano_arma = dano_arma;
	}

	//metodos

	public Arma(){
		this.dano_arma = (4)
	}



}
