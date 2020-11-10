package be.josimon.GSDAO;

import be.josimon.GSPOJO.Artiste;
import be.josimon.GSPOJO.Client;
import be.josimon.GSPOJO.Gestionnaire;
import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.Personne;

public abstract class AbstractDAOFactory {
	public static final int DAO_FACTORY = 0;
	
	public abstract DAO<Client> getClientDAO();
	
	public abstract DAO<Organisateur> getOrganisateurDAO();
	
	public abstract DAO<Artiste> getArtisteDAO();
		
	public abstract DAO<Gestionnaire> getGestionnaireDAO();
	
	public abstract DAO<Personne> getPersonneDAO();
	
	public static AbstractDAOFactory getFactory(int type){
		switch(type){
		case DAO_FACTORY:
			return new DAOFactory();
			default:
				return null;
		}
	}
}
