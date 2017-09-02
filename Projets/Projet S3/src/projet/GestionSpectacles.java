package projet;

import java.util.*;

public class GestionSpectacles {
	//VARIABLES
	static EnsemblesSalles s = new EnsemblesSalles();	
	static EnsemblesSallesTheatre st = new EnsemblesSallesTheatre();

	static String nomSalle;
	static int capacit�;
	static double tarif;
	static int nbPlacesStandard;
	static double prixFauteuil;
	static int nbFauteuils;
	static List<ProgrammationSemaine> lesProgrammations=new ArrayList<ProgrammationSemaine>();
	static Scanner sc=new Scanner(System.in);
	//MAIN
	public static void main(String[]args){
		CreationSalle();
		ActionsSurProgrammations();
	}



	//Permet de creer une salle de spectacle.
	//Appel�e par le main
	public static void CreationSalle(){
		while (true){			
			System.out.println("Quel type de salle voulez-vous cr�er?");
			System.out.println("- Tapez t pour cr�er une salle de th��tre.");
			System.out.println("- Tapez c pour cr�er une salle standard.");
			System.out.println("- Tapez q pour passer � la suite.");
			String choix=sc.nextLine();
			if(choix.equalsIgnoreCase("q")){
				break;
			}else{
				if(choix.equalsIgnoreCase("t")){
					CreationSalleTheatre();
				}else{
					if(choix.equalsIgnoreCase("c")){
						CreationSalleCinema();
					}else{
						System.out.println("Choix incorrect");
					}
				}
			}
		}
	}

