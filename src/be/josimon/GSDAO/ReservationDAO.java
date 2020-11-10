package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import be.josimon.GSPOJO.Reservation;

public class ReservationDAO extends DAO<Reservation>{
	public ReservationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Reservation obj) {
		try {
			String sql = "INSERT INTO Reservation VALUES(?,?,?,?,?)";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			pS.setDouble(1,obj.getAcompte());
			pS.setDouble(2,obj.getSolde());
			pS.setString(3,obj.getStatut());
			pS.setDouble(4,obj.getPrix());
			pS.setInt(5,obj.getOrga().getIdPersonne());
			int row = pS.executeUpdate();
			if(row == 1) 
				return true;
			else
				return false;
		} catch(Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
	@Override
	public boolean Delete(Reservation obj) {
		return false;
	}
	@Override
	public Reservation Update(Reservation obj) {
		return null;
	}
	@Override
	public Reservation Find(Reservation obj) {
		return null;
	}
	@Override
	public List<Reservation> getAll() {
		return null;
	}
}
