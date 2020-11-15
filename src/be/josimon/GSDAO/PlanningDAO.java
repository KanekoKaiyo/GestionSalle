package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.josimon.GSPOJO.PlanningSalle;

public class PlanningDAO extends DAO<PlanningSalle>{

	public PlanningDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(PlanningSalle obj) {
		try {
			String sql = "INSERT INTO PlanningSalle (datedebut,datefin,idReservation) VALUES(?,?,?)";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			pS.setDate(1, new java.sql.Date(obj.getDateDébutReservation().getTime()));
			pS.setDate(2,new java.sql.Date(obj.getDateFinReservation().getTime()));
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
		List<PlanningSalle> list = new ArrayList<PlanningSalle>();
		try {
			String sql = "SELECT * FROM PlanningSalle";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			ResultSet result = pS.executeQuery();
			while(result.next()) {
				PlanningSalle pl = new PlanningSalle();
				pl.setDateDébutReservation(result.getDate("datedebut"));
				pl.setDateFinReservation(result.getDate("datefin"));
				list.add(pl);
			}
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
