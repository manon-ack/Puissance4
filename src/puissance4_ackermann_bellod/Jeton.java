/*
ACKERMANN Manon BELLOD Vanina
TPB 1
TP 4 - Puissance 4
 */
package puissance4_ackermann_bellod;

/**
 *
 * @author vbellod
 */
public class Jeton {
   Joueur Couleur;
   
 public Jeton ( Joueur couleurjeton) { // Permet d'initialiser l'attribut couleur
   Couleur = couleurjeton;  
 }
 
 public String lireCouleur () {
     return Couleur;
 }
}
