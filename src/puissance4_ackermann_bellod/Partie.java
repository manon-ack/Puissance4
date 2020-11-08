/*
ACKERMANN Manon BELLOD Vanina
TPB 1
TP 4 - Puissance 4
 */
package puissance4_ackermann_bellod;

import java.util.Scanner;
import java.util.Random;

/**
 *
 * @author vbellod
 */

public class Partie {
    Joueur [] ListeJoueurs = new Joueur [2];
    Joueur joueurCourant;
    Grille GrilleInitiale = new Grille(); // on crée une grille
    Scanner sc = new Scanner (System.in);
    
public static int menu() { 
        /*
        Cette méthode permet d'afficher le menu de choix
        L'utilisateur choisi une valeur au clavier, elle est renvoyée 
        */
 
        Scanner sc;
        int rep;
        sc = new Scanner(System.in);
        System.out.println("Que voulez-vous faire?");
        System.out.println("1 : Jouer un jeton");
        System.out.println("2 : Récuperer un jeton");
        System.out.println("3 : Désintégrer un jeton");
        rep = sc.nextInt();
        while ((rep>3) || (rep<1)){
            System.out.println("ERREUR : Votre choix n'est pas valide, veuillez entrer un autre choix : ");
            rep=sc.nextInt();
        }
        return rep; // on renvoie la réponse à la méthode appelante
     }
    
// on cree les trois fonctions disponibles pour le joueur

//choix 1 jouer un jeton
public void jouerjeton (){
    System.out.println("Dans quelle colonne voulez vous mettre votre jeton : ");
    int choixcolonne = sc.nextInt()-1;
    //si le joueur saisie une colonne qui n'existe pas on demande une autre saisie 
    while ((choixcolonne<0) || (choixcolonne>6)){ 
        System.out.println("ERREUR : Votre saisie n'est pas valide, veuillez entrer une autre colonne : ");
        choixcolonne = sc.nextInt()-1;
    }
    boolean jeu;
    //on utilise la methode ajouterjetondanscolonne pour mettre le jeton ou le joueur veut
    jeu=GrilleInitiale.ajouterJetonDansColonne(joueurCourant, choixcolonne);
    while (jeu==false) { //si la methode retourne false la colonne est remplie, le joueur doit donner une autre colonne
        System.out.println("La colonne que vous avez sélectionné est pleine, veuillez entre une autre colonne : ");
        choixcolonne = sc.nextInt()-1;
        jeu=GrilleInitiale.ajouterJetonDansColonne(joueurCourant, choixcolonne);
    }
}

//choix 2 recuperer un jeton
public boolean recupererlejeton(){
    System.out.println("Choissisez les coordonnées du jeton à récupérer : ");
    int c;
    int l;
    System.out.println("Choissisez la colonne : ");
    c = sc.nextInt()-1; //-1 à cause des indices 
    while (c > 6 || c <0) {
        System.out.println("ERREUR : choissisez une colonne valide");
        c = sc.nextInt()-1;
    }
    System.out.println("Choissisez la ligne : ");
    l = sc.nextInt()-1;
    while (l > 5 || c <0) {
        System.out.println("ERREUR : choissisez une ligne valide");
        l = sc.nextInt()-1;
    }
    if ((GrilleInitiale.Cellules[l][c].jetonCourant != null) &&(GrilleInitiale.Cellules[l][c].lireCouleurDuJeton().equals(joueurCourant.Couleur) && (GrilleInitiale.celluleOccupee(l,c)==true))) {
        joueurCourant.ajouterJeton(GrilleInitiale.recupererJeton(l,c));
        GrilleInitiale.tasserGrille(c); //on tasse la grille après la récupération
        return true;
    }
    else {
        System.out.println("ERREUR : Ce jeton n'est pas à vous ou alors la case choisie est vide");
        return false; }
}

//choix 3 desintegrer un jeton
public boolean desintegrerlejeton(){
    System.out.println("Choissisez les coordonnées du jeton à désintégrer: ");
    int c;
    int l;
    System.out.println("Choissisez la colonne: ");
    c = sc.nextInt()-1;
    while (c > 6 || c <0) {
        System.out.println("ERREUR : choissisez une colonne valide");
        c = sc.nextInt()-1;
    }
    System.out.println("Choissisez la ligne : ");
    l = sc.nextInt()-1;
    while (l > 5 || c <0) {
        System.out.println("ERREUR : choissisez une ligne valide");
        l = sc.nextInt()-1;
    }
    if (GrilleInitiale.Cellules[l][c].jetonCourant != null && GrilleInitiale.Cellules[l][c].lireCouleurDuJeton()!=joueurCourant.Couleur){
        GrilleInitiale.supprimerJeton(l,c);
        joueurCourant.utiliserDesintegrateur();
        GrilleInitiale.tasserGrille(c);
        return true;
    }
    else {
        System.out.print("ERREUR : Vous ne pouvez pas désintégrer votre propre jeton ou alors la case choisie est vide");
        return false; }
}

public void attribuerCouleursAuxJoueurs() { //attribue une couleur aux deux joueurs 
    ListeJoueurs[0].Couleur = "Jaune";
    ListeJoueurs[1].Couleur = "Rouge";   
}


public void initialiserPartie () {
    
    GrilleInitiale.viderGrille(); //on prepare la grille pour une partie
    
    //placer les 5 trous noirs 
    Random aléatoire = new Random();
    
    for (int i=0; i<5; i++) {
        int ltn = aléatoire.nextInt(6);
        int ctn = aléatoire.nextInt(7);
        GrilleInitiale.placerTrouNoir(ltn,ctn);
    }
    
    //placer les 5 desintegrateurs 
    for (int i=0; i<5; i++) {
        int ld = aléatoire.nextInt(6);
        int cd = aléatoire.nextInt(7);
        GrilleInitiale.placerDesintegrateur(ld,cd);
    }
    
    //on insere les joueurs 
    System.out.println("Pseudo du Joueur 1 : ");   
    Joueur Joueur_1 = new Joueur(sc.nextLine());
    System.out.println("Pseudo du Joueur 2 : ");
    Joueur Joueur_2 = new Joueur(sc.nextLine());
    ListeJoueurs[0]= Joueur_1;
    ListeJoueurs[1]= Joueur_2;
    
    attribuerCouleursAuxJoueurs(); //on leur attribue une couleur grâce à la méthode 
    
    System.out.println("\n");
    System.out.println(Joueur_1.Nom + " prend les jetons de couleur " + Joueur_1.Couleur);
    System.out.println(Joueur_2.Nom + " prend les jetons de couleur " + Joueur_2.Couleur);
    System.out.println("\n");
    
    for (int i=0; i<21; i++) { //on attribue les 21 jetons à chaque joueur
         Jeton jeton1 = new Jeton (ListeJoueurs[0].Couleur);
         Joueur_1.ajouterJeton(jeton1);
         Jeton jeton2 = new Jeton (ListeJoueurs[1].Couleur);
         Joueur_2.ajouterJeton(jeton2); 
    }
    System.out.println("Voici la grille de jeu : ");
    GrilleInitiale.afficherGrilleSurConsole(); //on peut afficher la grille de jeu sur la console
    System.out.println("\n");
}


public void debuterPartie () { //lance la partie 
    
    System.out.println("Nous allons débuter une partie ! ");
    initialiserPartie();
    joueurCourant=null;
    joueurCourant=ListeJoueurs[0];
    System.out.println("C'est à " + joueurCourant.Nom + " de jouer ");
    System.out.println(joueurCourant.Nom + " a encore " + joueurCourant.nombreJetonsRestant + " jetons");
    System.out.println("\n");
    
    int rep; // On initialise rep       
        do { // on fait une boucle infinie tant que la condition while en bas est vrai
            rep = menu(); // on récupere un choix retourné par la méthode menu()
            switch (rep) {
                case 1: 
                    jouerjeton(); // On appelle la méthode correspondante
                    GrilleInitiale.afficherGrilleSurConsole(); //on affiche la grille apres l'action
                    joueurGagnant();
                    JoueurSuivant();
                    //affecterjeton pr savoir si ajout bien passé
                    break;
                case 2:
                    recupererlejeton(); // On appelle la méthode correspondante
                    GrilleInitiale.afficherGrilleSurConsole(); //on affiche la grille apres l'action
                    joueurGagnant();
                    JoueurSuivant();
                    break;
                case 3:
                    desintegrerlejeton(); // On appelle la méthode correspondante
                    GrilleInitiale.afficherGrilleSurConsole(); //on affiche la grille apres l'action
                    joueurGagnant();
                    JoueurSuivant();
                    break;
                default:
                    System.out.println("Choix non valide"); // On vérifie que le chiffre selectionné fait bien partie des options
                    break;
            }
        } while (rep != 4);
          
 }

public void JoueurSuivant() {
 if ( joueurCourant == ListeJoueurs[0]) {
     System.out.println("\n");
     joueurCourant = ListeJoueurs[1];
     System.out.println("C'est à " + joueurCourant.Nom + " de jouer ");
     System.out.println(joueurCourant.Nom + " a encore " + joueurCourant.nombreJetonsRestant + " jetons");
     System.out.println(joueurCourant.Nom + " a " + joueurCourant.nombreDesintegrateurs + " désintégrateurs");
     System.out.println("\n"); }
 else {
     System.out.println("\n");
     joueurCourant = ListeJoueurs[0];
     System.out.println("C'est à " + joueurCourant.Nom + " de jouer ");
     System.out.println(joueurCourant.Nom + " a encore " + joueurCourant.nombreJetonsRestant + " jetons");
     System.out.println(joueurCourant.Nom + " a " + joueurCourant.nombreDesintegrateurs + " désintégrateurs");
     System.out.println("\n"); }
 }

 public void joueurGagnant () {
    if (GrilleInitiale.etreGagnantePourJoueur(joueurCourant)==true) {
        System.out.println(joueurCourant.Nom + " a gagné cette partie ! Félicitations");
        System.exit(0);
    }
    /*if(GrilleInitiale.etreRemplie()==true) {
        System.out.println("La grille est pleine ! Vous avez perdu... Recommencer une partie !");
        System.exit(0);
    }*/
    } 

}

