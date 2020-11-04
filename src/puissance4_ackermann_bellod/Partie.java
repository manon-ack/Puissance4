/*
ACKERMANN Manon BELLOD Vanina
TPB 1
TP 4 - Puissance 4
 */
package puissance4_ackermann_bellod;

import java.util.Scanner;
//import java.util.Random;

/**
 *
 * @author vbellod
 */
public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille GrilleInitiale = new Grille(); // on crée une grille
    Scanner sc = new Scanner (System.in);
    
public static int menu() { 
        /*
        Cette méthode permet d'afficher le menu de choix
        L'utilisateur choisi une valeur au clavier, elle est renvoyée 
        */
 
        Scanner sc;
        int rep;
        sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire? ");
        System.out.println("1 : Jouer un jeton");
        System.out.println("2 : Récuperer un jeton");
        System.out.println("3 : Désintégrer un jeton");
        rep = sc.nextInt();
        return rep; // on renvoie la réponse à la méthode appelante
     }
    
public void attribuerCouleursAuxJoueurs() { //attriue une couleur aux deux joueurs 
    ListeJoueurs[0].Couleur = "Jaune";
    ListeJoueurs[1].Couleur = "Rouge";
    
}

public void initialierPartie () {
    
    GrilleInitiale.viderGrille(); //on prepare la grille pour une partie
    
    //placer les 5 trous noirs dont 2 avec des désintégrateurs
    
    //placer les 3 desintegrateurs restants
    
    //on insere les joueurs 
    System.out.println("Pseudo du Joueur 1 : ");
    System.out.println("Pseudo du Joueur 2 : ");
    Joueur Joueur_1 = new Joueur(sc.nextLine());
    Joueur Joueur_2 = new Joueur(sc.nextLine());
    ListeJoueurs[0]= Joueur_1;
    ListeJoueurs[1]= Joueur_2;
    
    attribuerCouleursAuxJoueurs(); //on leur attribue une couleur grâce à la méthode 
    
    System.out.println(Joueur_1.Nom + "prend les jetons de couleur" + Joueur_1.Couleur);
    System.out.println(Joueur_2.Nom + "prend les jetons de couleur" + Joueur_2.Couleur);
    
    for (int i=0; i<21; i++) { //on attribue les 21 jetons à chaque joueur
         Jeton jeton1 = new Jeton (ListeJoueurs[0].Couleur);
         Joueur_1.ajouterJeton(jeton1);
         Jeton jeton2 = new Jeton (ListeJoueurs[1].Couleur);
         Joueur_2.ajouterJeton(jeton2); 
    }
    
    GrilleInitiale.afficherGrilleSurConsole();
}

public void debuterPartie () {
    
}
}
