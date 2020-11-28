package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import be.josimon.GSPOJO.Spectacle;

public class SpectacleDAO extends DAO<Spectacle>{

	public SpectacleDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Spectacle obj) {
		try {
			String sql1 = "SELECT idPlanningSalle FROM PlanningSalle WHERE idReservation=?";
			PreparedStatement pS = this.connect.prepareStatement(sql1);
			pS.setInt(1, obj.getPlan().getReservation().getIdRéservation());
			ResultSet result = pS.executeQuery();
			
			if(result.next()) {
				int idplan = result.getInt("idPlanningSalle");
			}
			
			String sql = "INSERT INTO Spectacle(idSpectacle,titre,NBRPLACEPC,idplanningsalle,idconfiguration) VALUES(?,?,?,?,?)";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ps.setInt(1, obj.getIdSpectacle());
			ps.setString(2, obj.getTitre());
			ps.setInt(3, obj.getPlaceParClient());
			ps.setInt(4, obj.getPlan().getIdPlanningSalle());
			ps.setInt(5, obj.getConfig().getIdConfiguration());
			
			int row = ps.executeUpdate();
			if(row ==1)
				return true;
			else
				return false;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean Delete(Spectacle obj) {
		return false;
	}

	@Override
	public Spectacle Update(Spectacle obj) {
		return null;
	}

	@Override
	public Spectacle Find(Spectacle obj) {
		return null;
	}

	@Override
	public List<Spectacle> getAll(Spectacle obj) {
		return null;
	}

	@Override
	public List<Spectacle> getAll() {
		return null;
	}
}
