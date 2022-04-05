package tictactoe.vue;

import tictactoe.controller.DeroulementPartie;
import tictactoe.jeu.Joueur;

import java.util.Scanner;

public class Vue implements Ivue{

    private static Scanner scanner = new Scanner(System.in);

    @Override
    public void enterTheCells() {
        System.out.println("Enter the cells:");

        String ligne = scanner.nextLine();

        try {
            DeroulementPartie.creerJeu(ligne);
        } catch (Exception e) {
            this.displayMessage(e.getMessage());
        }

    }

    @Override
    public void enterCoordinate(Joueur joueur) {

        System.out.println("Enter the coordinates:");

        String ligne = scanner.nextLine();

        try {
            DeroulementPartie.managmtCoordinate(ligne, joueur);
        } catch (Exception e) {

            this.displayMessage(e.getMessage());
        }

    }


    @Override
    public void displayMessage(String message) {

        System.out.println(message);
    }

    @Override
    public void displayGrille(String[][] tab) {

        StringBuilder sb = new StringBuilder();

        System.out.println("---------");

        for(int i = 0; i < tab.length; i++){

            sb.delete(0, sb.length());

            sb.append("| ");

            for (int j = 0; j < tab.length; j++){

                String str = tab[i][j];

                if(str.equals("_")){
                    str = " ";
                }

                sb.append(str + " ");
            }

            sb.append("|");

            System.out.println(sb.toString());
        }

        System.out.println("---------");
    }

    @Override
    public void start() {

        String ligne = scanner.nextLine();

        try {
            DeroulementPartie.managmtStart(ligne);
        } catch (Exception e) {
            this.displayMessage(e.getMessage());
        }

    }


}
