package jogo;

import java.util.ArrayList;

public class Heroi extends Entidades{
	private ArrayList<Missao> missoesAtivas = new ArrayList<Missao>();
	
	//Contrutores
	public Heroi() {
		this.setNome("Sem_nome");
		this.setRaca("Sem_raça");
		this.setNivel(1);
		this.setVida_max(100);
		this.setVida_atual(this.getVida_max());
		this.setDano_base(2.5);
		this.setStamina_max(50);
		this.setStamina_atual(this.getStamina_max());
		this.setOuro(0);
		this.setExp_atual(0);
		this.setExp_max(this.getNivel() * 3);
		this.setHabilidades("Sem_nome", "Sem_descricao", 0, 0);
	}
	
	public Heroi(String nome, String raca) {
		this.setNome(nome);
		this.setRaca(raca);
		this.setNivel(1);
		this.setVida_max(100);
		this.setVida_atual(this.getVida_max());
		this.setDano_base(2.5);
		this.setStamina_max(50);
		this.setStamina_atual(this.getStamina_max());
		this.setOuro(0);
		this.setExp_atual(0);
		this.setExp_max(this.getNivel() * 3);
		if(raca.equals("Orc")) {
			this.setHabilidades("Paulada", "Desfere um ataque poderoso, causando o dobro do dano base.", this.getDano_base() * 2, 15);
		}else if(raca.equals("Mago")) {
			this.setHabilidades("Bola de fogo", "Lança uma bola de fogo que causa dano alto.", 15, 25);
		}
	}

/* 	// Aceitar missão se não for duplicada
	public void aceitarMissao(Missao missao) {
		if (temMissaoAtiva(missao.getDescricao())) {
			System.out.println("Você já tem essa missão em andamento!");
		} else {
			missoesAtivas.add(missao);
			System.out.println("Missão aceita: " + missao.getDescricao());
		}
	} */

/* 	// Atualiza o progresso das missões ao derrotar um monstro
	public void derrotarMonstro() {
		System.out.println(this.getNome() + " derrotou um monstro!");
		for (Missao missao : missoesAtivas) {
			if (!missao.isConcluida()) {
				missao.atualizarProgresso();
				if (missao.isConcluida()) {
					ganharXp(missao.getXpRecompensa()); // 🎁 Herói ganha XP ao concluir
					System.out.println("Recompensa de XP recebida: " + missao.getXpRecompensa());
				}
			}
		}
	} */

/* 	// Verifica se o herói já tem uma missão ativa com a mesma descrição
	public boolean temMissaoAtiva(String descricao) {
		for (Missao missao : missoesAtivas) {
			if (!missao.isConcluida() && missao.getDescricao().equalsIgnoreCase(descricao)) {
				return true;
			}
		}
		return false;
	} */

	//Level Up
	public void levelUp() {
		if(this.getExp_atual() >= this.getExp_max()){
			System.out.println("\nLEVEL UP!\n");
			this.setNivel(this.getNivel() + 1);
			this.setVida_max(this.getVida_max() + (50 * (this.getNivel() - 1)));
			this.setVida_atual(this.getVida_max());
			this.setStamina_max(this.getStamina_max() + (25 * (this.getNivel() - 1)));
			this.setStamina_atual(this.getStamina_max());
			this.setDano_base(this.getDano_base() + (1.25 * (this.getNivel() - 1)));
			this.setExp_atual(0);
			this.setExp_max(this.getNivel() * 3);
			for(Habilidade h : this.getHabilidades()){
				if(h.getNome_hab().equals("Paulada")){
					h.setDano_hab(this.getDano_base() * 2);
				}
			}
		}
	}

	
	//Listar características do herói
	public void listarHeroi() {
		System.out.println("================================");
		System.out.println(this.getNome());
		System.out.println("Raça: " + this.getRaca());
		System.out.println("Vida: " + this.getVida_atual() + "/" + this.getVida_max());
		System.out.println("Stamina: " + this.getStamina_atual() + "/" + this.getStamina_max());
		System.out.println("Dano base: " + this.getDano_base());
		System.out.println("================================");
		this.chamarListarHabilidades();
		System.out.println("Ouro: " + this.getOuro());
		System.out.println("Nivel: " + this.getNivel());
		System.out.println("EXP: " + this.getExp_atual() + "/" + this.getExp_max());
	}
}