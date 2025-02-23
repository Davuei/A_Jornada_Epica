public class Main {
    public static void main(String[] args) {
        Heroi heroi = new Heroi("Arthur", 100, 'M', "Humano", 20, 5, "Guerreiro", 1, 10);
        Monstro monstro = new Monstro("Dragão Negro", 150, 'M', "Dragão", 25, 10, "Mágico", 5, 20, "Dragão", 1.5);
        
        Missao missao1 = new Missao("Derrotar o Dragão Negro");
        
        Mundo mundo = new Mundo();
        mundo.adicionarMonstro(monstro);
        mundo.adicionarMissao(missao1);

        System.out.println(heroi);
        System.out.println(monstro);

        mundo.listarMissoes();
        mundo.listarMonstros();

        monstro.atacar(heroi);
        System.out.println(heroi);

        missao1.completarMissao();
        mundo.listarMissoes();
    }
}