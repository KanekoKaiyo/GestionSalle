package be.josimon.GSPOJO;

import java.util.Date;
import java.util.SortedSet;
import java.util.TreeSet;

public class Organisateur extends Personne{
	SortedSet<Reservation> listReservation = new TreeSet<Reservation>();
	// Constructor
	public Organisateur() {
		super();
		this.role = "Organisateur";
	}
	public Organisateur(Personne pr) {
		// Ce consturcteur permet de caster l'objet Personne en Client, ce qui n'est pas possible avec un cast classique
		super(pr.getNom(),pr.getPrenom(),pr.getRue(),pr.getNumRue(),pr.getCp(),pr.getVille(),pr.getEmail(),pr.getMotDePasse());
		this.role = "Organisateur";
	}
	public Organisateur(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Organisateur";
	}
	
	// Method
	public boolean createReservation(double acompte, double solde, String statut, Double prix,Date dateDébutReservation, Date dateFinReservation) {
		// L'organisateur crée un objet reservation avant de le mettre dans la base de donnée
		try {
			Reservation res = new Reservation(acompte,solde,statut,prix,this);
			// On va l'ajouter dans la base de donnée si c'est possible
			boolean test = res.CreateReservation();
			if(test) {
				// On test si la reservation a bien été ajouté, si c'est le cas on va demander a la classe Reservation de créer les plannings lié au date
				boolean test2 = res.createPlanningSalle(dateDébutReservation,dateFinReservation);
				// Si on reçoit true alors la reservation et le planning auront bien été ajouté dans la DB
				if(test2)
					return true;
				else
					return false;
			} else {
				return false;
			}
		} catch (Exception ex) {
			return false;	
		}
	}
}