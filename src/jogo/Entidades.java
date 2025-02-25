package jogo;

import java.util.ArrayList;

public abstract class Entidades {
	private String nome;
	private String raca;
	private double vida_max;
	private double vida_atual;
	private double dano_base;
	private double stamina_max;
	private double stamina_atual;
	private int nivel;
	private int ouro;
	private int exp;
	private ArrayList<Habilidade> habilidades = new ArrayList<Habilidade>();
	private ArrayList<Item> itens = new ArrayList<Item>();
	
	//Getters e Setters
	public String getNome() {
		return nome;
	}
	
	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getRaca() {
		return raca;
	}
	
	public void setRaca(String raca) {
		this.raca = raca;
	}
	
	public double getVida_max() {
		return vida_max;
	}
	
	public void setVida_max(double vida_max) {
		this.vida_max = vida_max;
	}
	
	public double getVida_atual() {
		return vida_atual;
	}
	
	public void setVida_atual(double vida_atual) {
		this.vida_atual = vida_atual;
	}
	
	public double getDano_base() {
		return dano_base;
	}
	
	public void setDano_base(double dano_base) {
		this.dano_base = dano_base;
	}
	
	public double getStamina_max() {
		return stamina_max;
	}
	
	public void setStamina_max(double stamina_max) {
		this.stamina_max = stamina_max;
	}
	
	public double getStamina_atual() {
		return stamina_atual;
	}
	
	public void setStamina_atual(double stamina_atual) {
		this.stamina_atual = stamina_atual;
	}
	
	public int getNivel() {
		return nivel;
	}
	
	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getOuro(){
		return ouro;
	}

	public void setOuro(int ouro){
		this.ouro = ouro;
	}

	public int getExp(){
		return exp;
	}

	public void setExp(int exp){
		this.exp = exp;
	}
	
	public void getHabilidades() {
		for(Habilidade h : habilidades) {
			h.listarHabilidade();
		}
	}
	
	public void setHabilidades(String nome_hab, String descricao_hab, double dano_hab, double custo_stamina_hab) {
		Habilidade h = new Habilidade(nome_hab, descricao_hab, dano_hab, custo_stamina_hab);
		this.habilidades.add(h);
	}

	/*public void getItens(){
		for(Item i : itens){
			i.listarItem();
		}
	}*/

	/*public void setItens(){
		Item i = new Item();
		this.itens.add(i);
	}
	 * 
	 */
	
	public ArrayList<Item> getItens() {
		return itens;
	}
	
	public void setItens(ArrayList<Item> itens) {
		this.itens = itens;
	}
}
