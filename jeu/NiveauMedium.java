package tictactoe.jeu;

public class NiveauMedium extends Niveau {
    @Override
    public int[] getComputerCoordinate(Grille grille, String pion) {


        int[] coord = new int[2];

        coord = grille.evaluate2InARow(pion);

        if (coord[0] != -1 && coord[1] != -1) {

            return coord;

        } else {

            String pionAdv = "X";

            if (pion.equals("X")) {
                pionAdv = "O";
            }

            coord = grille.evaluate2InARow(pionAdv);

            if (coord[0] != -1 && coord[1] != -1) {

                return coord;

            } else {

                for (int i = 0; i < 50; i++) {

                    int x = super.random.nextInt(3);
                    int y = super.random.nextInt(3);

                    if (!grille.isNotEmpty(x + 1, y + 1)) {

                        coord[0] = x + 1;
                        coord[1] = y + 1;
                        return coord;
                    }
                }
            }

        }

        return grille.firstEmptyPosition();

    }
}
