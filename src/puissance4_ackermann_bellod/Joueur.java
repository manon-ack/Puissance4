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
public class Joueur {
  String Nom;
  String Couleur;
  String [] ListeJetons = new String [21];
  int nombreDesintegrateur;
  int nombreJetonsRestant;

public Joueur ( String nom) {
   Nom = nom;
}

public void affecterCouleur (String couleur) {
   Couleur=couleur;
}

public boolean ajouterJeton(String Jeton) {
   boolean a = false;
   for (int i=0; i<=21; i++) {
     if (ListeJetons[i]== null ) {
         ListeJetons [i] = Couleur;
         a = true; }
     else {
         a = false; }
   }
   return a;
}

public void obtenirDesintegrateur() {
   nombreDesintegrateur = nombreDesintegrateur +1; 
}

public boolean utiliserDesintegrateur () {
   boolean a;
   if (nombreDesintegrateur != 0) {
       nombreDesintegrateur = nombreDesintegrateur -1;
       a = true; }
   else {
       a = false; }
   return a;
}
}