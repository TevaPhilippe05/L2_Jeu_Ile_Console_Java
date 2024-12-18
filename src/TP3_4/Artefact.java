package TP3_4;

//import java.util.ArrayList;
import java.util.Random;

public class Artefact {
    private int poids;
    private String nom;
    private String coordonnees;
    protected boolean estDisponible;

    public Artefact(String nom, int poids, String coordonnee) {
        this.nom = nom;
        this.poids = poids;
        this.coordonnees = coordonnee;
        this.estDisponible = true;
    }

    // Pas possible car il faut prendre en compte la map.
    /*public String coordonneesAleatoire() {
        Random rand = new Random();
        char longitude = (char)(rand.nextInt(8) + 97);
        char latitude = (char)(rand.nextInt(8) + 97);

        return"("+longitude+","+latitude+")";
    }*/

    public String getCoordonnees() {
        return coordonnees;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return "nom: " + nom + " ,poids: "+ poids + " ,coordonnees: " + coordonnees + " ,est disponible: " + estDisponible;
    }
}


//todo :  + Coordonnee aleatoire pour aventurier + modifier dans
//artefact list plutôt que tableau et m�thode qui rnevois une liste d'artefacts.