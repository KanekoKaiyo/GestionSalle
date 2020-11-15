package be.josimon.GSPOJO;

import java.util.Date;

import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;

/**
 * @author Simon Jonathan
 * @version 0.1
 * 
 * 
 */
public class Reservation {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	// Variable
	private int idR�servation;
	private double acompte;
	private double solde;
	private String statut;
	private double prix;
	private Organisateur orga;
	// Getter Setter
	public int getIdR�servation() {
		return idR�servation;
	}
	public void setIdR�servation(int idR�servation) {
		this.idR�servation = idR�servation;
	}
	public double getAcompte() {
		return acompte;
	}
	public void setAcompte(double acompte) {
		this.acompte = acompte;
	}
	public double getSolde() {
		return solde;
	}
	public void setSolde(double solde) {
		this.solde = solde;
	}
	public String getStatut() {
		return statut;
	}
	public void setStatut(String statut) {
		this.statut = statut;
	}
	public Double getPrix() {
		return prix;
	}
	public void setPrix(Double prix) {
		this.prix = prix;
	}
	public Organisateur getOrga() {
		return orga;
	}
	public void setOrga(Organisateur orga) {
		this.orga = orga;
	}
	// Constructor
	public Reservation() { }
	public Reservation(double acompte, double solde, String statut, Double prix, Organisateur orga) {
		this.acompte = acompte;
		this.solde = solde;
		this.statut = statut;
		this.prix = prix;
		this.orga = orga;
	}
	// Methode
	public boolean CreateReservation() {
		DAO<Reservation> resDAO = adf.getReservationDAO();
		boolean test = resDAO.Create(this);
		if(test)
			return true;
		else 
			return false;				
	}
	public PlanningSalle emptySalle() {
		PlanningSalle ps = new PlanningSalle();
		ps.setReservation(this);
		return ps;
	}
	public boolean createPlanningSalle(Date ddebut,Date dfin) {
		// La reservation va cr�er un planning avant de le mettre dans la db
		try {
			PlanningSalle plSa = new PlanningSalle(ddebut,dfin,this);
			// On va l'ajouter dans la base de donn�e si c'est possible
			boolean test = plSa.CreatePlanningSalle();
			if(test) 
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}
	public void FindiD() {
		// Fonction pour fix� l'id de l'objet apr�s sa cr�ation
		try {
			DAO<Reservation> resDAO = adf.getReservationDAO();
			this.setIdR�servation(resDAO.Find(this).getIdR�servation());
		} catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public Object[][] getReservation() {
		Object[][] allRes = new Object[2][100];
		PlanningSalle pls = this.emptySalle();
		allRes = pls.getAllReservation();
		return allRes;
	}
}