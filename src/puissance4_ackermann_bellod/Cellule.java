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
 
 public Cellule () { // Constructeur du même nom que la classe
    jetonCourant = null; //aucun jeton quand la cellule est crée
    trouNoir = false; // aucun trou noir quand la cellule est crée
    desintegrateur = false; // aucun desintegrateur quand la cellule est crée
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
 
 public Jeton recupererJeton() { //permet de recuperer le jeton de la cellule et renvoie une reference vers le jeton de la cellule
     Jeton jetonref = jetonCourant;
     jetonCourant = null;
     return jetonref;
 }
 
 
 public boolean supprimerJeton() {
     if (jetonCourant == null){
         return false;
     }
     else {
         jetonCourant = null;
         return true;
     }
 }
 
 public boolean placerTrouNoir() { //ajoute un trou noir à l'endroit indiqué et renvoie vrai
     if (trouNoir==false) {
         trouNoir=true;
         return true;    
     }
     else {
         return false; //si trou noir déjà présent par ex renvoie faux 
     }  
 }
 
 public boolean placerDesintegrateur () {
     if (desintegrateur==false){
         desintegrateur=true;
         return true;
     }
     else {
         return false; //si un desintegrateur est déjà présent par ex renvoie faux 
     }
 }
 
 public boolean presenceTrouNoir() {
   return trouNoir; //renvoie vrai si un trou noir est présent sur la cellule
 }
 
 public boolean presenceDesintegrateur() {
   return desintegrateur; //renvoie vrai si un desintegrateur est présent sur la cellule
 }
 
 public String lireCouleurDuJeton () { //renvoie la couleur du jeton occupant la cellule ou cellule vide 
     if (jetonCourant == null) {
         return "cellule vide";
     }
     else {
         return jetonCourant.Couleur;
     }
 }
 
 public boolean recupererDesintegrateur () { //supprime le desintegrateur present dans la cellule
     if (presenceDesintegrateur()){
         desintegrateur=false;
         return true;
     }
         return false; //renvoie faux si pas de desintegrateur present 
 }

 
 public boolean activerTrouNoir () {
     if ((trouNoir==true) && (jetonCourant != null)){
         trouNoir=false;
         jetonCourant=null;
         System.out.println("Quel dommage! Votre jeton est tombé dans un trou noir !");
         return true;
      }
     else{
         return false;
      } 
}
 
}