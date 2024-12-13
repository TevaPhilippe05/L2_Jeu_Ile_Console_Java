package TP3_4;
//import java.util.ArrayList;

import java.util.ArrayList;

import in.keyboard.Keyboard;


public class Main {

    public static void main(String[] args) {
        int[][] map1 = {{0,0,3,0,4,2,2,0},{3,2,1,2,3,2,1,1},{4,1,3,4,3,4,1,2},{0,0,2,4,3,2,1,0},{1,0,1,2,3,4,2,1},{1,1,0,0,4,3,3,0},{1,2,3,0,0,4,2,1},{0,3,0,0,4,4,3,4}};
        Map map = new Map(map1);

        Equipe TeamRocket = new Equipe();

        System.out.println(map.afficherMap(TeamRocket));

        while(true) {
            int choix = renvoisChoix();

            switch(choix) {
                case 1:
                    creerAventurier(TeamRocket);
                    break;

                case 2:
                    TeamRocket.afficheAventuriers();
                    System.out.println(map.afficherMap(TeamRocket));
                    break;

                case 3:
                    infoAventurier(TeamRocket);
                    break;

                case 4:
                    SupprimerUnAventurier(TeamRocket);
                    break;

                case 5:
                    TeamRocket.TexteEquipeComplete();
                    break;
				/*case 6:

					InfoArtefacts(map.listArtefact());
					break;*/

                default:
                    System.out.println("Votre choix n'est pas valide");
                    break;
            }
        }
    }

    public static String GetAventurierNom() {
        System.out.println("Quel est le nom de votre aventurier?");
        String nomAventurier = Keyboard.getString();
        return nomAventurier;
    }

    public static int renvoisChoix() {
        System.out.println("Si vous voulez cr�er/ajouter un aventurier, choisissez 1");
        System.out.println("Si vous voulez afficher l'�quipe, choisissez 2");
        System.out.println("Si vous voulez avoir des informations sur un aventurier, choississez 3");
        System.out.println("Si vous voulez enlever un aventurier dans une equipe, choisissez 4");
        System.out.println("Si vous voulez savoir si l'�quipe est compl�te, choisissez 5");
        System.out.println("Si vous voulez des informations sur les art�facts, choisissez 6");
        int choix = Keyboard.getInt();
        return choix;
    }

    public static void creerAventurier(Equipe e) {
        if (!(e.estComplete())){
            String nomAventurier = GetAventurierNom();

            System.out.println("Quel est le role de votre aventurier: Explorateur, Porteur ou Grimpeur");
            String role = Keyboard.getString();

            if (!(e.roleDejaPresent(role))) {
                switch(role) {
                    case "Porteur":{
                        Aventurier a = new Porteur(nomAventurier);
                        e.ajouter(a);
                        break;
                    }
                    case "Grimpeur":{
                        Aventurier a = new Grimpeur(nomAventurier);
                        e.ajouter(a);
                        break;
                    }
                    case "Explorateur":{
                        Aventurier a = new Explorateur(nomAventurier);
                        e.ajouter(a);
                        break;
                    }
                }
            }
            else {
                System.out.println("Ce role est deja pris dans l'�quipe");
            }
        }
        else {
            System.out.println("L'equipe est d�j� compl�te");
        }
    }

    public static void chercherAventurier(Equipe e) {
        String nomAventurier = GetAventurierNom();
        System.out.println(e.renvoisAventurier(nomAventurier));
    }

    public static void SupprimerUnAventurier(Equipe e) {
        String nomAventurier = GetAventurierNom();
        Aventurier a = e.renvoisAventurier(nomAventurier);
        e.supprimer(a);
    }



    public static void infoAventurier(Equipe e) {
        String nomAventurier = GetAventurierNom();
        System.out.println("nom: " + e.renvoisAventurier(nomAventurier).nom + " Role: " + e.renvoisAventurier(nomAventurier).role + " Coordonn�es: " + e.renvoisAventurier(nomAventurier).coordonnees);
    }

    public static void InfoArtefacts(ArrayList<Artefact> lst) {
        for (Artefact a : lst) {
            System.out.println(a.toString());
        }
    }



}
