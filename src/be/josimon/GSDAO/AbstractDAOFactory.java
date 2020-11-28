package be.josimon.GSDAO;

import be.josimon.GSPOJO.*;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	
	public abstract DAO<Client> getClientDAO();
	
	public abstract DAO<Organisateur> getOrganisateurDAO();
	
	public abstract DAO<Artiste> getArtisteDAO();
		
	public abstract DAO<Gestionnaire> getGestionnaireDAO();
	
	public abstract DAO<Personne> getPersonneDAO();
	
	public abstract DAO<Reservation> getReservationDAO();
	
	public abstract DAO<PlanningSalle> getPlanningSalleDAO();
	
	public abstract DAO<Spectacle> getSpectacleDAO();
	
	public abstract DAO<Configuration> getConfigurationDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}


}
