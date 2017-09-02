package td1.exo;

public abstract class CompteBancaire {
	String nom;
	String adresse;
	double solde;
	private static int numeroSuivant =1;
	int numero;
	public CompteBancaire (String nom, String adresse){
		this.numero=numeroSuivant;
		this.nom=nom;
		this.adresse=adresse;
		this.solde=0.0;
		numeroSuivant++;
	}
	public void cr�diter (double montant){
		solde += montant;
	}
	public void debiter ( double montant ) {
		if ( montant <= getSolde ())
		debiter ( montant );
		else
		System.out.println ( " D�bit non autoris� ");
		}
	public String getNom(){
		return this.nom;
	}
	public void setNom(String nom){
		this.nom=nom;
	}
	public String getAdresse() {
		return adresse;
	}
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
	public int getNumero() {
		return numero;
	}
	public double getSolde() {
		return solde;
	}
	public boolean equals(CompteBancaire autre){
		//tester si les objets sont identiques
		if (this == autre) return true;
		//doit renvoyer false si le param�tre explicite vaut null
		if (autre == null) return false;
		//si les classes ne correspondent pas , elles ne peuvent �tre �gales
		if (getClass() != autre.getClass())
			return false;
		//autre est un objet de type CompteBancaire non null
		CompteBancaire autreCompte=(CompteBancaire)autre;
		//tester si les comptes ont m�me num�ro
		return this.numero==autreCompte.numero;
	}
	public String toString (){
		return (" Compte num�ro " + numero + "ouvert au nom de " + nom + " \n Adresse du titulaire " + adresse+ " \n Solde actuel " + solde );
	}
	public abstract void traitementQuotidien();


}
