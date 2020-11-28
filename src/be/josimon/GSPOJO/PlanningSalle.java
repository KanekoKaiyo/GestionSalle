package be.josimon.GSPOJO;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ibm.icu.util.Calendar;

import org.joda.time.DateTime;
import org.joda.time.Interval;
import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;

/**
 * @author Simon Jonathan
 * @version 0.1
 * 
 * 
 */
public class PlanningSalle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	// Variable
	private int idPlanningSalle;
	private Date dateDébutReservation;
	private Date dateFinReservation;
	private Reservation reservation;
	
	private static int jourMois[] = {31, 28, 31, 30, 31, 30, 
	        31, 31, 30, 31, 30, 31};
	// Getter Setter
	public int getIdPlanningSalle() {
		return idPlanningSalle;
	}
	public void setIdPlanningSalle(int idPlanningSalle) {
		this.idPlanningSalle = idPlanningSalle;
	}
	public Date getDateDébutReservation() {
		return dateDébutReservation;
	}
	public void setDateDébutReservation(Date dateDébutReservation) {
		this.dateDébutReservation = dateDébutReservation;
	}
	public Date getDateFinReservation() {
		return dateFinReservation;
	}
	public void setDateFinReservation(Date dateFinReservation) {
		this.dateFinReservation = dateFinReservation;
	}
	public Reservation getReservation() {
		return reservation;
	}
	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}
	// Constructor
	public PlanningSalle(Date dateDébutReservation, Date dateFinReservation, Reservation reservation) {
		super();
		this.dateDébutReservation = dateDébutReservation;
		this.dateFinReservation = dateFinReservation;
		this.reservation = reservation;
	}
	public PlanningSalle() {
	}
	// Method
	public boolean CreatePlanningSalle() {
		try {
			DAO<PlanningSalle> planDAO = adf.getPlanningSalleDAO();
			boolean test = planDAO.Create(this);
			if(test)
				return true;
			else
				return false;
		} catch (Exception ex) {
			return false;
		}
	}
	public double CalculPrix() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.dateDébutReservation);
			
		// On calcul le nombre de jour et quel jour de la semaine la date de début ce trouve
		int nbJourEcart = CalculnbrJour()+1; // On ajoute un car si on reserve du 12/12=>12/12 c'est un jour de reservation
		int jourDepart = cal.get(Calendar.DAY_OF_WEEK);
		// On calcul le nombre de semaine et le reste de jour
		int nbSemaine = nbJourEcart / 7;
		int resteJour = nbJourEcart % 7;
				
		
		int nbVendredis = nbSemaine + ( resteJour + jourDepart - 7 > Calendar.WEDNESDAY ? 1 : 0 );
		int nbSamedis = nbSemaine + ( resteJour + jourDepart - 7 > Calendar.SUNDAY ? 1 : 0 );
		
		int nbJour = nbJourEcart-(nbVendredis+nbSamedis);
		
		// On retourne le nombre de jour sans les vendredi/samedi a 3000euros la journée et les vendredi+samedi a 4500 euros
		return (nbJour*3000)+((nbVendredis+nbSamedis)*4500);
	}
	private int CalculnbrJour() {
		Calendar cal = Calendar.getInstance();
		cal.setTime(this.dateDébutReservation);
		
		Calendar calFin = Calendar.getInstance();
		calFin.setTime(this.dateFinReservation);
		
		int nbr1 = 0;
		int nbr2 = 0;
		nbr1 = (cal.get(Calendar.YEAR) * 365) + cal.get(Calendar.DAY_OF_MONTH);
		
		for(int i = 0; i < cal.get(Calendar.MONTH); i++) {
			nbr1 = nbr1 + jourMois[i];
		}
		
		nbr1 = nbr1 + coutBissextiel(this.dateDébutReservation);
		
		nbr2 = (calFin.get(Calendar.YEAR) * 365) + calFin.get(Calendar.DAY_OF_MONTH);
		
		for(int i = 0; i < calFin.get(Calendar.MONTH); i++) {
			nbr2 = nbr2 + jourMois[i];
		}
		
		nbr2 = nbr2 + coutBissextiel(this.dateFinReservation);
		int temp = nbr2 - nbr1;
		return temp;
	}
	
	private int coutBissextiel(Date d) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(d);
		
		int annee = cal.get(Calendar.YEAR);
		
		if(cal.get(Calendar.MONTH) <= 2) {
			annee--;
		}
		int temp = (annee/4) - (annee/100) + (annee/400);
		 return temp;
	}
	public List<PlanningSalle> getAllReservation() {
		List<PlanningSalle> allRes = new ArrayList<PlanningSalle>();
		DAO<PlanningSalle> planDAO = adf.getPlanningSalleDAO();
		allRes = planDAO.getAll(this);
		return allRes;
	}
	
	public boolean Overlap(PlanningSalle datefin) {
		Interval inter1 = new Interval(new DateTime(this.getDateDébutReservation()),new DateTime(this.getDateFinReservation()));
		Interval inter2 = new Interval(new DateTime(datefin.getDateDébutReservation()), new DateTime(datefin.getDateFinReservation()));
		
		return inter1.overlaps(inter2);
	}
}
