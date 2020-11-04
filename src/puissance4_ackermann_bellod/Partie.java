/*
ACKERMANN Manon BELLOD Vanina
TPB 1
TP 4 - Puissance 4
 */
package puissance4_ackermann_bellod;

import java.util.Scanner;

/**
 *
 * @author vbellod
 */
public class Partie {
    Joueur [][] ListeJoueurs;
    Joueur joueurCourant;
    Grille GrilleInitiale = new Grille(); // on crée une grille
    Scanner sc = new Scanner(System.in);
    
    public static int menu() { 
        /*
        Cette méthode permet d'afficher le menu de choix
        L'utilisateur choisi une valeur au clavier, elle est renvoyée 
        */
 
        Scanner sc;
        int rep;
        sc = new Scanner(System.in);
        System.out.println("Saissisez la conversion que vous souhaitez faire :");
        System.out.println("1 : Niveau facile");
        System.out.println("2 : Niveau intermédiaire");
        System.out.println("3 : Niveau difficile");
        System.out.println("4 : Niveau expert");
        rep = sc.nextInt();
        return rep; // on renvoie la réponse à la méthode appelante
     }
    
public void attribuerCouleursAuxJoueurs() {
    ListeJoueurs[0].Couleur = "Jaune";
    ListeJoueurs[1].couleurjeton = "Rouge";
    
}

public void initialierPartie () {
    for (int i=0; i<6; i++) {
        for (int j=0; j<7; j++) {
            GrilleInitiale.Cellules[i][j].jetonCourant = null; 
        }
    }
    
}

public void debuterPartie () {
    
}
}
