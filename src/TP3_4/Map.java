package TP3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

public class Map {
    protected int[][] map;
    protected ArrayList<Artefact> artefact;

    public Map(int[][] map) {
        this.map = map;
        this.artefact = creeListeArtefact();
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
                else if (estPresentArtefact(map,i,j) != "") {
                    carte += "{" + estPresentArtefact(map, i, j) + "}";
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

    public static String estPresentAventurier(int[][] map, Equipe equipe, int i, int j) {
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

    public String estPresentArtefact(int[][] map, int i, int j) {
        char[] indice = {'a','b','c','d','e','f','g','h'};
        char longitude = indice[i];
        char latitude = indice[j];
        String res = "";

        for (Artefact a : artefact) {
            char longitude_a = a.getCoordonnees().charAt(1);
            char latitude_a = a.getCoordonnees().charAt(3);
            if (longitude == longitude_a && latitude == latitude_a) {
                if(a.getNom().equals("le lemming de vetea")) {
                    if (a.estDisponible){
                        res = "A " + map[i][j];
                    }
                }
                else if(a.getNom().equals("le grimoire des tenebres")) {
                    if (a.estDisponible){
                        res = "A " + map[i][j];
                    }
                }
                else if(a.getNom().equals("Bibelot")) {
                    if (a.estDisponible) {
                        res = "A " + map[i][j];
                    }
                }
                else if(a.getNom().equals("magic partiel")) {
                    if (a.estDisponible){
                        res = "A " + map[i][j];
                    }
                }

            }}
        return res;
    }

    public boolean estPresentUnArtefact(char i, char j) {
        char longitude = i;
        char latitude = j;
        boolean res = false;

        for (Artefact a : artefact) {
            char longitude_a = a.getCoordonnees().charAt(1);
            char latitude_a = a.getCoordonnees().charAt(3);
            if (longitude == longitude_a && latitude == latitude_a) {
                if(a.getNom().equals("le lemming de vetea")) {
                    if (a.estDisponible){
                        res = true;
                    }
                }
                else if(a.getNom().equals("le grimoire des tenebres")) {
                    if (a.estDisponible){
                        res = true;
                    }
                }
                else if(a.getNom().equals("Bibelot")) {
                    if (a.estDisponible) {
                        res = true;
                    }
                }
                else if(a.getNom().equals("magic partiel")) {
                    if (a.estDisponible){
                        res = true;
                    }
                }

            }}
        return res;
    }

    public ArrayList<Integer> PointCulminant(){
        ArrayList<Integer> point = new ArrayList<Integer>();

        for (int i=0; i<map.length; i++) {
            for (int j=0; j<map[i].length; j++) {
                if (map[i][j] == 4) {
                    point.add(i);
                    point.add(j);
                }
            }
        }
        return point;
    }

    private ArrayList<Artefact> ajoutArtefact(ArrayList<Integer> coordonneesDispo, ArrayList<Artefact> liste, Integer x, Integer y, String nom, Integer poids){
        char[] indice = {'a','b','c','d','e','f','g','h'};
        String coordArt1 = "(" + indice[coordonneesDispo.get(x)] + "," + indice[coordonneesDispo.get(y)] + ")";
        Artefact art1 = new Artefact(nom, poids, coordArt1);
        liste.add(art1);
        return liste;
    }

    public ArrayList<Artefact> creeListeArtefact(){
        ArrayList<Artefact> liste = new ArrayList<>();
        ArrayList<Integer> coordonneesDispo = PointCulminant();
        char[] indice = {'a','b','c','d','e','f','g','h'};

        liste = ajoutArtefact(coordonneesDispo, liste, 0, 1, "Bibelot", 10);
        liste = ajoutArtefact(coordonneesDispo, liste, 2, 3, "le lemming de vetea", 15);
        liste = ajoutArtefact(coordonneesDispo, liste, 4, 5, "le grimoire des tenebres", 1);
        liste = ajoutArtefact(coordonneesDispo, liste, 6, 7, "magic partiel", 5);
        return liste;
    }

}

