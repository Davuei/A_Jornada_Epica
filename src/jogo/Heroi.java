package jogo;

import java.util.ArrayList;
import java.util.Iterator;

public class Heroi extends Entidades{
	private ArrayList<Missao> missoesAtivas = new ArrayList<Missao>();
	
	//Contrutores
	public Heroi(String nome, String raca) {
		setNome(nome);
		setRaca(raca);
		setNivel(1);
		setVida_max(100);
		setVida_atual(this.getVida_max());
		setDano_base(2.5);
		setStamina_max(50);
		setStamina_atual(this.getStamina_max());
		setOuro(0);
		setExp_atual(0);
		setExp_max(this.getNivel() * 3);
		if(raca.equals("Orc")) {
			setHabilidades("Paulada", "Desfere um ataque poderoso, causando o dobro do dano base.", this.getDano_base() * 2, 15);
		}else if(raca.equals("Mago")) {
			setHabilidades("Bola de fogo", "Lança uma bola de fogo que causa dano alto.", 15, 25);
		}
	}


	//Level Up
	public void levelUp() {
		if(this.getExp_atual() >= this.getExp_max()){
			System.out.println("\nLEVEL UP!\n");
			setNivel(this.getNivel() + 1);
			setVida_max(this.getVida_max() + (50 * (this.getNivel() - 1)));
			setVida_atual(this.getVida_max());
			setStamina_max(this.getStamina_max() + (25 * (this.getNivel() - 1)));
			setStamina_atual(this.getStamina_max());
			setDano_base(this.getDano_base() + (1.25 * (this.getNivel() - 1)));
			setExp_atual(0);
			setExp_max(this.getNivel() * 3);
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
		chamarListarHabilidades();
		System.out.println("Ouro: " + this.getOuro());
		System.out.println("Nivel: " + this.getNivel());
		System.out.println("EXP: " + this.getExp_atual() + "/" + this.getExp_max());
	}


	//Receber missão
	public void aceitarMissao(Missao missao){
		missoesAtivas.add(missao);
	}


	//Verifica se uma missão foi finalizada após a batalha
    public void verificarMissao(int ID){
		Iterator<Missao> itr = missoesAtivas.iterator();

        for(Missao mi : getMissoesAtivas()){
            if(mi.getID_missao() == ID){
                System.out.println("Missão concluída!!");
                setExp_atual(getExp_atual() + mi.getExpRecompensa());
                setOuro(getOuro() + mi.getOuroRecompensa());
                levelUp();
            }
        }

		while(itr.hasNext()){
			if(itr.next().getID_missao() == ID){
				itr.remove();
			}
		}
    }


	//Getters e Setters
	public ArrayList<Missao> getMissoesAtivas(){
		return missoesAtivas;
	}
}