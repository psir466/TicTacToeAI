package tictactoe.vue;

import tictactoe.jeu.Joueur;

public interface Ivue {


    void enterTheCells();

    void enterCoordinate(Joueur joueur);

    void displayMessage(String message);

    void displayGrille(String[][] tab);

    void start();
}
