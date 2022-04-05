package tictactoe.jeu;

public class JoueurComputer extends Joueur {

    private Niveau niveau;

    public JoueurComputer(String type, String pion, Niveau niveau) {
        super(type, pion);
        this.niveau = niveau;
    }

    public Niveau getNiveau() {
        return niveau;
    }

    public void setNiveau(Niveau niveau) {
        this.niveau = niveau;
    }
}
