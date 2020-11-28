package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.josimon.GSPOJO.Gestionnaire;

public class GestionnaireDAO extends DAO<Gestionnaire> {

	public GestionnaireDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Gestionnaire obj) {
		try {
			String sql = "INSERT INTO Personne(nom,prenom,rue,numRue,cp,ville,discriminator,email,motDePasse) VALUES('" 
					+ obj.getNom() + "','" 
					+ obj.getPrenom() + "','" 
					+ obj.getRue() + "','" 
					+ obj.getNumRue() + "','"
					+ obj.getCp() + "','" 
					+ obj.getVille() + "','"
					+ "Gestionnaire" + "','"
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
	public boolean Delete(Gestionnaire obj) {
		return false;
	}

	@Override
	public Gestionnaire Update(Gestionnaire obj) {
		return null;
	}

	@Override
	public Gestionnaire Find(Gestionnaire obj) {
		return null;
	}

	@Override
	public List<Gestionnaire> getAll(Gestionnaire obj) {
		return null;
	}

	@Override
	public List<Gestionnaire> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}