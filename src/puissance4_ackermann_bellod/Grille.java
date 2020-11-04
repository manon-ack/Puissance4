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
   Cellule [][] Cellules = new Cellule [6][7];
   
public Grille () {
       for (int i=0; i<6; i++) {
           for (int j=0; j<7; j++) {
               Cellules[i][j] = new Cellule();
           }
       }
   }

public boolean ajouterJetonDansColonne (Jeton UnJeton, int j) {
    if (colonneRemplie(j)==true) {
        return false; //renvoie faux la colonne est remplie on ne peut pas ajouter un jeton
    }
    else {
      for (int i=0; i<6; i++){
          if (Cellules[i][j].recupererJeton()==null) {
              Cellules[i][j].affecterJeton(UnJeton);
              return true; //renvoie vrai le jeton a été ajouté dans la colonne ciblée, et sur la cellule vide la plus basse
          }
      }  
    }
    return false;  
}

public boolean etreRemplie () { //renvoie vraie si la grille est pleine
    for (int i=0; i<6;i++) {
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
   for (int i=0;i<6;i++){
       for (int j=0;j<7;j++)
     System.out.println(Cellules[i][j]);
   }
}

public boolean celluleOccupee (int a, int b) { // a= lignes; b= colonnes
    if (Cellules[a][b]!= null) { //on verifie si les cases
        return true;
    }
    return false;
}

public String lireCouleurDuJeton (int i, int j) {
    String a;
    a = Cellules [i][j].lireCouleurDuJeton(); //on utilise la methode lireCouleurDuJeton de la classe Cellule
    return a;
}

public boolean etreGagnantePourJoueur () {
    
}

public boolean colonneRemplie (int j) {
    if (Cellules[6][j].recupererJeton()==null) {
        return false; //renvoie faux la colonne n'est pas remplie, on peut ajouter un jeton
    }
    else {
        return true; //renvoie vraie la colonne est remplie, on ne peut pas ajouter un jeton
    }
}

public void tasserGrille (int j) { //
    
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
