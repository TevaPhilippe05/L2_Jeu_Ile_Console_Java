package TP3_4;

import java.util.ArrayList;


public class Equipe{
    private int nbAventurier;
    protected ArrayList<Aventurier> aventurier;

    public Equipe() {
        this.nbAventurier = 0;
        this.aventurier = new ArrayList<Aventurier>();
    }

    public void afficheAventuriers() {
        for (Aventurier elem: aventurier) {
            System.out.println(elem.nom);
        }
    }

    public void ajouter(Aventurier aventurier) {
        this.aventurier.add(aventurier);
        this.nbAventurier += 1;
    }

    public void supprimer(Aventurier aventurier) {
        this.aventurier.remove(aventurier);
        this.nbAventurier -= 1;
    }

    public boolean estComplete() {
        return nbAventurier ==3;
    }

    public boolean estDedans(Aventurier a) {
        return aventurier.contains(a);
    }

    public Aventurier renvoisAventurier(String nom) {
        Aventurier reponse = null;
        for (Aventurier elem: aventurier) {
            if (elem.nom.equals(nom)) {
                reponse = elem;
            }
        }
        return reponse;
    }

    public void texteEquipeComplete() {
        if (nbAventurier == 3) {
            System.out.println("L'�quipe est compl�te");
        }
        else {
            System.out.println("L'�quipe n'est pas compl�te");
        }
    }

    public boolean verifieRoleEquipe() {
        boolean estPorteur = false;
        boolean estGrimpeur = false;
        boolean estExplorateur = false;

        for (Aventurier elem : aventurier) {
            if ( elem.role == "Porteur") {
                estPorteur = true;
            }
            if ( elem.role == "Grimpeur") {
                estGrimpeur = true;
            }
            if ( elem.role == "Explorateur") {
                estExplorateur = true;
            }
        }
        return estExplorateur && estGrimpeur && estPorteur;
    }

    public boolean roleDejaPresent(String role) {
        boolean res = false;

        for(Aventurier elem: aventurier) {
            if (elem.role.equals(role)) {
                res = true;
            }
        }
        return res;
    }

    public int getNbAventurier(){
        return nbAventurier;
    }


}