	//Permet de creer une salle de theatre.
	//Appel�e par CreationSalle
	public static void CreationSalleTheatre(){
		SalleTheatre salletheatre;
		System.out.println("Nom de la salle?");
		nomSalle=sc.nextLine();

		if(st.RechercherSalleTheatre(nomSalle)!=null){
			System.out.println("\n Une salle est deja nomm�e ainsi \n");
			return;
		}

		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Capacit� de la salle?");
			double c1=sc.nextDouble();
			if (c1==(int)c1 && c1>=0){
				capacit�=(int) c1;
				break;
			}
			else
				System.out.println("Capacit� incorrecte");
		}

		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Tarif des places standards?");
			double c2=sc.nextDouble();
			if (c2>=0){
				tarif=c2;
				break;
			}
			else
				System.out.println("Tarif incorrect");
		}

		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Nombre de places aux balcons?");
			double c3=sc.nextDouble();
			if (c3==(int)c3 && c3>=0){
				nbPlacesStandard=(int) c3;
				break;
			}
			else
				System.out.println("Nombre de places aux balcons incorrect");
		}

		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Nombre de fauteuils?");
			double c4=sc.nextDouble();
			if (c4==(int)c4 && c4>=0){
				nbFauteuils=(int) c4;
				break;
			}
			else
				System.out.println("Nombre de fauteuils incorrect");
		}

		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Prix des places avec fauteuils?");
			double c5=sc.nextDouble();
			if (c5>=0){
				prixFauteuil=c5;
				break;
			}
			else
				System.out.println("Prix des places avec fauteuils incorrect");
		}
		sc.nextLine();
		salletheatre=new SalleTheatre(nbFauteuils, prixFauteuil, nomSalle, capacit�, tarif, nbPlacesStandard);
		System.out.println(salletheatre);

		System.out.println("Ces param�tres vous conviennent-ils? \nOui : O - Non : N");
		String s1=sc.nextLine();
		if(s1.equalsIgnoreCase("o")){
			st.ajouterSalleTheatre(salletheatre);
		}
	}

	//Permet de creer une salle de cinema.
	//Appel�e par CreationSalle
	public static void CreationSalleCinema(){
		Salle salle;
		System.out.println("Nom de la salle?");
		nomSalle=sc.nextLine();

		if(st.RechercherSalleTheatre(nomSalle)!=null){
			System.out.println("\n Une salle est deja nomm�e ainsi \n");
			return;
		}
		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Capacit� de la salle?");
			double c1=sc.nextDouble();
			if (c1==(int)c1 && c1>=0){
				capacit�=(int) c1;
				break; 
			}
			else
				System.out.println("Veuillez entrer un entier positif");
		}
		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Tarif des places standards?");
			double c2=sc.nextDouble();
			if ( c2>=0){
				tarif=c2;
				break;
			}
			else
				System.out.println("Tarif incorrect");
		}
		while(true){
			//ATTENTION : LE SEPARATEUR EST UNE VIRGULE
			System.out.println("Nombre de places standards?");
			double c3=sc.nextDouble();
			if (c3==(int)c3 && c3>=0){
				nbPlacesStandard=(int) c3;
				break;
			}
			else
				System.out.println("Veuillez entrer un entier positif");
		}
		sc.nextLine();
		salle=new Salle(nomSalle, capacit�, tarif, nbPlacesStandard);
		System.out.println(salle.toString());
		System.out.println("Ces parametres vous conviennent-ils? \n Oui : o - Non : n");
		String s2=sc.nextLine();
		if(s2.equalsIgnoreCase("o")){
			s.ajouterSalle(salle);
		}
	}




	//Propose des actions sur les programamtions de la semaine
	//Appel� par le main
	public static void ActionsSurProgrammations(){
		while(true){
			System.out.println("Que voulez-vous faire?");
			System.out.println("- Tapez c pour cr�er la programmation d'une semaine au choix.");
			System.out.println("- Tapez m pour modifier une programmation existante.");
			System.out.println("- Tapez v pour vendre des places pour une programmation.");
			System.out.println("- Tapez i pour avoir des informations sur les ventes");
			System.out.println("- Tapez q pour revenir au menu.");
			String choix=sc.nextLine();
			if(choix.equalsIgnoreCase("q")){ //Quitter
				break;
			}

			if(choix.equalsIgnoreCase("c")){ //Creer une prog pour la semaine choisie
				CreationProgSemaine();
			}

			if(choix.equalsIgnoreCase("m")){ //Modifier une programmation existante
				ModificationProgSemaine();
			}

			if(choix.equalsIgnoreCase("i")){ //Informations sur les seances et les spectacles
				InfosSpectacles();
			}

			if(choix.equalsIgnoreCase("v")){ //Vente de places
				VendreProgSemaine();
			}
		}
	}


	//Fournit des informations sur les seances et les spectacles
	//Appel�e par ActionsSurProgramamtions
	public static void InfosSpectacles() {
		ProgrammationSemaine prog;
		while(true){
			//Evite l'erreur IndexOutOfBoundsException
			System.out.println("Pour quelle semaine voulez vous des informations?");
			int sem=sc.nextInt();
			if(sem>0 && sem<=lesProgrammations.size()){
				if(lesProgrammations.get(sem)!=null){//V�rifie si une programmation est affect�e a cet index
					prog=lesProgrammations.get(sem);
					break;
				}else{
					System.out.println("Semaine incorrect");
				}
			}else{
				System.out.println("Semaine incorrect");
			}
		}
		while(true){
			System.out.println("Informations sur une seance de cinema : 1"
					+"\nInformations sur une seance de theatre : 2"
					+"\nInformations sur un film : 3"
					+"\nInformations sur une piece de theatre : 4");
			int choix=sc.nextInt();
			sc.nextLine();
			if(choix != 1 &&choix != 2 &&choix != 3 &&choix != 4 ){
				continue;
			}else{
				switch(choix){
				case 1:
					InfosSeanceFilm(prog);
					break;
				case 2:
					InfosSeanceTheatre(prog);
					break;
				case 3:
					InfosFilm(prog);
					break;
				case 4:
					InfosPiece(prog);
					break;
				}
				break;
			}
		}
	}

	//Fournit des informations sur les films
	//Appel�e par InfosProgSemaine
	public static void InfosFilm(ProgrammationSemaine prog){
		System.out.println(prog.toStringEnsTitreFilm());
		Film film=null;
		while(film==null){
			System.out.println("Titre du film?");
			String titref=sc.nextLine();
			film=prog.ChercherFilm(titref);
		}
		System.out.println("Taux de remplissage : "+prog.TauxRemplissageFilm(film)+"%"
				+"\nChiffre d'affaire : "+prog.ChiffredAffaireFilm(film)+"�");
	}

	//Fournit des informations sur les pieces de theatre
	//Appel�e par InfosProgSemaine
	public static void InfosPiece(ProgrammationSemaine prog){
		System.out.println(prog.toStringEnsTitrePiece());
		PieceTheatre piece=null;
		while(piece==null){
			System.out.println("Titre de la piece?");
			String titrep=sc.nextLine();
			piece=prog.ChercherPieceTheatre(titrep);
		}
		System.out.println("Taux de remplissage : "+prog.TauxRemplissagePiece(piece)+"%"
				+"\nChiffre d'affaire : "+prog.ChiffredAffairePiece(piece)+"�");
	}

	//Fournit des informations sur les seances de film
	//Appel�e par InfosProgSemaine
	public static void InfosSeanceFilm(ProgrammationSemaine prog){
		System.out.println(prog.toStringEnsTitreFilm());
		Film film=null;
		while(film==null){
			System.out.println("Titre du film?");
			String titref=sc.nextLine();
			film=prog.ChercherFilm(titref);
		}
		System.out.println(prog.mf.get(film).toStringEnsHoraireFilm());
		SeanceCinema seance=null;
		while(seance==null){
			System.out.println("Jour de la seance?");
			int jourf=sc.nextInt();
			sc.nextLine();
			Heure horaire;
			while(true){
				System.out.println("Horaire de la seance? (EX : 17h50)");
				String str = sc.nextLine();
				String[] strsplit�; 
				strsplit� = str.split("h");
				if(Integer.parseInt(strsplit�[0])<25 && Integer.parseInt(strsplit�[0])>=0 
						&& Integer.parseInt(strsplit�[1])>=0 && Integer.parseInt(strsplit�[1]) <60){	// 00h00 < Horaire < 23h59
					horaire=new Heure(Integer.parseInt(strsplit�[1]),Integer.parseInt(strsplit�[0]));
					break;
				}else{
					System.out.println("Horaire incorrect");
					continue;
				}
			}
			seance=prog.FilmJourHoraireDonn�(jourf,horaire,film);
		}
		System.out.println("Taux de remplissage :"+seance.tauxRemplissage()+"%"
				+"\nChiffre d'affaire pour l'ensemble des seances : "+prog.ChiffredAffaireFilm(film)+"�");
	}

	//Fournit des informations sur les seances de theatre
	//Appel�e par InfosProgSemaine
	public static void InfosSeanceTheatre(ProgrammationSemaine prog){
		System.out.println(prog.toStringEnsTitrePiece());
		PieceTheatre piece=null;
		while(piece==null){
			System.out.println("Titre de la piece?");
			String titrep=sc.nextLine();
			piece=prog.ChercherPieceTheatre(titrep);
		}
		System.out.println(prog.mt.get(piece).toStringEnsHorairePiece());
		SeanceTheatre seancet=null;
		while(seancet==null){
			System.out.println("Jour de la seance?");
			int jourt=sc.nextInt();
			sc.nextLine();
			seancet=prog.PieceJourDonn�(jourt,piece);
		}
		System.out.println("Taux de remplissage :"+seancet.tauxRemplissage()+"%"
				+"\nChiffre d'affaire pour l'ensemble des seances : "+prog.ChiffredAffairePiece(piece)+"�");
	}




	//Vente de places
	//Appel�e par ActionsSurProgrammations
	public static void VendreProgSemaine() {
		System.out.println("Tapez f pour vendre des places de cinema"
				+"\nTapez t pour vendre des places de theatre"
				+"\nTapez q pour quitter");
		String type=sc.nextLine();
		ProgrammationSemaine prog;
		while(true){
			//Evite l'erreur IndexOutOfBoundsException
			System.out.println("Pour quelle semaine voulez vous vendre des places?");
			int sem=sc.nextInt();
			if(sem>0 && sem<=lesProgrammations.size()){
				if(lesProgrammations.get(sem)!=null){//V�rifie si une programmation est affect�e a cet index
					prog=lesProgrammations.get(sem);
					break;
				}else{
					System.out.println("Semaine incorrect");
				}
			}else{
				System.out.println("Semaine incorrect");
			}
		}
		while(true){
			if(type.equalsIgnoreCase("q")){
				return;
			}
			if(type.equalsIgnoreCase("f")){
				VendreFilm(prog);
			}
			if (type.equalsIgnoreCase("t")){
				VendreTheatre(prog);
			}
		}
	}

	//Vente de places de cinema
	//Appel�e par VendreProgSemaine
	public static void VendreFilm(ProgrammationSemaine prog){
		System.out.println(prog.toStringEnsTitreFilm());
		Film film=null;
		while(film==null){
			System.out.println("Titre du film?");
			String titref=sc.nextLine();
			film=prog.ChercherFilm(titref);
		}
		System.out.println(prog.mf.get(film).toStringEnsHoraireFilm());
		SeanceCinema seance=null;
		while(seance==null){
			System.out.println("Jour de la seance?");
			int jourf=sc.nextInt();
			sc.nextLine();
			Heure horaire;
			while(true){
				System.out.println("Horaire de la seance? (EX : 17h50)");
				String str = sc.nextLine();
				String[] strsplit�; 
				strsplit� = str.split("h");

				if(Integer.parseInt(strsplit�[0])<25 && Integer.parseInt(strsplit�[0])>=0 
						&& Integer.parseInt(strsplit�[1])>=0 && Integer.parseInt(strsplit�[1]) <60){	// 00h00 < Horaire < 23h59
					horaire=new Heure(Integer.parseInt(strsplit�[1]),Integer.parseInt(strsplit�[0]));
					break;
				}else{
					System.out.println("Horaire incorrect");
					continue;
				}
			}
			seance=prog.FilmJourHoraireDonn�(jourf,horaire,film);
		}
		System.out.println("Nombre de places disponibles :"+seance.nbPlacesDispo());
		while (true){
			System.out.println("Tarif reduit? Oui : o  Non : n");
			String tnr=sc.nextLine();
			System.out.println("Combien de places voulez vous vendre?");
			int nbplaces=sc.nextInt();
			sc.nextLine();
			if(nbplaces>0 && seance.nbPlacesDispo()>nbplaces){
				if(tnr.equalsIgnoreCase("o"))
					seance.vendrePlacesTR(nbplaces);
				if(tnr.equalsIgnoreCase("n"))
					seance.vendrePlacesTN(nbplaces);
				break;
			}
		}
	}

	//Vente de places de theatre
	//Appel�e par VendreProgSemaine
	public static void VendreTheatre(ProgrammationSemaine prog){
		System.out.println(prog.toStringEnsTitrePiece());
		PieceTheatre piece=null;
		while(piece==null){
			System.out.println("Titre de la piece?");
			String titrep=sc.nextLine();
			piece=prog.ChercherPieceTheatre(titrep);
		}
		System.out.println(prog.mt.get(piece).toStringEnsHorairePiece());
		SeanceTheatre seance=null;
		while(seance==null){
			System.out.println("Jour de la seance?");
			int jourt=sc.nextInt();
			sc.nextLine();
			seance=prog.PieceJourDonn�(jourt,piece);
		}
		System.out.println("Nombre de places disponibles :"+seance.nbPlacesDispo());
		while (true){
			System.out.println("Places avec fauteuils? Oui : o  Non : n");
			String tnr=sc.nextLine();
			System.out.println("Combien de places voulez vous vendre?");
			int nbplaces=sc.nextInt();
			sc.nextLine();
			if(nbplaces>0 && seance.nbPlacesDispo()>nbplaces){
				if(tnr.equalsIgnoreCase("o"))
					seance.vendrePlacesFauteuil(nbplaces);
				if(tnr.equalsIgnoreCase("n"))
					seance.vendrePlacesTN(nbplaces);

				break;
			}
		}
	}




	//Modifications des programmations (Suppression et Ajout de seances)
	//Appel�e par ActionsSurProgrammations
	public static void ModificationProgSemaine() {
		ProgrammationSemaine modprog;
		while(true){
			//Evite l'erreur IndexOutOfBoundsException
			System.out.println("Quelle semaine voulez vous modifier?");
			int sem=sc.nextInt();
			if(sem>0 && sem<=lesProgrammations.size()){
				if(lesProgrammations.get(sem)!=null){//V�rifie si une programmation est affect�e a cet index
					modprog=lesProgrammations.get(sem);
					break;
				}else{
					System.out.println("Semaine incorrect");
				}
			}else{
				System.out.println("Semaine incorrect");
			}
		}
		System.out.println(modprog);//Appelle la toString() de ProgrammationSemaine
		while(true){
			System.out.println("Ajouter des seances a un film : 1"+
					"\nSupprimer des seances d'un film : 2"+
					"\nAjouter des seances a une piece de theatre : 3"+
					"\nSupprimer des seances d'une piece de theatre : 4");
			int choix = sc.nextInt();
			sc.nextLine();
			if (choix==1 || choix==2 || choix==3 || choix==4){
				switch (choix) {
				case 1 :
					AjoutSeanceFilm(modprog);
					break;

				case 2 :
					SupprSeanceFilm(modprog);
					break;

				case 3 :
					AjoutSeanceTheatre(modprog);
					break;

				case 4 :
					SupprSeanceTheatre(modprog);
					break;
				}
			}else{
				System.out.println("\nChoix incorrect\n");
				continue;
			}
			break;
		}
	}

	//Permet d'ajouter une seance de film
	//Appel�e par ModificationProgSemaine
	public static void AjoutSeanceFilm(ProgrammationSemaine modprog) {
		Film film=null;
		while(film==null){
			System.out.println("Quel est le titre du film auquel vous voulez ajouter une seance?");
			String titref=sc.nextLine();
			film=modprog.ChercherFilm(titref);
		}
		System.out.println("AJOUT DE SEANCES");
		SeanceCinema seance;
		while(true){
			while(true){
				Salle salle=null;
				while(salle==null){
					System.out.println("Nom de la salle?");
					String strsalle=sc.nextLine();
					salle=s.RechercherSalle(strsalle);
				}
				System.out.println("Jour? (de 1 � 7)");
				int jour = sc.nextInt();
				sc.nextLine();
				Heure horaire;
				while(true){
					System.out.println("Horaire du film? (EX: 17h45)");//On split la dur�e pour creer un objet de type Heure
					String str1 = sc.nextLine();
					String[] str1split�; 
					str1split� = str1.split("h");

					if(Integer.parseInt(str1split�[0])<25 && Integer.parseInt(str1split�[0])>=0 
							&& Integer.parseInt(str1split�[1])>=0 && Integer.parseInt(str1split�[1]) <60){	// 00h00 < Horaire < 23h59
						horaire=new Heure(Integer.parseInt(str1split�[1]),Integer.parseInt(str1split�[0]));
						break;
					}else{
						System.out.println("Horaire incorrect");
						continue;
					}
				}
				if(jour<=7 && jour>0 && salle!=null){
					seance=new SeanceCinema(jour, 0, horaire, salle, 0);
					break;
				}
				else
					System.out.println("V�rifiez les parametres");
			}
			System.out.println(film);
			System.out.println("\n"+seance);
			System.out.println("Ces parametres vous conviennent-ils? \n Oui : o - Non : n");
			String verif=sc.nextLine();
			if(verif.equalsIgnoreCase("o")){
				modprog.AjoutSeance(film, seance);
			}
			System.out.println("Voulez-vous ajouter d'autres seances? \n Oui : o - Non : n ");
			String aj=sc.nextLine();
			if(aj.equalsIgnoreCase("n")){
				break;
			}
		}
	}

	//Permet de supprimer une seance de film
	//Appel�e par ModificationProgSemaine
	public static void SupprSeanceFilm(ProgrammationSemaine modprog) {

		Film film=null;
		while(film==null){
			System.out.println("Quel est le titre de la piece pour laquelle vous voulez supprimer une seance?");
			String titref=sc.nextLine();
			film=modprog.ChercherFilm(titref);
		}
		SeanceCinema seancef = null;
		while(seancef==null){
			System.out.println(modprog.mf.get(film));
			System.out.println("Jour de la seance � supprimer?");
			int jour=sc.nextInt();
			Heure horaire;

			while(true){
				System.out.println("Horaire de la seance � supprimer? (EX : 17h50)");
				String str = sc.nextLine();
				String[] strsplit�; 
				strsplit� = str.split("h");
				if(Integer.parseInt(strsplit�[0])<25 && Integer.parseInt(strsplit�[0])>=0 
						&& Integer.parseInt(strsplit�[1])>=0 && Integer.parseInt(strsplit�[1]) <60){	// 00h00 < Horaire < 23h59
					horaire=new Heure(Integer.parseInt(strsplit�[1]),Integer.parseInt(strsplit�[0]));
					break;
				}else{
					System.out.println("Horaire incorrect");
					continue;
				}
			}
			seancef=modprog.FilmJourHoraireDonn�(jour,horaire,film);	//ProgSem --> Map<Film,Progf> --> Progf --> Seancef 
		}
		modprog.SupprimerSeanceFilm(film, seancef);
	}

	//Permet d'ajouter une seance de theatre
	//Appel�e par ModificationProgSemaine
	public static void AjoutSeanceTheatre(ProgrammationSemaine modprog) {

		PieceTheatre piece=null;
		while(piece==null){
			System.out.println("Quel est le titre de la piece pour laquelle vous voulez ajouter une seance?");
			String titrep=sc.nextLine();
			piece=modprog.ChercherPieceTheatre(titrep);
		}
		System.out.println("AJOUT DE SEANCES");
		SeanceTheatre seancetheatre;
		while(true){
			while(true){
				SalleTheatre salletheatre = null;
				while(salletheatre==null){
					System.out.println("Nom de la salle?");
					String strsalletheatre=sc.nextLine();
					salletheatre=st.RechercherSalleTheatre(strsalletheatre);
				}
				System.out.println("Jour? (de 1 a 7)");
				int jourtheatre = sc.nextInt();
				sc.nextLine();
				Heure horairepiece;
				while(true){
					System.out.println("Horaire de la seance?(EX: 17h30)");//On split la dur�e pour creer un objet de type Heure
					String str3 = sc.nextLine();
					String[] str3split�; 
					str3split� = str3.split("h");

					if(Integer.parseInt(str3split�[0])<25 && Integer.parseInt(str3split�[0])>=0 
							&& Integer.parseInt(str3split�[1])>=0 && Integer.parseInt(str3split�[1]) <60){	// 00h00 <= Horaire <= 23h59
						horairepiece=new Heure(Integer.parseInt(str3split�[1]),Integer.parseInt(str3split�[0]));
						break;
					}else{
						System.out.println("Horaire incorrect");
						continue;
					}
				}
				if(jourtheatre<=7 && jourtheatre>=1){ // 0 < Jour < 8
					seancetheatre=new SeanceTheatre(jourtheatre, 0, horairepiece, salletheatre, 0);
					break;
				}
				else
					System.out.println("V�rifiez les parametres");
			}
			System.out.println("\n"+seancetheatre);
			System.out.println("Ces parametres vous conviennent-ils? \n Oui : o - Non : n");
			String veriftheatre=sc.nextLine();
			if(veriftheatre.equalsIgnoreCase("o")){
				modprog.AjoutSeance(piece, seancetheatre);
			}
			System.out.println("Voulez-vous ajouter d'autres seances? \n Oui : o - Non : n ");
			String aj=sc.nextLine();
			if(aj.equalsIgnoreCase("n")){
				break;
			}
		}
	}

	//Permet de supprimer une seance de theatre
	//Appel�e par ModificationProgSemaine
	public static void SupprSeanceTheatre(ProgrammationSemaine modprog) {
		PieceTheatre piece=null;
		while(piece==null){
			System.out.println("Quel est le titre de la piece pour laquelle vous voulez supprimer une seance?");
			String titrep=sc.nextLine();
			piece=modprog.ChercherPieceTheatre(titrep);
		}
		SeanceTheatre seanceth = null;
		while(seanceth==null){
			System.out.println("Jour de la seance � supprimer?");
			int jour=sc.nextInt();
			seanceth=modprog.PieceJourDonn�(jour,piece);//ProgSem --> Map<Piece,Progth> --> Progth --> Seanceth 
		}
		modprog.SupprimerSeance(piece, seanceth);
	}




	//Creer une programmation de la semaine.
	//Appel�e par ActionsSurProgrammations
	public static void CreationProgSemaine() {
		int semaine;
		while (true){
			System.out.println("Pour quelle semaine voulez-vous creer une programmation?");
			int semainetest=sc.nextInt();
			if(semainetest>0){
				semaine=semainetest;
				break;
			}
			else System.out.println("Num�ro de semaine incorrect");
		}

		ProgrammationSemaine ProgSemaine=new ProgrammationSemaine(semaine);
		sc.nextLine();
		while (true){//Creation film
			System.out.println("- Tapez f pour creer un film");
			System.out.println("- Tapez t pour creer une piece de theatre");
			System.out.println("- Tapez q pour quitter");
			String type=sc.nextLine();
			if (type.equalsIgnoreCase("q")){
				break;
			}
			if (type.equalsIgnoreCase("f")){//Creation progFilmSemaine
				CreationProgSemaineFilm(ProgSemaine);
			}
			if (type.equalsIgnoreCase("t")){//Creation progTheatreSemaine
				CreationProgSemaineTheatre(ProgSemaine);
			}
		}
	}

	//Creer une programmation de la semaine pour le theatre.
	//Appel�e par CreationProgSemaine
	public static void CreationProgSemaineTheatre(ProgrammationSemaine ProgSemaine) {
		if(ProgSemaine.getSemaine()<=lesProgrammations.size()){
			if(lesProgrammations.get(ProgSemaine.getSemaine())!=null){//V�rifie si une programmation est deja affect�e a cet index
				System.out.println("Une programmation a deja �t� cr��e pour cette semaine");
				return;
			}
		}
		ProgrammationTheatre progtheatre=new ProgrammationTheatre();
		System.out.println("CREATION DE LA PIECE");
		System.out.println("Metteur en sc�ne?");
		String metteurensc = sc.nextLine();
		int nbentractes;
		while (true){
			System.out.println("Nombre d'entractes?");
			int nbentractestest=sc.nextInt();
			if(nbentractestest>0){
				nbentractes=nbentractestest;
				break;
			}
			else System.out.println("Nombre d'entractes incorrect");
		}
		sc.nextLine();
		System.out.println("Interpretes?");
		String comediens=sc.nextLine();
		System.out.println("Titre de la piece?");
		String titrepiece=sc.nextLine();
		PieceTheatre piece=new PieceTheatre(metteurensc,nbentractes,comediens,titrepiece);
		System.out.println(piece);
		System.out.println("AJOUT DE SEANCES");
		SeanceTheatre seancetheatre;
		while(true){
			while(true){
				SalleTheatre salletheatre = null;
				while(salletheatre==null){
					System.out.println("Nom de la salle?");
					String strsalletheatre=sc.nextLine();
					salletheatre=st.RechercherSalleTheatre(strsalletheatre);
				}
				System.out.println("Jour? (de 1 a 7)");
				int jourtheatre = sc.nextInt();
				sc.nextLine();
				Heure horairepiece;
				while(true){
					System.out.println("Horaire de la seance?(EX: 17h30)");//On split la dur�e pour creer un objet de type Heure
					String str3 = sc.nextLine();
					String[] str3split�; 
					str3split� = str3.split("h");
					if(Integer.parseInt(str3split�[0])<25 && Integer.parseInt(str3split�[0])>=0 
							&& Integer.parseInt(str3split�[1])>=0 && Integer.parseInt(str3split�[1]) <60){	// 00h00 < Horaire < 23h59
						horairepiece=new Heure(Integer.parseInt(str3split�[1]),Integer.parseInt(str3split�[0]));
						break;
					}else{
						System.out.println("Horaire incorrect");
						continue;
					}
				}
				if(jourtheatre<=7 && jourtheatre>=1 && salletheatre!=null){
					seancetheatre=new SeanceTheatre(jourtheatre, 0, horairepiece, salletheatre, 0);
					break;
				}
				else
					System.out.println("V�rifiez les parametres");
			}
			System.out.println(piece);
			System.out.println("\n"+seancetheatre);
			System.out.println("Ces parametres vous conviennent-ils? \n Oui : o - Non : n");
			String veriftheatre=sc.nextLine();
			if(veriftheatre.equalsIgnoreCase("o")){
				progtheatre.ajouterSeance(seancetheatre);
			}
			System.out.println("Voulez-vous ajouter d'autres seances? \n Oui : o - Non : n ");
			String aj=sc.nextLine();
			if(aj.equalsIgnoreCase("n")){
				break;
			}
		}
		ProgSemaine.AjoutPiece(piece, progtheatre);
		//Si on choisit la semaine 5 et que la taille de la List est inferieur a 5, 
		//la boucle affecte a chaque indice inferieur a 5 la valeur null
		//Permet d'eviter l'erreur IndexOutOfBoundsException
		if(lesProgrammations.size()<ProgSemaine.getSemaine()){ 
			for(int i = lesProgrammations.size();i<=ProgSemaine.getSemaine();i++){
				lesProgrammations.add(null);
			}
			lesProgrammations.add(ProgSemaine.getSemaine(),ProgSemaine);
		}
		else{
			if(lesProgrammations.get(ProgSemaine.getSemaine())==null){
				lesProgrammations.set(ProgSemaine.getSemaine(),ProgSemaine);
			}
		}
	}

	//Creer une programmation de la semaine pour le cinema.
	//Appel�e par CreationProgSemaine
	public static void CreationProgSemaineFilm(ProgrammationSemaine ProgSemaine) {
		if(ProgSemaine.getSemaine()<=lesProgrammations.size()){
			if(lesProgrammations.get(ProgSemaine.getSemaine())!=null){
				System.out.println("Une programmation a deja �t� cr��e pour cette semaine");
				return;
			}
		}
		ProgrammationFilm progfilm=new ProgrammationFilm();
		System.out.println("CREATION DU FILM");
		System.out.println("Realisateur?");
		String real = sc.nextLine();
		Heure duree;
		while(true){
			System.out.println("Dur�e du film? (EX: 1h40)");//On split la dur�e pour creer un objet de type Heure
			String str = sc.nextLine();
			String[] strsplit�; 
			strsplit� = str.split("h");
			if(Integer.parseInt(strsplit�[0])<25 && Integer.parseInt(strsplit�[0])>=0 
					&& Integer.parseInt(strsplit�[1])>=0 && Integer.parseInt(strsplit�[1]) <60){	// 00h00 < Horaire < 23h59
				duree=new Heure(Integer.parseInt(strsplit�[1]),Integer.parseInt(strsplit�[0]));
				break;
			}else{
				System.out.println("Horaire incorrect");
				continue;
			}
		}
		System.out.println("Interpretes?");
		String interpretes=sc.nextLine();
		System.out.println("Titre du film?");
		String titre=sc.nextLine();
		Film film=new Film(real,duree,interpretes,titre);
		System.out.println(film);
		System.out.println("AJOUT DE SEANCES");
		SeanceCinema seance;
		while(true){
			while(true){
				Salle salle=null;
				while(salle==null){
					System.out.println("Nom de la salle?");
					String strsalle=sc.nextLine();
					salle=s.RechercherSalle(strsalle);
				}
				System.out.println("Jour? (de 1 � 7)");
				int jour = sc.nextInt();
				sc.nextLine();
				Heure horaire;
				while(true){
					System.out.println("Horaire du film? (EX: 2h45)");//On split la dur�e pour creer un objet de type Heure
					String str1 = sc.nextLine();
					String[] str1split�; 
					str1split� = str1.split("h");
					if(Integer.parseInt(str1split�[0])<25 && Integer.parseInt(str1split�[0])>=0 
							&& Integer.parseInt(str1split�[1])>=0 && Integer.parseInt(str1split�[1]) <60){	// 00h00 < Horaire < 23h59
						horaire=new Heure(Integer.parseInt(str1split�[1]),Integer.parseInt(str1split�[0]));
						break;
					}else{
						System.out.println("Horaire incorrect");
						continue;
					}
				}
				if(jour<=7 && jour>0 && salle!=null){
					seance=new SeanceCinema(jour, 0, horaire, salle, 0);
					break;
				}
				else
					System.out.println("V�rifiez les parametres");
			}
			System.out.println(film);
			System.out.println("\n"+seance);
			System.out.println("Ces parametres vous conviennent-ils? \n Oui : o - Non : n");
			String verif=sc.nextLine();
			if(verif.equalsIgnoreCase("o")){
				progfilm.ajouterSeance(seance);
			}
			System.out.println("Voulez-vous ajouter d'autres seances? \n Oui : o - Non : n ");
			String aj=sc.nextLine();
			if(aj.equalsIgnoreCase("n")){
				break;
			}
		}
		ProgSemaine.AjoutFilm(film, progfilm);
		//Si on choisit la semaine 5 et que la taille de la List est inferieur a 5, 
		//la boucle affecte a chaque indice inferieur a 5 la valeur null
		//Permet d'eviter l'erreur IndexOutOfBoundsException
		if(lesProgrammations.size()<ProgSemaine.getSemaine()){
			for(int i = lesProgrammations.size();i<=ProgSemaine.getSemaine();i++){
				lesProgrammations.add(null);
			}
			lesProgrammations.add(ProgSemaine.getSemaine(),ProgSemaine);
		}
		else{
			if(lesProgrammations.get(ProgSemaine.getSemaine())==null){
				lesProgrammations.set(ProgSemaine.getSemaine(),ProgSemaine);
			}
		}
	}

}