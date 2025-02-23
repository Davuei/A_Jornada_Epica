import java.util.ArrayList;
import java.util.List;

public class Mundo {
    private List<Monstro> monstros;
    private List<Missao> missoes;

    public Mundo() {
        this.monstros = new ArrayList<>();
        this.missoes = new ArrayList<>();
    }

    public void adicionarMonstro(Monstro monstro) {
        monstros.add(monstro);
    }

    public void adicionarMissao(Missao missao) {
        missoes.add(missao);
    }

    public void listarMissoes() {
        System.out.println("Missões disponíveis:");
        for (Missao missao : missoes) {
            System.out.println("- " + missao.getDescricao() + (missao.isConcluida() ? " (Concluída)" : " (Pendente)"));
        }
    }

    public void listarMonstros() {
        System.out.println("Monstros no mundo:");
        for (Monstro monstro : monstros) {
            System.out.println(monstro);
        }
    }
}