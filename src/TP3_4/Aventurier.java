package TP3_4;

//import in.keyboard.Keyboard;

import java.util.ArrayList;

public abstract class Aventurier {
    protected String nom;
    protected String coordonnees;
    protected ArrayList<Artefact> artefact;
    protected String role;

    public Aventurier(String nom, String role, String coordonnees) {
        this.nom = nom;
        this.coordonnees = coordonnees;
        this.role = role;
        this.artefact = new ArrayList<Artefact>();
    }

    public abstract void seDeplacer(Map map);

    public abstract void recupArtefact(Map map);
}
