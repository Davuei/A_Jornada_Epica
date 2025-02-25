package jogo;

public class Heroi extends Entidades{
	private String armadura = "Sem_armadura";
	private int xp;
	private int xpProximoNivel;
	private List<Missao> missoesAtivas = new ArrayList<Missao>();
	
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
		this.setHabilidades("Sem_nome", "Sem_descricao", 0, 0);
		this.xp = 0;
		this.xpProximoNivel = 100; // XP necessário para o próximo nível

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
		this.xp = 0;
		this.xpProximoNivel = 100;
		if(raca.equals("Orc")) {
			this.setHabilidades("Paulada", "Desfere um ataque poderoso, causando o dobro do dano base.", this.getDano_base() * 2, 10);
		}else if(raca.equals("Mago")) {
			this.setHabilidades("Bola de fogo", "Lança uma bola de fogo que causa dano alto.", 15, 25);
		}else {
			this.setHabilidades("Sem_nome", "Sem_descricao", 0, 0);
		}
	}

	// Aceitar missão se não for duplicada
public void aceitarMissao(Missao missao) {
    if (temMissaoAtiva(missao.getDescricao())) {
        System.out.println("Você já tem essa missão em andamento!");
    } else {
        missoesAtivas.add(missao);
        System.out.println("Missão aceita: " + missao.getDescricao());
    }
}

	// Atualiza o progresso das missões ao derrotar um monstro
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
    }}


	// Verifica se o herói já tem uma missão ativa com a mesma descrição
public boolean temMissaoAtiva(String descricao) {
    for (Missao missao : missoesAtivas) {
        if (!missao.isConcluida() && missao.getDescricao().equalsIgnoreCase(descricao)) {
            return true;
        }
    }
    return false;
}


	

	//Level Up
	public void levelUp() {
		this.setNivel(this.getNivel() + 1);
		this.setVida_max(this.getVida_max() + (50 * (this.getNivel() - 1)));
		this.setVida_atual(this.getVida_max());
		this.setStamina_max(this.getStamina_max() + (25 * (this.getNivel() - 1)));
		this.setStamina_atual(this.getStamina_max());
	}
	
	//Guardar habilidade
	public void guardarHabilidade() {
		
	}

	//ganho de XP
	public void ganharXp(int quantidade) {
    this.xp += quantidade;
	System.out.printf("%s ganhou %d XP! Total: %d / %d%n", this.getNome(), quantidade, this.xp, this.xpProximoNivel);
    verificarLevelUp();
}

	//aviso de level up
	private void verificarLevelUp() {
    while (this.xp >= this.xpProximoNivel) {
        this.xp -= this.xpProximoNivel;
        levelUp();
        this.xpProximoNivel = (int) (this.xpProximoNivel * 1.5);
        System.out.println("Parabéns! " + this.getNome() + " subiu para o nível: " + this.getNivel() + "!");
    }
}

	
	//Listar características do herói
	public void listarHeroi() {
		System.out.println(this.getNome());
		System.out.println("Vida: " + this.getVida_atual() + "/" + this.getVida_max());
		System.out.println("Stamina: " + this.getStamina_atual() + "/" + this.getStamina_max());
		System.out.println("Raça: " + this.getRaca());
		System.out.println("Habilidades: ");
		this.getHabilidades();
		System.out.println("Ouro: " + this.getOuro());
		System.out.println("Nivel: " + this.getNivel());
		System.out.println("EXP: " + this.xp + "/" + this.xpProximoNivel);
		System.out.println("Missões ativas:");
		for (Missao missao : missoesAtivas) {
   		String status = missao.isConcluida() ? "Concluída" : "Em progresso";
   	 	String progresso = missao.isConcluida() ? "" : String.format(" - Faltam %d monstros", missao.objetivoMonstros - missao.monstrosDerrotados);
    	System.out.println("- " + missao.getDescricao() + " [" + status + "]" + progresso);
}

	}
	
	//Getters e Setters
	public String getArmadura() {
		return armadura;
	}
	
	public void setArmadura(String armadura) {
		this.armadura = armadura;
	}

	 public int getXp() {
        return xp;
    }

    public int getXpProximoNivel() {
        return xpProximoNivel;
    }

}
}