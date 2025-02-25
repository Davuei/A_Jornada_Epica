package jogo;

public class Heroi extends Entidades{
	private String armadura = "Sem_armadura";
	
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
		if(raca.equals("Orc")) {
			this.setHabilidades("Paulada", "Desfere um ataque poderoso, causando o dobro do dano base.", this.getDano_base() * 2, 10);
		}else if(raca.equals("Mago")) {
			this.setHabilidades("Bola de fogo", "Lança uma bola de fogo que causa dano alto.", 15, 25);
		}else {
			this.setHabilidades("Sem_nome", "Sem_descricao", 0, 0);
		}
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
		System.out.println("EXP: " + this.getExp());
	}
	
	//Getters e Setters
	public String getArmadura() {
		return armadura;
	}
	
	public void setArmadura(String armadura) {
		this.armadura = armadura;
	}
}
