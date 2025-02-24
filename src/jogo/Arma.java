package jogo;

public class Arma extends Item{
	private double dano_arma;
	private String tipo_arma; //machado, espada, lança
	private int id_arma;


	public double getdano_arma(){
		return dano_arma;
	}

	public void setdano_arma(double dano_arma){
		this.dano_arma = dano_arma;
	}

	public String gettipo_arma(){
		return tipo_arma;

	}

	public void settipo_arma(String tipo_arma){
		this.tipo_arma = tipo_arma;

	}


	//metodos

	public Arma(){

		this.dano_arma = dano_arma;
		this.tipo_arma = tipo_arma;
		this.id_arma = id_arma;

		if( id_arma.equals(1) ){
			this.settipo_arma("Espada");
			this.setdano_arma(5);

		}if else(id_arma.equals(2) ){
			this.settipo_arma("Machado");
			this.setdano_arma(7.5);

		}if else(id_arma.equals(3) ){
			this.settipo_arma("Adaga");
			this.setdano_arma(3.5);
			}
		}else{
			this.settipo_arma("Sem arma");
			this.setdano_arma(0);
		}
	}

