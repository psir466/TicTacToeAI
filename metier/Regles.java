package tictactoe.metier;

import tictactoe.jeu.Grille;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.Callable;

public class Regles {

    protected Grille grille;
    protected Set<Character> setCheck = new HashSet<>();

    public Regles(Grille grille) {
        this.grille = grille;
    }

    public Grille getGrille() {
        return grille;
    }

    public void setGrille(Grille grille) {
        this.grille = grille;
    }


    public void checkLigne(String ligne) throws Exception {

        if (ligne.length() != 9) {

            throw new Exception("pas 9");

        }

        setCheck.clear();

        for (Character c : ligne.toCharArray()) {

            setCheck.add(c);

        }

        for (Character c : setCheck) {

            if (c != 'X' && c != 'O' && c != '_') {

                throw new Exception("pas bon char");

            }
        }

    }

    public void checkcoord(String x, String y) throws Exception {


        int xInt = 0;
        int yInt = 0;

        try {

            xInt = Integer.parseInt(x);
            yInt = Integer.parseInt(y);

        } catch (Exception e) {

            throw new Exception("You should enter numbers!");
        }

        if (xInt < 1 || xInt > 3 || yInt < 1 || yInt > 3) {

            throw new Exception("Coordinates should be from 1 to 3!");

        }

        if (nonEmpty(xInt, yInt)) {
            throw new Exception("This cell is occupied! Choose another one!");
        }


    }

    protected boolean nonEmpty(int x, int y) {

        return this.grille.isNotEmpty(x, y);
    }

    public String pionChoice() {

        String ligne = this.grille.grilleToString();

        Character[] charObjectArray =
                ligne.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        long xCount = Arrays.stream(charObjectArray).filter(c -> c == 'X').count();

        long oCount = Arrays.stream(charObjectArray).filter(c -> c == 'O').count();

        if (oCount >= xCount) {
            return "X";
        }

        return "O";

    }

    public Boolean checkGame(String pion) {

        return this.grille.evaluatePion(pion);

    }

    public boolean draw() {

        return this.grille.isFull();
    }



}
