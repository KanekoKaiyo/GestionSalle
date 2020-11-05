package be.josimon.GSDAO;

import java.sql.Connection;
import java.util.List;

import be.josimon.GSPOJO.Gestionnaire;

public class GestionnaireDAO extends DAO<Gestionnaire> {

	public GestionnaireDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Gestionnaire obj) {
		return false;
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
	public List<Gestionnaire> getAll() {
		return null;
	}
}