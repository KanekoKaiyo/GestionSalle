package be.josimon.GSDAO;

import java.sql.Connection;

import be.josimon.GSConnect.SalleConnection;
import be.josimon.GSPOJO.Artiste;
import be.josimon.GSPOJO.Client;
import be.josimon.GSPOJO.Gestionnaire;
import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.Personne;
import be.josimon.GSPOJO.PlanningSalle;
import be.josimon.GSPOJO.Reservation;

public class DAOFactory extends AbstractDAOFactory{
	
	protected static final Connection conn = SalleConnection.getInstance();

	public DAO<Client> getClientDAO() {
		return new ClientDAO(conn);
	}

	public DAO<Organisateur> getOrganisateurDAO() {
		return new OrganisateurDAO(conn);
	}

	public DAO<Artiste> getArtisteDAO() {
		return new ArtisteDAO(conn);
	}

	public DAO<Gestionnaire> getGestionnaireDAO() {
		return new GestionnaireDAO(conn);
	}
	
	public DAO<Personne> getPersonneDAO() {
		return new PersonneDAO(conn);
	}
	public DAO<Reservation> getReservationDAO() {
		return new ReservationDAO(conn);
	}

	public DAO<PlanningSalle> getPlanningSalleDAO() {
		return new PlanningDAO(conn);
	}
}