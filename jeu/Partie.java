package tictactoe.jeu;


import tictactoe.metier.Regles;

public class Partie {

    private Grille grille;
    private Joueur joueur1;
    private Joueur joueur2;
    private Regles regles;

    public Partie(){

        this.grille = new Grille();
        this.regles = new Regles(this.grille);
    }


    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }

    public Joueur getJoueur1() {
        return joueur1;
    }

    public void setJoueur1(Joueur joueur1) {
        this.joueur1 = joueur1;
    }

    public Joueur getJoueur2() {
        return joueur2;
    }

    public void setJoueur2(Joueur joueur2) {
        this.joueur2 = joueur2;
    }

    public Regles getRegles() {

        return this.regles;
    }
}
