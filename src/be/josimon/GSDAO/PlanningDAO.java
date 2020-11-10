package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

import be.josimon.GSPOJO.PlanningSalle;

public class PlanningDAO extends DAO<PlanningSalle>{

	public PlanningDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(PlanningSalle obj) {
		try {
			String sql = "INSERT INTO PlanningSalle VALUES(?,?,?)";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			pS.setDate(1,(java.sql.Date)obj.getDateDébutReservation());
			pS.setDate(2,(java.sql.Date)obj.getDateFinReservation());
			pS.setInt(3,obj.getReservation().getIdRéservation());
			
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
	public boolean Delete(PlanningSalle obj) {
		return false;
	}

	@Override
	public PlanningSalle Update(PlanningSalle obj) {
		return null;
	}

	@Override
	public PlanningSalle Find(PlanningSalle obj) {
		return null;
	}

	@Override
	public List<PlanningSalle> getAll() {
		return null;
	}
}
