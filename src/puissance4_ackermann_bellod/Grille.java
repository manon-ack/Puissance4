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

public class Grille {
   Cellule [][] Cellules = new Cellule [6][7]; //on a une grille de 6lignes et 7 colonnes
   
public Grille () { //on initialise la grille en créant les 42 cellules vides
       for (int i=0; i<6; i++) {
           for (int j=0; j<7; j++) {
               Cellules[i][j] = new Cellule();
           }
       }
   }

public boolean ajouterJetonDansColonne (Joueur joueurCourant, int j) { //ajoute le jeton dans la colonne souhaitée
    if (colonneRemplie(j)==true) {
        return false; //renvoie faux la colonne est remplie on ne peut pas ajouter un jeton
    }
    int i = 0;
    while (Cellules [i][j].jetonCourant != null) { //on cherche dans quelle ligne le jeton est ajouté
        i++;
    }
    Jeton unJeton = joueurCourant.retirerJeton();  //on prend un jeton au joueur
    Cellules [i][j].jetonCourant = unJeton; //on ajoute le jeton dans la cellule
    
    if(Cellules [i][j].presenceDesintegrateur()) { //on verifie la presence d'un desintegrateur 
       Cellules [i][j].recupererDesintegrateur();
       joueurCourant.nombreDesintegrateurs++;
    }
    
    if (Cellules [i][j].presenceTrouNoir()) { //on verifie la présence d'un trou noir 
       Cellules [i][j].activerTrouNoir();
  
    }
   return true;     
}

public void activertrounoir (int j) {
    int i=5;
    while (Cellules [i][j].jetonCourant == null) {
        i--;
        if (i==0){
            break;
        }
    }
    if ((i>= 0) && (i<6)) {
        Cellules [i][j].activerTrouNoir();
    }
}

public boolean etreRemplie () { //renvoie vraie si la grille est pleine
    for (int i=0; i<6;i++) { //on parcourt la grille pour voir si elle est remplie
        for (int j=0; j<7;j++) {
            if (Cellules [i][j].recupererJeton() == null){
                return false;
            }
            else{
                return true;
            }
        }
    }
    return true;
}

public void viderGrille () { //vider la grille
    for (int i=0; i<6; i++) { //on parcourt les lignes
        for (int j=0; j<7; j++) { //on parcourt les colonnes
            Cellules[i][j].supprimerJeton(); //on supprimer tous les jetons présents
            Cellules[i][j].trouNoir = false; //on remet les trou noir et desingrateur sur false
            Cellules[i][j].desintegrateur = false;
        }
    }  
}

public void afficherGrilleSurConsole () {
   for (int i=0;i<6;i++){ //on parcourt les lignes
       for (int j=0;j<7;j++) { //on parcourt les colonnes 
           
        if (Cellules[i][j].recupererJeton()==null) { //si il n'y a pas de jeton on affiche V pour vide
            System.out.println("V");
        }
        if (Cellules[i][j].recupererJeton()!=null){
            if (Cellules[i][j].lireCouleurDuJeton()=="Jaune") {
                System.out.println("J"); //on affiche un J s'il y a un jeton jaune sur la cellule
            }
            else{
                System.out.println("R"); //sinon on affiche rouge 
            }
        }
       
        if (Cellules[i][j].presenceTrouNoir()== true) {
           System.out.println("T");
        }
        
        if (Cellules[i][j].presenceDesintegrateur()== true){
            System.out.println("D");
        }
       }
    }
}

public boolean celluleOccupee (int i, int j) { 
    if (Cellules[i][j]!= null) { 
        return true; //renvoie vrai si la cellule de coordonnées données est occupée
    }
    return false; //renvoie faux si la cellule est vide 
}

public String lireCouleurDuJeton (int i, int j) {
    return Cellules [i][j].lireCouleurDuJeton(); //on utilise la methode lireCouleurDuJeton de la classe Cellule
}

public boolean etreGagnantePourJoueur (Joueur jetonCourant) { //renvoie vrai si la grille est gagnante pour le joueur en parametre si 4jetons alignés
    
    //gagne si 4jetons alignés en ligne 
    for (int i=0; i<6;i++) {
        for (int j=0;j<4;j++){
            if ((Cellules[i][j].lireCouleurDuJeton()==jetonCourant.Couleur) && (Cellules[i][j+1].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i][j+2].lireCouleurDuJeton()==jetonCourant.Couleur) && (Cellules[i][j+3].lireCouleurDuJeton()==jetonCourant.Couleur)){
            return true;
            }
        }    
    }
    
    //gagne si 4jetons alignés en colonnes
    for (int j=0;j<7;j++) {
        for (int i=0;i<4;i++) {
            if ((Cellules[i][j].lireCouleurDuJeton()==jetonCourant.Couleur) && (Cellules[i+1][j].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i+2][j].lireCouleurDuJeton()==jetonCourant.Couleur) && (Cellules[i+3][j].lireCouleurDuJeton()==jetonCourant.Couleur)){
            return true;
            } 
        }
    }
    
    //gagne si 4jetons alignés en diagnonale  vers le haut
    for (int i=0; i<6; i++) {
        for (int j=0; j<4; j++){
            if ((Cellules[i][j].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i-1][j+1].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i-2][j+2].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i-3][j+3].lireCouleurDuJeton()==jetonCourant.Couleur)) {
                return true;
            }
        }
    }
    
    //gagne si 4jetons alignés en diagonale vers le bas 
    for (int i=0;i<6;i++) {
        for (int j=0; j<4; j++){
            if ((Cellules[i][j].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i+1][j+1].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i+2][j+2].lireCouleurDuJeton()==jetonCourant.Couleur)&&(Cellules[i+3][j+3].lireCouleurDuJeton()==jetonCourant.Couleur)) {
                return true;
            }
        }
    }
  return false;  
}


public boolean colonneRemplie (int j) { 
    if (Cellules[5][j].recupererJeton()==null) {
        return false; //renvoie faux la colonne j n'est pas remplie, on peut ajouter un jeton
    }
    else {
        return true; //renvoie vraie la colonne j est remplie, on ne peut pas ajouter un jeton
    }
}

public void tasserGrille (int j) { //si un jeton est capturé ou detruit, on decale de une ligne les jetons au dessus de la cellule liberée
    for (int i=5; i<=1; i--) { //on part du bas de la grille
        if (Cellules [i][j].jetonCourant == null) { //si la case est nulle qd le jeton a ete detruit ou capture
            Cellules[i][j].jetonCourant = Cellules[i-1][j].jetonCourant; //on decale d'une ligne
        }
    }
}

public boolean placerTrouNoir (int i,int j) { //ajoute un trou noir à l'endroit indiqué
   if ( Cellules[i][j].placerTrouNoir()==true){ 
       return true; //renvoie vrai si l'ajout s'est bien passé 
   }
   else {
       return false;
   }
}

public boolean placerDesintegrateur (int i, int j) { //ajoute un desintegrateur à l'endroit indiqué
    if ( Cellules[i][j].placerDesintegrateur()==true){ 
       return true; //renvoie vrai si l'ajout s'est bien passé 
   }
   else {
       return false;
   }
}

public boolean supprimerJeton (int i, int j) { //supprime le jeton de la cellule visée
    if (Cellules[i][j].supprimerJeton()== true) {
        return true; //renvoie vraie si la suppression s'est bien passée 
    }
    else {
        return false;
    }
}

public Jeton recupererJeton (int i, int j) { // enleve le jeton de la cellule visée et renvoie une ref vers ce jeton
    return Cellules[i][j].recupererJeton();
}
}
