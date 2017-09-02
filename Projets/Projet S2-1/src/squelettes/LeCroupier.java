package squelettes;

import serveur.Croupier;
import serveur.Serveur;

/** * Cette classe est un simple squelette dont les m�thodes doivent �tre
 * compl�t�es par chaque groupe.
 * 
 * On peut ajouter des m�thodes.
 * 
 * On doit ajouter les attributs et �ventuelles classes additionnelles pour
 * g�rer le jeu de cartes.
 * 
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
public class LeCroupier implements Croupier {
	// Ne vous posez pas trop de question sur "implements Croupier".
	// Laissez cette ligne telle quelle.
	// Vous verrez le sens de ces deux mots en L2.
	// Sachez juste que cela permet d'int�grer votre classe "LeCroupier" au
	// serveur qui vous sera fourni.

	public LeCroupier() {
	}
	Deck d = new Deck();
	// ///////// MELANGE DES CARTES /////////////

	/**
	 * Reforme le jeu complet en remettant dedans les cartes distribu�es, les
	 * cartes br�l�es et le tableau
	 */
	@Override
	public void ramasse() {
		new Deck();
	}

	/**
	 * Bat les cartes (proc�de � un nombre al�atoire de coupes; le nombre de
	 * coupes est compris entre 5 et 30).
	 */
	@Override
	public void battage() {
		for (int i = 0; i < Math.random()*25+5; i++){
			this.coupe();
		}
	}

	/**
	 * Bat les cartes en proc�dant � exactement nbcoupes.
	 */
	@Override
	public void battage(int nbcoupes) {
		for (int i = 0; i < nbcoupes; i++){
			this.coupe();
		}
	}

	/**
	 * Coupe le jeu : d�termine al�atoirement un point de coupe dans le jeu,
	 * prend toutes les cartes situ�es apr�s ce point et les place en d�but de
	 * jeu.
	 */
	@Override
	public void coupe() {/*
		int a=1;
		Maillon b = new Maillon(d.getListe().premier().getItem());
		Maillon p = new Maillon(d.getListe().premier().getItem());
		while (b.getSuivant() != null){
			b = b.getSuivant();
		}
		while (a != Math.random()*51 && p.getSuivant()!= null){
			p = p.getSuivant();
			a++;
		}
		b.setSuivant(d.getListe().premier());
		d.getListe().tete = p.getSuivant();    */
	}

	/**
	 * Retire la carte au sommet du jeu.
	 */
	@Override
	public void brule() {
		d.getListe().tete=d.getListe().tete.getSuivant();
	}

	/////////// DISTRIBUTION DES CARTES /////////////

	/**
	 * Renvoie le flop (3 premi�res cartes du tableau), constitu� des trois
	 * premi�res cartes du jeu (celles du dessus), sous la forme d'un tableau de
	 * 6 chaines : Rang de la premi�re carte + couleur de la premi�re carte +
	 * rang de la deuxi�me carte etc.
	 * 
	 * @return le flop
	 */
	@Override
	public String[] flop() {
		Maillon m = new Maillon (null);
		Maillon n = new Maillon (null);
		Maillon t = new Maillon (null);
		m = d.getListe().tete;
		brule();
		n = d.getListe().tete;
		brule();
		t = d.getListe().tete;
		brule();
		return new String[] { m.getItem().getValeur(), m.getItem().getCouleur(), n.getItem().getValeur(), n.getItem().getCouleur(), 
								t.getItem().getValeur(), t.getItem().getCouleur()};
	}

	/**
	 * Renvoie le tournant (4�me carte du tableau) sous la forme d'un tableau de
	 * 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return le tournant
	 */
	@Override
	public String[] tournant() {
		Maillon m = new Maillon (null);
		m = d.getListe().tete;
		brule();
		return new String[] {  m.getItem().getValeur(), m.getItem().getCouleur() };
	}

	/**
	 * Renvoie la rivi�re (5�me carte du tableau) sous la forme d'un tableau de
	 * 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return la riviere
	 */
	@Override
	public String[] riviere() {
		Maillon m = new Maillon (null);
		m = d.getListe().tete;
		brule();
		return new String[] {  m.getItem().getValeur(), m.getItem().getCouleur() };
	}

	/**
	 * Renvoie la premi�re carte du jeu (celle du dessus) sous la forme d'un
	 * tableau de 2 chaines : Rang de la carte + couleur de la carte
	 * 
	 * @return la premiere carte
	 */
	@Override
	public String[] carte() {
		Maillon m = new Maillon (null);
		m = d.getListe().tete;
		return new String[] {  m.getItem().getValeur(), m.getItem().getCouleur() };
	}

	/*
	 * Ce main permet de d�marrer le serveur en lui disant de travailler avec votre classe "LeCroupier"
	 * D�commentez-le quand vous voudrez tester le serveur avec votre croupier...
	 * 
	 *
	 */
	public static void main(String[] args) {
		// creation du serveur
		Serveur s = new Serveur();
		// mise en place du nombre de joueurs
		s.setNbJoueurs(4);
		// mise en place de la caisse de chaque joueur (nombre initial de jetons)
		s.setCaisse(100);
		// mise en place de la petite blinde. La grande blinde est �gale � 2 fois la petite.
		s.setBlinde(5);
		// demande au serveur d'utiliser votre classe "LeCroupier"
		s.setCroupier(new LeCroupier());
		// Demarre le serveur : attend les joueurs puis commence la partie
		s.demarreServeur();
	}
}

