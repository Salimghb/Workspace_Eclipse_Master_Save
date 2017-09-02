package projet;

public class Salle {	
	private String nomSalle;
	private int capacit�;
	private double tarif;
	private int nbPlacesStandard;
	public Salle(String nomSalle, int capacit�, double tarif, 
			int nbPlacesStandard){
		this.nomSalle=nomSalle;
		this.capacit�=capacit�;
		this.tarif=tarif;
		this.nbPlacesStandard=nbPlacesStandard;
	}
	public String toString() {
		return "Salle : "+nomSalle 
				+ "\n Capacit� : " + capacit�
				+ "\n Prix standard : " + tarif 
				+ "\n Prix r�duit : " + tarif * 0.6
				+ "\n Nombre de places : " + nbPlacesStandard;
	}
	public String getNomSalle() {
		return nomSalle;
	}
	public void setNomSalle(String nomSalle) {
		this.nomSalle = nomSalle;
	}
	public int getCapacit�() {
		return capacit�;
	}
	public void setCapacit�(int capacit�) {
		this.capacit� = capacit�;
	}
	public double getTarif() {
		return tarif;
	}
	public void setTarif(double tarif) {
		this.tarif = tarif;
	}
	public int getNbPlacesStandard() {
		return nbPlacesStandard;
	}
	public void setNbPlacesStandard(int nbPlacesStandard) {
		this.nbPlacesStandard = nbPlacesStandard;
	}

	
}
