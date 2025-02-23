package jogo;

public class Habilidade {
	private String nome_hab;
	private String descricao_hab;
	private double dano_hab;
	
	//Construtores
	public Habilidade() {
		this.nome_hab = "Sem_nome";
		this.descricao_hab = "Sem_descrição";
		this.dano_hab = 0;
	}
	
	public Habilidade(String nome_hab, String descricao_hab, double dano_hab) {
		this.nome_hab = nome_hab;
		this.descricao_hab = descricao_hab;
		this.dano_hab = dano_hab;
	}
	
	//Retornar caracterísricas das habilidades
	public void listarHabilidade() {
		System.out.println("Habilidade: " + nome_hab + "\nDescrição: " + descricao_hab + " \nDano: " + dano_hab);
		System.out.println("================================");
	}
	
	//Retornar habilidade
//	public Habilidade criarHabilidade() {
//		Habilidade h = new Habilidade();
//		return h;
//	}
//	
//	public Habilidade criarHabilidade(String nome, String descricao, double dano) {
//		Habilidade h = new Habilidade(nome, descricao, dano);
//		return h;
//	}
}
