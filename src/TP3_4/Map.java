package TP3_4;

import java.util.ArrayList;

public class Map {
    private int[][] map;
    private ArrayList<Artefact> artefact;


    public Map(int[][] map) {
        this.map = map;
    }

    public String afficherMap(Equipe equipe) {
        String carte = "    a    b    c    d    e    f    g    h \n";
        String[] indice = {"a ", "b ", "c ", "d ", "e ", "f ", "g ", "h "};
        for (int i=0; i<map.length; i++) {
            carte += indice[i];
            for (int j=0; j<map[i].length; j++) {
                if (estPresentAventurier(map, equipe, i, j) != "") {
                    carte += "{ " + estPresentAventurier(map, equipe, i, j) + " }";
                }
                else if (estPresentArtefact(map)) {
                    // TODO
                }
                else if (map[i][j] == 0) {
                    carte += "{   }";
                }
                else {
                    carte += "{ " + map[i][j] + " }";
                }

            }
            carte += "\n";
        }
        return carte;
    }

    public String estPresentAventurier(int[][] map, Equipe equipe, int i, int j) {
        char[] indice = {'a','b','c','d','e','f','g','h'};
        char longitude = indice[i];
        char latitude = indice[j];
        String res = "";

        for (Aventurier aventuriers : equipe.aventurier) {
            char longitude_a = aventuriers.coordonnees.charAt(1);
            char latitude_a = aventuriers.coordonnees.charAt(3);
            if (longitude == longitude_a && latitude == latitude_a) {
                if (aventuriers.role == "Grimpeur") {
                    res = "G";
                }
                else if (aventuriers.role == "Porteur") {
                    res = "P";
                }
                else if (aventuriers.role == "Explorateur") {
                    res = "E";
                }
            }
        }
        return res;
    }

    public boolean estPresentArtefact(int[][] elem) {
        // TODO
        return false;
    }
}
