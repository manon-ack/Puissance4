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
   
public boolean ajouterJetonDansColonne ( String Jeton, int c) {
    
}

public boolean etreRemplie () {
    
}

public void viderGrille () {
    for (int i=0; i<6; i++) {
        for (int j=0; j<7; j++) {
            Cellules [i][j] = null;
        }
    }  
}

public void afficherGrilleSurConsole () {
   for (int i=0;i<6;i++){
       for (int j=0;j<7;j++)
     System.out.println(Cellules[i][j]);
   }
}

public boolean celluleOccupee (int a, int b) { // a= lignes; b= colonne
    boolean c = false;
    if (Cellules[a][b]!= null) {
        c = true;
    }
    return c;
}

public String lireCouleurDuJeton () {
    
}

public boolean etreGagnantePourJoueur () {
    
}

public boolean colonneRemplie () {
    
}

public void tasserGrille () {
    
}

public boolean placerTrouNoir (int a,int b) {
   boolean t;
   if ( Cellules[a][b]==null){
       //Cellules[a][b]= "trou noir";
       t= true;   
   }
   else {
       t = false;
   }
  return t; 
}

public boolean placerDesintegrateur (int a, int b) {
    
}

public boolean supprimerJeton (int a, int b) {
    if (Cellules[a][b].supprimerJeton()== true) {
        return true;
    }
    else {
        return false;
    }
}

public Jeton recupererJeton (int a, int b) { // a= ligne et b=colonne
    return Cellules[a][b].recupererJeton();
}
}
