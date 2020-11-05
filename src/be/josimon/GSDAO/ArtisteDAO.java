package be.josimon.GSDAO;

import java.sql.Connection;
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
		return false;
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
