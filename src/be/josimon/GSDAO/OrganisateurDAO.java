package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.josimon.GSPOJO.Organisateur;

public class OrganisateurDAO extends DAO<Organisateur> {

	public OrganisateurDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Organisateur obj) {
		try {
			String sql = "INSERT INTO Personne(nom,prenom,rue,numRue,cp,ville,discriminator,email,motDePasse) VALUES('" 
					+ obj.getNom() + "','" 
					+ obj.getPrenom() + "','" 
					+ obj.getRue() + "','" 
					+ obj.getNumRue() + "','"
					+ obj.getCp() + "','" 
					+ obj.getVille() + "','"
					+ "Organisateur" + "','"
					+ obj.getEmail() + "','" 
					+ obj.getMotDePasse() + "')";
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean Delete(Organisateur obj) {
		return false;
	}

	@Override
	public Organisateur Update(Organisateur obj) {
		return null;
	}

	@Override
	public Organisateur Find(Organisateur obj) {
		return null;
	}

	@Override
	public List<Organisateur> getAll(Organisateur obj) {
		return null;
	}

	@Override
	public List<Organisateur> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}