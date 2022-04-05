package tictactoe.controller;

import tictactoe.jeu.*;
import tictactoe.vue.Ivue;
import tictactoe.vue.Vue;

import java.util.Arrays;

public class DeroulementPartie {

    private static Partie partie = new Partie();

    private static Ivue vue = new Vue();

    private static String gameState = "START";


    public static void run() {

        while (true) {

            while (gameState.equals("START")) {

                initStart();

            }

            if(gameState.equals("END")){
                break;
            }


            while (gameState.equals("INIT")) {
                initJeu();
                displayGrille();
            }


            gameJoueur(partie.getJoueur1());

            if(gameState.equals("END")){
                break;
            }

            gameJoueur(partie.getJoueur2());

            if(gameState.equals("END")){
                break;
            }

            gameState = "COORD";
        }

    }

    private static void gameJoueur(Joueur joueur){

        if(joueur.getType().equals("user")) {
            while (gameState.equals("COORD")) {
                enterCoordinate(joueur);
            }
        }else{

            computerEnterCoordinate((JoueurComputer) joueur);
        }

        if(!gameState.equals("END")) {
            displayGrille();

            evaluateGame();
        }

    }

    private static void computerEnterCoordinate(JoueurComputer joueur) {

        vue.displayMessage("Making move level \""+ joueur.getType() +"\"");

        String pion = joueur.getPion();

        int[] coordComputer = joueur.getNiveau().getComputerCoordinate(partie.getGrille(), joueur.getPion());

        partie.getGrille().placerPion(coordComputer[0], coordComputer[1], pion);

    }

    private static void evaluateGame() {

        if (partie.getRegles().checkGame("X")) {
            vue.displayMessage("X wins");
            gameState = "END";
            return;
        }

        if (partie.getRegles().checkGame("O")) {
            vue.displayMessage("O wins");
            gameState = "END";
            return;
        }

        if (partie.getRegles().draw()) {
            vue.displayMessage("Draw");
            gameState = "END";
            return;
        }

        gameState = "COORD";

        return;

    }

    private static void udpdateGrille(int x, int y, Joueur joueur) {

        String pion = joueur.getPion();

        partie.getGrille().placerPion(x, y, pion);
    }

    private static void displayGrille() {

        vue.displayGrille(partie.getGrille().getTab());

    }

    public static void initStart(){

        vue.start();
    }

    public static void initJeu() {


        String ligne = "_________";
        partie.getGrille().initGrille(ligne);
        gameState = "COORD";

    }

    public static void creerJeu(String ligne) throws Exception {

        try {
            partie.getRegles().checkLigne(ligne);
            partie.getGrille().initGrille(ligne);
            gameState = "COORD";
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }

    }

    private static void enterCoordinate(Joueur joueur) {

        vue.enterCoordinate(joueur);
    }

    public static void managmtCoordinate(String ligne, Joueur joueur) throws Exception {

        if(!ligne.equals("exit")) {
            String[] tab = ligne.split(" ");

            if (tab.length != 2) {

                throw new Exception("You should enter numbers!");
            }

            try {
                partie.getRegles().checkcoord(tab[0], tab[1]);
                udpdateGrille(Integer.parseInt(tab[0]), Integer.parseInt(tab[1]), joueur);
                gameState = "SUIVANT";
            } catch (Exception e) {

                throw new Exception(e.getMessage());

            }
        }else{

            gameState = "END";
        }
    }


    public static void managmtStart(String ligne) throws Exception {

        if(!ligne.equals("exit")) {
            String[] tab = ligne.split(" ");

            if (tab.length != 3 || !tab[0].equals("start")) {
                throw new Exception("Bad parameters!");
            }

            if (!isInGameLevel(tab[1])) {

                if (!tab[1].equals("user")) {
                    throw new Exception("Bad parameters!");

                }
            }

            if (!isInGameLevel(tab[2])) {

                if (!tab[2].equals("user")) {
                    throw new Exception("Bad parameters!");

                }
            }

            if(isInGameLevel(tab[1])){
                partie.setJoueur1(new JoueurComputer(tab[1], "X", FactoryNiveau.getNiveau(tab[1])));
            }else {
                partie.setJoueur1(new Joueur(tab[1], "X"));
            }

            if(isInGameLevel(tab[2])){
                partie.setJoueur2(new JoueurComputer(tab[2], "O", FactoryNiveau.getNiveau(tab[2])));
            }else {
                partie.setJoueur2(new Joueur(tab[2], "O"));
            }

            gameState = "INIT";
        }else{

            gameState = "END";
        }


    }

    private static boolean isInGameLevel(String level){

        long count = Arrays.stream(LevelGame.values()).filter(l -> l.toString().equals(level)).count();

        if(count == 0){

            return false;
        }

        return true;
    }
}
