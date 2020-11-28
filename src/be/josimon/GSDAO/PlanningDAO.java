package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.josimon.GSPOJO.PlanningSalle;
import be.josimon.GSPOJO.Reservation;

public class PlanningDAO extends DAO<PlanningSalle>{

	public PlanningDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(PlanningSalle obj) {
		try {
			String sql = "INSERT INTO PlanningSalle (datedebut,datefin,idReservation) VALUES(?,?,?)";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			pS.setDate(1, new java.sql.Date(obj.getDateD�butReservation().getTime()));
			pS.setDate(2,new java.sql.Date(obj.getDateFinReservation().getTime()));
			pS.setInt(3,obj.getReservation().getIdR�servation());
			
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

	public List<PlanningSalle> getAll(){
		List<PlanningSalle> list = new ArrayList<PlanningSalle>();
		try {
			String sql = "SELECT * FROM PlanningSalle";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				PlanningSalle plan = new PlanningSalle();
				plan.setIdPlanningSalle(result.getInt("idplanningsalle"));
				plan.setDateD�butReservation(result.getDate("datedebut"));
				plan.setDateFinReservation(result.getDate("datefin"));
				
				list.add(plan);
			}
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	
	@Override
	public List<PlanningSalle> getAll(PlanningSalle obj) {
		List<PlanningSalle> list = new ArrayList<PlanningSalle>();
		try {
			String sql = "SELECT * FROM PlanningSalle INNER JOIN Reservation ON PlanningSalle.idReservation = Reservation.idReservation WHERE Reservation.idPersonne=?";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ps.setInt(1, obj.getReservation().getOrga().getIdPersonne());
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {
				PlanningSalle plan = new PlanningSalle();
				Reservation res = new Reservation();
				
				res.setStatut(result.getString("statut"));
				res.setAcompte(result.getDouble("acompte"));
				res.setSolde(result.getDouble("solde"));
				res.setPrix(result.getDouble("prix"));
				res.setIdR�servation(result.getInt("idReservation"));
				
				plan.setReservation(res);
				plan.setDateD�butReservation(result.getDate("datedebut"));
				plan.setDateFinReservation(result.getDate("datefin"));
				plan.setIdPlanningSalle(result.getInt("idplanningsalle"));
				list.add(plan);
			}
			
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
}
