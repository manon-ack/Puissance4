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
    Jeton jetonCourant;
    boolean trouNoir;
    boolean desintegrateur;
 
 public Cellule ( Jeton JetonC, boolean TrouN, boolean Desintegrateur ) { // Constructeur
    jetonCourant = JetonC;
    trouNoir = TrouN;
    desintegrateur = Desintegrateur;
 }
 
 public boolean affecterJeton(String Jeton) {
   boolean a = false;
   if {
      a = true; }
   else {
      a = false; }
   return a;  
 }
 
 public Jeton recupererJeton() {
     return jetonCourant;
 }
 
 public boolean supprimerJeton() {
     
 }
 
 public boolean placerTrouNoir() {
     boolean a;
     if (trouNoir) {
         
     }
     else {
         
     }  
 }
 
 public boolean presenceTrouNoir() {
  if (trouNoir==true){
      }  
 return trouNoir;
 }
 
 public boolean presenceDesintegrateru() {
   if (desintegrateur==true) {
   } 
   return desintegrateur;
 }
 
 public String lireCouleurDuJeton () {
     
 }
 
 public boolean recupererDesintegrateur () {
     
 }
 
 public boolean activerTrouNoir () {
     
 }
}