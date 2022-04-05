package tictactoe.jeu;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Optional;

public class NiveauHard extends Niveau {

    @Override
    public int[] getComputerCoordinate(Grille grille, String pion) {

        String pionJoueur = pion;



        String[][] tab = grille.getTab();

        ArrayList<Position> arrayPos = new ArrayList<>();

        for (int i = 0; i < tab.length; i++) {

            for (int j = 0; j < tab.length; j++) {

                if (tab[i][j].equals("_")) {
                    Grille newGrille = grille.copyGrille();

                    newGrille.placerPion(i + 1, j + 1, pion);
                    int score = miniMax(newGrille, pion, pionJoueur);
                    Position p = new Position(i + 1, j + 1, score);
                    arrayPos.add(p);
                }
            }
        }

        Optional<Position> p = null;

        p = arrayPos.stream().max(Comparator.comparingInt(p2 -> p2.score));

        if (p.isPresent()) {

       //     for (Position position : arrayPos) {
       //         System.out.println("x : " + position.getI() + " y: " + position.getJ() + " score: " + position.getScore());
       //     }

            return new int[] {p.get().getI(), p.get().getJ()};

        }

        return null;
    }

    // pionJoueur c'est celui qui joue effectivement
    private int miniMax(Grille grille, String pion, String pionJoueur) {

        if (grille.evaluatePion(pion)) {
            if (pion.equals(pionJoueur)) {
                return 1;
            } else {
                return -1;
            }
        }

        if (grille.isFull()) {
            return 0;
        }

        // on scroll les places libres de la grille
        String[][] tab = grille.getTab();

        // on met le pion du joueur suivant
        String newPion = "X";
        if (pion.equals("X")) {
            newPion = "O";
        }


        ArrayList<Position> arrayPos = new ArrayList<>();

        for (int i = 0; i < tab.length; i++) {

            for (int j = 0; j < tab.length; j++) {

                if (tab[i][j].equals("_")) {
                    Grille newGrille = grille.copyGrille();

                    newGrille.placerPion(i + 1, j + 1, newPion);
                    int score = miniMax(newGrille, newPion, pionJoueur);
                    Position p = new Position(i + 1, j + 1, score);
                    arrayPos.add(p);
                }
            }
        }

        Optional<Position> p = null;

        if (newPion.equals(pionJoueur)) {
            p = arrayPos.stream().max(Comparator.comparingInt(p2 -> p2.score));
        } else {
            p = arrayPos.stream().min(Comparator.comparingInt(p2 -> p2.score));
        }


        if (p.isPresent()) {

            return p.get().getScore();

        }


        return 0;
    }



}
