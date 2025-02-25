package jogo;

public abstract class Item {
	private String nome_item;
	private String descricao_item;
	
	//Getters e Setters
	public String getNome_item() {
		return nome_item;
	}
	public void setNome_item(String nome_item) {
		this.nome_item = nome_item;
	}
	public String getDescricao_item() {
		return descricao_item;
	}
	public void setDescricao_item(String descricao_item) {
		this.descricao_item = descricao_item;
	}
}
