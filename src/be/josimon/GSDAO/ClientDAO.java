package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.util.List;

import be.josimon.GSPOJO.Client;

/**
 * @author Simon Jonathan
 * @version 0.2 
 */
public class ClientDAO extends DAO<Client>{

	public ClientDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Client obj) {
		try {
			String sql = "INSERT INTO Personne(nom,prenom,rue,numRue,cp,ville,email,motDePasse) VALUES('" 
					+ obj.getNom() + "'," 
					+ obj.getPrenom() + "'," 
					+ obj.getRue() + "'," 
					+ obj.getNumRue() + "',"
					+ obj.getCp() + "'," 
					+ obj.getVille() + "',"
					+ obj.getEmail() + "'," 
					+ obj.getMotDePasse() + "')";
			this.connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY).executeQuery(sql);
			return true;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean Delete(Client obj) {
		return false;
	}

	@Override
	public Client Update(Client obj) {
		return new Client();
	}


	@Override
	public List<Client> getAll() {
		return null;
	}

	@Override
	public Client Find(Client obj) {
		return null;
	}
}
