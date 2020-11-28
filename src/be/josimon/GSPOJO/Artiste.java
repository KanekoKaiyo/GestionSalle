package be.josimon.GSPOJO;

import java.util.List;

import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;

public class Artiste extends Personne{
	static AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	static DAO<Artiste> artDAO = adf.getArtisteDAO();
	// Constructor
	public Artiste() {
		super();
		this.role = "Artiste";
	}
	public Artiste(Personne pr) {
		// Ce consturcteur permet de caster l'objet Personne en Client, ce qui n'est pas possible avec un cast classique
		super(pr.getNom(),pr.getPrenom(),pr.getRue(),pr.getNumRue(),pr.getCp(),pr.getVille(),pr.getEmail(),pr.getMotDePasse());
		this.role = "Artiste";
	}
	public Artiste(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Artiste";
	}
	
	public List<Artiste> getAll(){
		return artDAO.getAll();
	}
}