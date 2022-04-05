package tictactoe.jeu;

public class Joueur {

    private String type;
    private String pion;


    public Joueur(String type, String pion) {
        this.type = type;
        this.pion = pion;

    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPion() {
        return pion;
    }

    public void setPion(String pion) {
        this.pion = pion;
    }


}
