public class Monstro extends Heroi {
    private String tipo; // Exemplo: "Mágico"
    private double multiplicadorAtaque;


      public Monstro(String nome, double vida, char genero, String raca, double forca, double defesa, String tipo, double multiplicadorAtaque) {
        super(nome, vida, genero, raca, forca, defesa); // Chama o construtor da classe Heroi
        this.tipo = tipo;
        this.multiplicadorAtaque = multiplicadorAtaque;
    }

     // Getters e Setters
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public double getMultiplicadorAtaque() {
        return multiplicadorAtaque;
    }

    public void setMultiplicadorAtaque(double multiplicadorAtaque) {
        this.multiplicadorAtaque = multiplicadorAtaque;
    }

    @Override //Garante polimorfismo: Permite que a subclasse forneça uma implementação diferente do método herdado.
    public void atacar(Heroi inimigo) {
        double dano = this.getForca() * multiplicadorAtaque;
        System.out.println(this.getNome() + " (" + this.tipo + ") ataca " + inimigo.getNome() + " causando " + dano + " de dano!");
        inimigo.receberDano(dano);
    }

    @Override //Garante polimorfismo: Permite que a subclasse forneça uma implementação diferente do método herdado.
    public String toString() {
        return super.toString() + "\nTipo: " + tipo + "\nMultiplicador de Ataque: " + multiplicadorAtaque;
    }
}