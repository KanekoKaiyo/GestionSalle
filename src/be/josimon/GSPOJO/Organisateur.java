package be.josimon.GSPOJO;

import java.util.Date;

public class Organisateur extends Personne{
	// Constructor
	public Organisateur() {
		super();
		this.role = "Organisateur";
	}
	public Organisateur(Personne pr) {
		// Ce consturcteur permet de caster l'objet Personne en Client, ce qui n'est pas possible avec un cast classique
		super(pr.getIdPersonne(),pr.getNom(),pr.getPrenom(),pr.getRue(),pr.getNumRue(),pr.getCp(),pr.getVille(),pr.getEmail(),pr.getMotDePasse());
		this.role = "Organisateur";
	}
	public Organisateur(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Organisateur";
	}
	
	// Method
	public boolean createReservation(double acompte, double solde, String statut, Double prix,Date dateD�butReservation, Date dateFinReservation) {
		// L'organisateur cr�e un objet reservation avant de le mettre dans la base de donn�e
		try {
			Reservation res = new Reservation(acompte,solde,statut,prix,this);
			// On va l'ajouter dans la base de donn�e si c'est possible
			boolean test = res.CreateReservation();
			if(test) {
				// Si la cr�ation c'est bien faites, il faut demander a la DB de nous renvoy� les informations car il nous manque l'id !
				res.FindiD();
				if(test) {
					// On test si la reservation a bien �t� ajout�, si c'est le cas on va demander a la classe Reservation de cr�er les plannings li� au date
					boolean test2 = res.createPlanningSalle(dateD�butReservation,dateFinReservation);
					// Si on re�oit true alors la reservation et le planning auront bien �t� ajout� dans la DB
					if(test2)
						return true;
					else
						return false;
				} else {
					return false;
				}
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;	
		}
	}
	
	public Reservation emptyRes() {
		Reservation res = new Reservation();
		res.setOrga(this);
		return res;
	}
	
	public Object[][] getReservation() {
		Object[][] allRes = new Object[2][100];
		Reservation res = this.emptyRes();
		allRes = res.getReservation();
		return allRes;
	}
}