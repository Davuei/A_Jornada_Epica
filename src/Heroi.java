public class Heroi {
    private String nome;
    private String classe;
    private int nivel;
    private int magia;
    private double vida;
    private char genero;
    private String raca;
    private double forca;
    private double defesa;

    // Construtor 
    public Heroi(String nome, double vida, char genero, String raca, double forca, double defesa, String classe, int nivel, int magia) {
        this.nome = nome;
        this.vida = vida;
        this.classe = classe;
        this.nivel = nivel;
        this.magia = magia;
        this.genero = genero;
        this.raca = raca;
        this.forca = forca;
        this.defesa = defesa;
    }

    // Getters e Setters
    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }

    public int getMagia() { return magia; }
    public void setMagia(int magia) { this.magia = magia; }

    public int getNivel() { return nivel; }
    public void setNivel(int nivel) { this.nivel = nivel; }

    public String getRaca() { return raca; }
    public void setRaca(String raca) { this.raca = raca; }

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getVida() { return vida; }
    public void setVida(double vida) { this.vida = vida; }

    public char getGenero() { return genero; }
    public void setGenero(char genero) { this.genero = genero; }

    public double getForca() { return forca; }
    public void setForca(double forca) { this.forca = forca; }

    public double getDefesa() { return defesa; }
    public void setDefesa(double defesa) { this.defesa = defesa; }

 public String toString() {
        return "Herói: " + nome + "\nClasse: " + classe + "\nNível: " + nivel + "\nMagia: " + magia +
               "\nVida: " + vida + "\nGênero: " + genero + "\nRaça: " + raca +
               "\nForça: " + forca + "\nDefesa: " + defesa;
    }

// Método para receber dano
      public void receberDano(double dano) {
        double danoFinal = dano - defesa;
        if (danoFinal < 0) danoFinal = 0;
        this.vida -= danoFinal;
        if (this.vida < 0) this.vida = 0; // vida nao negativa;
    }

   public void atacar(Heroi inimigo) {
        System.out.println(this.nome + " ataca " + inimigo.getNome() + " causando " + this.forca + " de dano!");
        inimigo.receberDano(this.forca);
    }

    public void curar(double quantidade) {
        this.vida += quantidade;
        System.out.println(this.nome + " foi curado e agora tem " + this.vida + " de vida!");
    }

}
