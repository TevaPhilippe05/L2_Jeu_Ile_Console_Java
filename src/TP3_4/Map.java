package TP3_4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;


public class Map {
    private int[][] map;
    //private ArrayList<Artefact> artefact;


    public Map(int[][] map) {
        this.map = map;
        //this.artefact = listArtefact();
    }

    public String afficherMap(Equipe equipe) {
        String carte = "    a    b    c    d    e    f    g    h \n";
        String[] indice = {"a ", "b ", "c ", "d ", "e ", "f ", "g ", "h "};
        ArrayList<Artefact> artefact =  listArtefact(map);
        for (int i=0; i<map.length; i++) {
            carte += indice[i];
            for (int j=0; j<map[i].length; j++) {
                if (estPresentAventurier(map, equipe, i, j) != "") {
                    carte += "{ " + estPresentAventurier(map, equipe, i, j) + " }";
                }
                else if (estPresentArtefact(map,i,j,artefact) != "") {
                    carte += "{" + estPresentArtefact(map, i, j, artefact) + "}";
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

    public static String estPresentArtefact(int[][] map, int i, int j, ArrayList<Artefact> artefact) {
        char[] indice = {'a','b','c','d','e','f','g','h'};
        char longitude = indice[i];
        char latitude = indice[j];
        String res = "";

        for (Artefact a : artefact) {
            char longitude_a = a.getCoordonnees().charAt(1);
            char latitude_a = a.getCoordonnees().charAt(3);
            if (longitude == longitude_a && latitude == latitude_a) {
                if(a.getNom() == "le lemming de vetea") {
                    res = "("+map[i][j]+")";;
                }
                else if(a.getNom() == "le grimoire des tenebres") {
                    res = "("+map[i][j]+")";;
                }
            }}
        return res;
    }

    public static ArrayList<Integer> PointCulminant(int[][] map){
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


    public static ArrayList<Artefact> listArtefact(int[][] map){
        ArrayList<Artefact> lst = new ArrayList<Artefact>();

        Artefact a1 = new  Artefact("le lemming de vetea",15);
        Artefact a2 = new Artefact("le grimoire des tenebres",1);

        ArrayList<Integer> coordPossible = PointCulminant(map);

        char[] indice = {'a','b','c','d','e','f','g','h'};
        int longitudeA1 = 0;
        int latitudeA1 = 0;
        int longitudeA2 = 0;
        int latitudeA2 = 0;


        for(int i=0; i<indice.length; i++) {
            if (a1.getCoordonnees().charAt(1) == indice[i]) {
                longitudeA1 = i;
            }else if (a1.getCoordonnees().charAt(3) == indice[i]) {
                latitudeA1 = i;
            }else if (a2.getCoordonnees().charAt(1) == indice[i]) {
                longitudeA2 = i;
            }else if (a2.getCoordonnees().charAt(3) == indice[i]) {
                latitudeA2 = i;
            }
        }
        System.out.println(longitudeA1);
        System.out.println(latitudeA1);
        System.out.println(longitudeA2);
        System.out.println(latitudeA2);

        for (int k=0; k<coordPossible.size(); k+=2) {
            if ( coordPossible.get(k) == longitudeA1 && coordPossible.get(k+1) == latitudeA1) {
                lst.add(a1);
                k+=2;
            }
            if ( coordPossible.get(k) == longitudeA2 && coordPossible.get(k+1) == latitudeA2) {
                lst.add(a2);
                k+=2;
            }

        }
        return lst;
    }
}

