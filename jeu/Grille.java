package tictactoe.jeu;

import java.util.Arrays;

public class Grille {

    private String[][] tab = new String[3][3];


    public String[][] getTab() {
        return tab;
    }

    private void setTab(String[][] tab) {
        this.tab = tab;
    }

    public boolean isNotEmpty(int x, int y) {

        int xArr = x - 1;
        int yArr = y - 1;

        if (!this.tab[xArr][yArr].equals("_")) {

            return true;
        }

        return false;
    }

    public void initGrille(String ligne) {

        int n = 0;
        int i = 0;
        int j = 0;

        for (Character c : ligne.toCharArray()) {

            if (n >= 3) {
                n = 0;
                j = 0;
                i++;
            }


            this.tab[i][j] = c.toString();


            j++;
            n++;
        }
    }

    public void placerPion(int x, int y, String pion) {

        int xArr = x - 1;
        int yArr = y - 1;

        this.tab[xArr][yArr] = pion;

    }

    public String grilleToString() {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < tab.length; i++) {

            for (int j = 0; j < tab.length; j++) {


                sb.append(tab[i][j]);
            }

        }

        return sb.toString();

    }

    public boolean evaluatePion(String pion) {

        int n = 0;

        for (int i = 0; i < tab.length; i++) {

            n = 0;

            for (int j = 0; j < tab.length; j++) {

                if (!tab[i][j].equals(pion)) {
                    break;
                } else {
                    n++;
                    if (n == tab.length) {
                        return true;
                    }
                }
            }

        }

        for (int j = 0; j < tab.length; j++) {

            n = 0;

            for (int i = 0; i < tab.length; i++) {

                if (!tab[i][j].equals(pion)) {
                    break;
                } else {
                    n++;
                    if (n == tab.length) {
                        return true;
                    }
                }
            }

        }

        n = 0;
        for (int i = 0; i < tab.length; i++) {

            if (!tab[i][i].equals(pion)) {
                break;
            } else {
                n++;
                if (n == tab.length) {
                    return true;
                }
            }

        }

        n = 0;
        for (int i = 0; i < tab.length; i++) {

            int j = (tab.length - 1) - i;

            if (!tab[i][j].equals(pion)) {
                break;
            } else {
                n++;
                if (n == tab.length) {
                    return true;
                }
            }

        }

        return false;
    }

    public int[] evaluate2InARow(String pion) {

        int[] ret = new int[2];
        ret[0] = -1;
        ret[1] = -1;

        String[] ev = new String[tab.length];

        for (int i = 0; i < tab.length; i++) {

            Arrays.fill(ev, " ");

            for (int j = 0; j < tab.length; j++) {

                ev[j] = tab[i][j];
            }

            int n = 0;
            int m = -1;

            for (int k = 0; k < ev.length; k++) {
                if (ev[k].equals(pion)) {
                    n++;
                }
                if (ev[k].equals("_")) {
                    m = k;
                }
            }

            if (n == tab.length - 1 && m != -1) {
                ret[0] = i + 1;
                ret[1] = m + 1;
                return ret;
            }

        }

        for (int j = 0; j < tab.length; j++) {

            Arrays.fill(ev, " ");

            for (int i = 0; i < tab.length; i++) {

                ev[i] = tab[i][j];
            }

            int n = 0;
            int m = -1;

            for (int k = 0; k < ev.length; k++) {
                if (ev[k].equals(pion)) {
                    n++;
                }
                if (ev[k].equals("_")) {
                    m = k;
                }
            }

            if (n == tab.length - 1 && m != -1) {
                ret[0] = m + 1;
                ret[1] = j + 1;
                return ret;
            }

        }

        Arrays.fill(ev, " ");

        for (int i = 0; i < tab.length; i++) {

            ev[i] = tab[i][i];

        }

        int n = 0;
        int m = -1;

        for (int k = 0; k < ev.length; k++) {
            if (ev[k].equals(pion)) {
                n++;
            }
            if (ev[k].equals("_")) {
                m = k;
            }
        }

        if (n == tab.length - 1 && m != -1) {
            ret[0] = m+1;
            ret[1] = m+1;
            return ret;
        }


        Arrays.fill(ev, " ");

        for (int i = 0; i < tab.length; i++) {

            int j = (tab.length - 1) - i;

            ev[i] = tab[i][j];

        }


         n = 0;
         m = -1;

        for (int k = 0; k < ev.length; k++) {
            if (ev[k].equals(pion)) {
                n++;
            }
            if (ev[k].equals("_")) {
                m = k;
            }
        }

        if (n == tab.length - 1 && m != -1) {
            ret[0] = m + 1;
            ret[1] = (tab.length - 1) - m + 1;
            return ret;
        }

        return ret;
    }

    public boolean isFull(){

        String ligne = this.grilleToString();

        Character[] charObjectArray =
                ligne.chars().mapToObj(c -> (char) c).toArray(Character[]::new);

        long count = Arrays.stream(charObjectArray).filter(c -> c == '_').count();


        if (count == 0) {
            return true;
        }
        return false;
    }

    public int [] firstEmptyPosition(){

        int[] coord = null;

        for(int i = 0; i < tab.length; i++){

            for(int j = 0; j < tab.length; j++){

                if(tab[i][j].equals("_")){

                    coord[0] = i;
                    coord[1] = j;
                    return coord;

                }

            }

        }

        return coord;
    }

    public Grille copyGrille(){

        Grille newGrille = new Grille();

        for (int i = 0; i < this.tab.length; i++) {

            for (int j = 0; j < this.tab.length; j++) {

               newGrille.tab[i][j] = tab[i][j];
            }
        }

        return newGrille;

    }


}
