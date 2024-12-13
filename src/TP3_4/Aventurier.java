package TP3_4;

//import in.keyboard.Keyboard;

public abstract class Aventurier {
    protected String nom;
    protected String coordonnees;
    //private int nbArtefact;
    protected String role;

    public Aventurier(String nom, String role, String coordonnees) {
        this.nom = nom;
        this.coordonnees = coordonnees;
        this.role = role;
        //this.nbArtefact = 0;
    }


}
