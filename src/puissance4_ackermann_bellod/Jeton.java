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
   String Couleur;
   
 public Jeton ( String couleurjeton) { // Permet d'initialiser l'attribut couleur
   Couleur = couleurjeton;  
 }
 
 public String lireCouleur () {
     return Couleur;
 }
 
 @Override
 public String toString(){
     if ("Jaune".equals(Couleur))
         return"\u001B [33m 0"; //reference pour le jaune 
     return "\u001B [31m 0"; //reference pour le rouge 
 }
}
