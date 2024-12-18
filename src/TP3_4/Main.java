package TP3_4;
//import java.util.ArrayList;

import java.util.ArrayList;

import in.keyboard.Keyboard;


public class Main {

    public static void main(String[] args) {
        int[][] map1 = {{0, 0, 3, 0, 4, 2, 2, 0}, {3, 2, 1, 2, 3, 2, 1, 1}, {4, 1, 3, 4, 3, 4, 1, 2}, {0, 0, 2, 4, 3, 2, 1, 0}, {1, 0, 1, 2, 3, 4, 2, 1}, {1, 1, 0, 0, 4, 3, 3, 0}, {1, 2, 3, 0, 0, 4, 2, 1}, {0, 3, 0, 0, 4, 4, 3, 4}};
        Map map = new Map(map1);

        Equipe TeamRocket = new Equipe();

        System.out.println(map.afficherMap(TeamRocket));

        while (true) {
            int choix = renvoisChoix();

            switch (choix) {
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
                    supprimerUnAventurier(TeamRocket);
                    break;

                case 5:
                    TeamRocket.texteEquipeComplete();
                    break;

                case 6:
                    System.out.println(commencerLaPartie(TeamRocket, map));
                    break;

				case 7:
					infoArtefacts(map.artefact);
					break;

                default:
                    System.out.println("Votre choix n'est pas valide");
                    break;
            }
        }
    }

    public static String getAventurierNom() {
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
        System.out.println("Si vous voulez comencer la partie: choisissez 6");
        System.out.println("Si vous voulez des informations sur les art�facts, choisissez 7");
        int choix = Keyboard.getInt();
        return choix;
    }

    public static void creerAventurier(Equipe e) {
        if (!(e.estComplete())) {
            String nomAventurier = getAventurierNom();

            System.out.println("Quel est le role de votre aventurier: Explorateur, Porteur ou Grimpeur");
            String role = Keyboard.getString();

            if (!(e.roleDejaPresent(role))) {
                switch (role) {
                    case "Porteur": {
                        Aventurier a = new Porteur(nomAventurier);
                        e.ajouter(a);
                        break;
                    }
                    case "Grimpeur": {
                        Aventurier a = new Grimpeur(nomAventurier);
                        e.ajouter(a);
                        break;
                    }
                    case "Explorateur": {
                        Aventurier a = new Explorateur(nomAventurier);
                        e.ajouter(a);
                        break;
                    }
                }
            } else {
                System.out.println("Ce role est deja pris dans l'�quipe");
            }
        } else {
            System.out.println("L'equipe est d�j� compl�te");
        }
    }

    public static void chercherAventurier(Equipe e) {
        String nomAventurier = getAventurierNom();
        System.out.println(e.renvoisAventurier(nomAventurier));
    }

    public static void supprimerUnAventurier(Equipe e) {
        String nomAventurier = getAventurierNom();
        Aventurier a = e.renvoisAventurier(nomAventurier);
        e.supprimer(a);
    }


    public static void infoAventurier(Equipe e) {
        String nomAventurier = getAventurierNom();
        System.out.println("nom: " + e.renvoisAventurier(nomAventurier).nom + " Role: " + e.renvoisAventurier(nomAventurier).role + " Coordonn�es: " + e.renvoisAventurier(nomAventurier).coordonnees);
    }

    public static void infoArtefacts(ArrayList<Artefact> lst) {
        for (Artefact a : lst) {
            System.out.println(a.toString());
        }
    }

    public static void monteDesEaux(Map map){
        int min = 1;
        int max = 6;
        int randomValue = (int) (Math.random() * (max - min)) + min;
        if (randomValue == 1){
            for (int i=0; i< map.map.length; i++) {
                for (int j = 0; j < map.map[i].length; j++) {
                    if (map.map[i][j] > 0){
                        map.map[i][j] -= 1;
                    }
                }
            }
        }
    }

    public static String commencerLaPartie(Equipe e, Map map) {
        boolean jouer = true;
        String res = "";
        if (e.getNbAventurier() == 1) {
            while (jouer) {
                for (Aventurier a : e.aventurier) {
                    if (jouer == false){
                        break;
                    }
                    System.out.println("Liste des artefacts de la map: ");
                    infoArtefacts(map.artefact);

                    System.out.println("Liste de vos artefacts : ");
                    infoArtefacts(a.artefact);

                    System.out.println("\n" + a.role + " A vous de jouer !");
                    System.out.println("Se deplacer : 1");
                    System.out.println("Récuperer un artefact : 2");
                    System.out.println("Ne rien faire : 3");
                    System.out.println("Quitter la partie : 4");
                    int choix = Keyboard.getInt();
                    switch (choix) {
                        case 1: {
                            System.out.println(map.afficherMap(e));
                            a.seDeplacer(map);
                            break;
                        }
                        case 2: {
                            a.recupArtefact(map);
                            break;
                        }
                        case 3: {
                            System.out.println(map.afficherMap(e));
                            break;
                        }
                        case 4: {
                            jouer = false;
                            break;
                        }
                    }

                    monteDesEaux(map);

                }
                res = "START";
            }
        }

        else {
            res = "Votre equipe n'est pas complete";
        }
        return res;
    }
}
