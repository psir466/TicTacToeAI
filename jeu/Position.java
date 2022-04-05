package tictactoe.jeu;

public class Position{

    int i;

    int j;

    int score;

    public Position(int i, int j, int score) {
        this.i = i;
        this.j = j;
        this.score = score;
    }

    public int getI() {
        return i;
    }

    public int getScore() {
        return score;
    }

    public int getJ() {
        return j;
    }
}
