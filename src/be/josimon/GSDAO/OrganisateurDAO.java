package be.josimon.GSDAO;

import java.sql.Connection;
import java.util.List;

import be.josimon.GSPOJO.Organisateur;

public class OrganisateurDAO extends DAO<Organisateur> {

	public OrganisateurDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Organisateur obj) {
		return false;
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
	public List<Organisateur> getAll() {
		return null;
	}
}