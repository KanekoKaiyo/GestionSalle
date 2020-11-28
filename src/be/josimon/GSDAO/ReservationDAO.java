package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.josimon.GSPOJO.Organisateur;
import be.josimon.GSPOJO.Reservation;

public class ReservationDAO extends DAO<Reservation>{
	public ReservationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Reservation obj) {
		try {
			String sql = "INSERT INTO Reservation(acompte,solde,statut,prix,idPersonne) VALUES(?,?,?,?,?)";
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
		try {
			String sql = "UPDATE Reservation SET statut=? WHERE idReservation =?";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			pS.setString(1,"Payé");
			pS.setInt(2, obj.getIdRéservation());
			int row = pS.executeUpdate();
			if(row ==1) {
				obj.setStatut("Payé");
				return obj;
			} else {
				return null;
			}
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public Reservation Find(Reservation obj) {
		Reservation res = new Reservation();
		try {
			String sql = "SELECT * FROM Reservation WHERE idPersonne = ? AND Statut = ? AND Solde = ? AND Acompte = ?";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ps.setInt(1,obj.getOrga().getIdPersonne());
			ps.setString(2, obj.getStatut());
			ps.setDouble(3, obj.getSolde());
			ps.setDouble(4, obj.getAcompte());
			
			ResultSet result = ps.executeQuery();
			
			if(result.next()) {				
				res.setIdRéservation(result.getInt("idReservation"));
				res.setAcompte(result.getDouble("acompte"));
				res.setSolde(result.getDouble("solde"));
				res.setPrix(result.getDouble("prix"));
			}
			
			return res;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}
	@Override
	public List<Reservation> getAll(Reservation obj) {
		List<Reservation> list = new ArrayList<Reservation>();
		try {
			String sql = "SELECT * FROM Reservation";
			PreparedStatement pS = this.connect.prepareStatement(sql);
			ResultSet result = pS.executeQuery();
			while(result.next()) {
				Reservation res = new Reservation();
				Organisateur orga = new Organisateur();
				orga.setIdPersonne(result.getInt("idPersonne"));
				
				res.setIdRéservation(result.getInt("idReservation"));
				res.setAcompte(result.getDouble("acompte"));
				res.setSolde(result.getDouble("solde"));
				res.setStatut(result.getString("statut"));
				res.setPrix(result.getDouble("prix"));
				res.setOrga(orga);
				
				list.add(res);
			}
			
			return list;
		} catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Reservation> getAll() {
		// TODO Auto-generated method stub
		return null;
	}
}
