package tictactoe.jeu;

public class NiveauEasy extends Niveau{

    @Override
    public int[] getComputerCoordinate(Grille grille, String pion) {

        int[] coord = new int[2];

        for (int i = 0; i < 50; i++) {

            int x = super.random.nextInt(3);
            int y = super.random.nextInt(3);

            if (!grille.isNotEmpty(x + 1, y + 1)) {

                coord[0] = x + 1;
                coord[1] = y + 1;
                return coord;
            }
        }



        return grille.firstEmptyPosition();
    }
}
