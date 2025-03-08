package jogo;

public class Habilidade {
	private String nome_hab;
	private String descricao_hab;
	private double dano_hab;
	private double custo_stamina_hab;
	
	//Construtores
	public Habilidade(String nome_hab, String descricao_hab, double dano_hab, double custo_stamina_hab) {
		this.nome_hab = nome_hab;
		this.descricao_hab = descricao_hab;
		this.dano_hab = dano_hab;
		this.custo_stamina_hab = custo_stamina_hab;
	}
	

	//Retornar caracterísricas das habilidades
	public void listarHabilidade() {
		System.out.println("Habilidade: " + nome_hab + "\nDescrição: " + descricao_hab + "\nDano: " + dano_hab + "\nCusto da stamina: " + custo_stamina_hab);
		System.out.println("================================");
	}


	//Getters e Setters
	public String getNome_hab(){
		return nome_hab;
	}

	public void setDano_hab(double dano_hab){
		this.dano_hab = dano_hab;
	}

	public double getDano_hab(){
		return dano_hab;
	}

	public double getCusto_stamina_hab(){
		return custo_stamina_hab;
	}
	
}
