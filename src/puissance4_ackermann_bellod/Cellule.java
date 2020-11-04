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
public class Cellule {
    //les attributs
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
 
 public Cellule () { // Constructeur
    jetonCourant = null;
    trouNoir = false;
    desintegrateur = false;
 }
 
 public boolean affecterJeton(Jeton UnJeton) {
      if (jetonCourant==null) {
          jetonCourant = UnJeton; 
          return true;
      }
      else {
          return false; 
      }
 }
 
 public Jeton recupererJeton() { //renvoie une reference vers le jeton de la cellule
     Jeton jetonref = jetonCourant;
     jetonCourant = null;
     return jetonref;
 }
 
 
 public boolean supprimerJeton() {
     if (jetonCourant!= null){
         jetonCourant=null;
         return true;
     }
     else {
         return false;
     }
 }
 
 public boolean placerTrouNoir() {
     if (trouNoir==false) {
         trouNoir=true;
         return true;    
     }
     else {
         return false;
     }  
 }
 
 public boolean placerDesintegrateur () {
     if (desintegrateur==false){
         desintegrateur=true;
         return true;
     }
     else {
         return false;
     }
 }
 
 public boolean presenceTrouNoir() {
     if (trouNoir==true){
          return true;
     }
     else{
         return false;
     }
 }
 
 public boolean presenceDesintegrateur() {
     if (desintegrateur==true) {
         return true;
     }
     else{
         return false;
     }
 }
 
 public String lireCouleurDuJeton () {
     
 }
 
 public boolean recupererDesintegrateur () {
     if (desintegrateur==true){
         desintegrateur=false;
         return true;
     }
     else{
         return false;
     }
 }

 
 public boolean activerTrouNoir () {
     if ((trouNoir==true) && (jetonCourant != null)){
         trouNoir=false;
         jetonCourant=null;
         return true;
      }
     else{
         return false;
      } 
}
 
}