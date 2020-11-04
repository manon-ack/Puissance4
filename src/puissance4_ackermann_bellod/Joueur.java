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
  Jeton [] ListeJetons = new Jeton [21];
  int nombreDesintegrateurs;
  int nombreJetonsRestant;

public Joueur (String nom) { //constructeur pour initialiser 
   Nom = nom;
   nombreDesintegrateurs=0;
   nombreJetonsRestant=0;
}

public void affecterCouleur (String couleur) { //affecte la couleur en paramètre au joueur 
   Couleur=couleur;
}

public void ajouterJeton(Jeton unJeton) { //ajoute le jeton en paramètre à la liste des jetons
    ListeJetons[nombreJetonsRestant++] = unJeton;
}

public Jeton retirerJeton() {
    nombreJetonsRestant = nombreJetonsRestant-1;
    return ListeJetons[nombreJetonsRestant];
}
public void obtenirDesintegrateur() { //incrémente le nombre de desintegrateurs du joueur
   nombreDesintegrateurs = nombreDesintegrateurs +1; 
}

public boolean utiliserDesintegrateur () { //szcremente le nb de desintegrateurs
   if (nombreDesintegrateurs != 0) {
       nombreDesintegrateurs = nombreDesintegrateurs -1;
       return true; } //confirme l'utilisation du desintegrateur
   else {
       return false; //renvoie faux s'il ne restait plus de désintégrateurs
     }
}
}