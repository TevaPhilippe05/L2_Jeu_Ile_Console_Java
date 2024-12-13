package TP3_4;

//import java.util.ArrayList;
import java.util.Random;

public class Artefact {
    private int poids;
    private String nom;
    private String coordonnees;
    private boolean estDisponible;

    public Artefact(String nom, int poids) {
        this.nom=nom;
        this.poids = poids;
        this.coordonnees = coordonneesAleatoire();
        this.estDisponible = true;
    }

    public String coordonneesAleatoire() {
        Random rand = new Random();
        char longitude = (char)(rand.nextInt(8) + 97);
        char latitude = (char)(rand.nextInt(8) + 97);

        return"("+longitude+","+latitude+")";
    }



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


//todo :  + Coordonnee aleatoire pour aventurier +modifier dans
//artefct list plutot que tableau et m�thode qui rnevois une liste d'artefacts.