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
	private int exp_atual;
	private int exp_max;
	private ArrayList<Habilidade> habilidades = new ArrayList<Habilidade>();
	private ArrayList<Item> itens = new ArrayList<Item>();


	//Lista as habilidades
	public void chamarListarHabilidades(){
		for(Habilidade h : habilidades) {
			h.listarHabilidade();
		}
	}


	//Guarda uma arma
	public void guardarArma(Item arma){
		itens.add(arma);
	}

	//Guarda uma poção
	public void guardarPocao(Item pocao){
		itens.add(pocao);
	}
	
	
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

	public int getExp_atual(){
		return exp_atual;
	}

	public void setExp_atual(int exp){
		this.exp_atual = exp;
	}

	public int getExp_max(){
		return exp_max;
	}

	public void setExp_max(int exp_max){
		this.exp_max = exp_max;
	}
	
	public ArrayList<Habilidade> getHabilidades() {
		return habilidades;
	}
	
	public void setHabilidades(String nome_hab, String descricao_hab, double dano_hab, double custo_stamina_hab) {
		Habilidade h = new Habilidade(nome_hab, descricao_hab, dano_hab, custo_stamina_hab);
		this.habilidades.add(h);
	}
	
	public ArrayList<Item> getItens() {
		return itens;
	}
}
