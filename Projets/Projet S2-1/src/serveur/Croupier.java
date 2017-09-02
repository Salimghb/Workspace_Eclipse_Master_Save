package serveur;

/**
 * Le croupier bat les cartes et proc�de � leur distribution.
 * 
 * Les cartes sont renvoy�es sous la forme de paires de cha�nes : valeur de la
 * carte + couleur de la carte.
 * 
 * Les valeurs sont : As, 2, 3, 4, 5, 6, 7, 8, 9, 10, Valet, Dame, Roi Les
 * couleurs sont : Coeur, Carreau, Pique, Trefle
 * 
 * Il faut utiliser les syntaxes ci-dessus (pas d'accents, majuscule en d�but de
 * mot).
 * 
 * 
 */
public interface Croupier {
	/////////// MELANGE DES CARTES /////////////
/**
 * Reforme le jeu complet en remettant dedans les cartes distribu�es, les
 * cartes br�l�es et le tableau
 */
public void ramasse();

	/**
	 * Bat les cartes (proc�de � un nombre al�atoire de coupes; le nombre de
	 * coupes est compris entre 5 et 30).
	 */

public void battage();
	/**
	 * Bat les cartes en proc�dant � exactement nbcoupes.
	 */

public void battage(int nbcoupes);
	/**
	 * Coupe le jeu : d�termine al�atoirement un point de coupe dans le jeu,
	 * prend toutes les cartes situ�es apr�s ce point et les place en d�but de
	 * jeu.
	 */

public void coupe();



public void brule();

	// ///////// DISTRIBUTION DES CARTES /////////////

	/**
	 * Renvoie le flop (3 premi�res cartes du tableau), constitu� des trois
	 * premi�res cartes du jeu (celles du dessus), sous la forme d'un tableau de
	 * 6 chaines : Rang de la premi�re carte + couleur de la premi�re carte +
	 * rang de la deuxi�me carte etc.
	 * 
	 * @return le flop
	 */
public String[] flop();

	/**
	 * Renvoie le tournant (4�me carte du tableau) sous la forme d'un tableau de
	 * 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return le tournant
	 */
public String[] tournant();

	/**
	 * Renvoie la rivi�re (5�me carte du tableau) sous la forme d'un tableau de
	 * 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return la riviere
	 */
public String[] riviere();

	/**
	 * Renvoie la premi�re carte du jeu (celle du dessus) sous la forme d'un
	 * tableau de 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return la premi�re carte sur le paquet
	 */
public String[] carte();
}

