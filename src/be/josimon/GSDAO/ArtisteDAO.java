package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.josimon.GSPOJO.Artiste;

/**
 * @author Simon Jonathan
 * @version 0.1
 * 
 * 
 */
public class ArtisteDAO extends DAO<Artiste> {

	public ArtisteDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Artiste obj) {
		try {
			String sql = "INSERT INTO Personne(nom,prenom,rue,numRue,cp,ville,discriminator,email,motDePasse) VALUES('" 
					+ obj.getNom() + "','" 
					+ obj.getPrenom() + "','" 
					+ obj.getRue() + "','" 
					+ obj.getNumRue() + "','"
					+ obj.getCp() + "','" 
					+ obj.getVille() + "','"
					+ "Artiste" + "','"
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
	public boolean Delete(Artiste obj) {
		return false;
	}

	@Override
	public Artiste Update(Artiste obj) {
		return null;
	}

	@Override
	public Artiste Find(Artiste obj) {
		return null;
	}

	@Override
	public List<Artiste> getAll() {
		return null;
	}
	
	
}
