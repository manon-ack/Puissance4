/*
ACKERMANN Manon BELLOD Vanina
TPB 1
TP 4 - Puissance 4
 */
package puissance4_ackermann_bellod;
//test deux 
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
    
    
public void attribuerCouleurAuxJoueurs() {
    
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
