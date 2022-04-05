package tictactoe.jeu;

import java.util.Random;

public abstract class Niveau {
    protected Random random = new Random();

    public abstract int[] getComputerCoordinate(Grille grille, String pion);
}
