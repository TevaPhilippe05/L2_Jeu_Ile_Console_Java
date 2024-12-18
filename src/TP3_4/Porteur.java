package TP3_4;

import in.keyboard.Keyboard;

public class Porteur extends Aventurier {
    private int nbCaseAccessible = 1;
    private int differentiel = 1;
    private int nbArtefactMax = 2;

    public Porteur(String nom) {
        super(nom, "Porteur", "(c,a)") ;
    }

    @Override
    public void recupArtefact(Map map){
        String res = "";
        if (artefact.size() < nbArtefactMax && map.estPresentUnArtefact(coordonnees.charAt(1), coordonnees.charAt(3))){
            for (Artefact art : map.artefact){
                System.out.println(art.getCoordonnees().charAt(1));
                System.out.println(coordonnees.charAt(1));
                if (art.getCoordonnees().charAt(1) == coordonnees.charAt(1) && art.getCoordonnees().charAt(3) == coordonnees.charAt(3) && art.estDisponible){
                    artefact.add(art);
                    art.estDisponible = false;
                }
            }
        }
        else {
            System.out.println("Vous n'etes pas sur un artefact");
        }
    };

    @Override
    public void seDeplacer(Map map){
        char[] indice = {'a','b','c','d','e','f','g','h'};
        int y = 0;
        int x = 0;

        for (int i=0; i < 8; i++) {
            if (indice[i] == coordonnees.charAt(1)){
                x = i;
            }
        }
        for (int j=0; j < 8; j++) {
            if (indice[j] == coordonnees.charAt(3)){
                y = j;
            }
        }

        int h = map.map[x][y];

        System.out.println("Entrez \n n : aller au nord \n s : aller au sud \n o : aller a l'ouest \n e : aller a l'est \n");
        char mouv = Keyboard.getChar();
        if (mouv == 'n'){

            if (x != 0){

                if ((map.map[x-1][y] >= h - 1) && (map.map[x-1][y] <= h + 1)){
                    x -= 1;
                }
            }

        } else if (mouv == 's'){
            if (x != 7){
                if ((map.map[x+1][y] >= h - 1) && (map.map[x+1][y] <= h + 1)){
                    x += 1;
                }
            }
        } else if (mouv == 'o'){
            if (y != 0){
                if ((map.map[x][y-1] >= h - 1) && (map.map[x][y-1] <= h + 1)){
                    y -= 1;
                }
            }
        } else if (mouv == 'e'){
            if (y != 7){
                if ((map.map[x][y+1] >= h - 1) && (map.map[x][y+1] <= h + 1)){
                    y += 1;
                }
            }
        } else {
            System.out.println("Vous vous êtes trompé, votre tour est sauté. Hum. Dommage.  :) ");
        }
        coordonnees = "(" + indice[x] + "," + indice[y] + ")";

    }

}
