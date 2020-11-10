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
public class PlanningSalle {
	AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	// Variable
	private int idPlanningSalle;
	private Date dateD�butReservation;
	private Date dateFinReservation;
	private Reservation reservation;
	
	// Getter Setter
	public int getIdPlanningSalle() {
		return idPlanningSalle;
	}
	public void setIdPlanningSalle(int idPlanningSalle) {
		this.idPlanningSalle = idPlanningSalle;
	}
	public Date getDateD�butReservation() {
		return dateD�butReservation;
	}
	public void setDateD�butReservation(Date dateD�butReservation) {
		this.dateD�butReservation = dateD�butReservation;
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
	public PlanningSalle(Date dateD�butReservation, Date dateFinReservation, Reservation reservation) {
		super();
		this.dateD�butReservation = dateD�butReservation;
		this.dateFinReservation = dateFinReservation;
		this.reservation = reservation;
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
}
