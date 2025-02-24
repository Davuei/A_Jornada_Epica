public class Missao {
    private String descricao;
    private boolean concluida;
    private int nivelRequerido; //  missão exige nível 5+
    private String monstroAlvo; // "Dragão Negro"

    public Missao(String descricao, int nivelRequerido, String monstroAlvo) {
        this.descricao = descricao;
        this.concluida = false;
        this.nivelRequerido = nivelRequerido;
        this.monstroAlvo = monstroAlvo;
    }

    public String getDescricao() { return descricao; }

    public boolean isConcluida() { return concluida; }

    public void verificarConclusao(Heroi heroi, Monstro monstro) {
        if (heroi.getNivel() >= nivelRequerido && monstro.getVida() <= 0) {
            this.concluida = true;
            System.out.println("Missão '" + descricao + "' concluída!");
        } else {
            System.out.println("Missão ainda não concluída! Requisitos: ");
            System.out.println("- Nível necessário: " + nivelRequerido + " (Seu nível: " + heroi.getNivel() + ")");
            System.out.println("- Derrotar: " + monstroAlvo + " (Vida do monstro: " + monstro.getVida() + ")");
        }
    }
}