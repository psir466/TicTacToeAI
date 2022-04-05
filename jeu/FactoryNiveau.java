package tictactoe.jeu;

public class FactoryNiveau {

    public static Niveau getNiveau(String type){

        if(type.equals("easy")){
            return new NiveauEasy();
        }

        if(type.equals("medium")){
            return new NiveauMedium();
        }

        if(type.equals("hard")){
            return new NiveauHard();
        }

        return null;
    }
}
