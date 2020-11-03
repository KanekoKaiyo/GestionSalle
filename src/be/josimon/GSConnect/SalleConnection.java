package be.josimon.GSConnect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JOptionPane;

public class SalleConnection {
	
	private static Connection instance = null;
	
	private SalleConnection() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			instance = DriverManager.getConnection("jdbc:oracle:thin:@193.190.64.10:1522:XEPDB1","student03_01","080818");
		} catch(ClassNotFoundException ex) {
			JOptionPane.showMessageDialog(null, "Classe de driver introuvable" + ex.getMessage());
			System.exit(0);
		} catch (SQLException ex1) {
			JOptionPane.showMessageDialog(null, "Erreur JDBC : " + ex1.getMessage());
		}
		if(instance == null) {
            JOptionPane.showMessageDialog(null, "La base de données est inaccessible, fermeture du programme.");
            System.exit(0);
		}
	}
	
	public static Connection getInstance() {
		if(instance == null){
			new SalleConnection();
		}
		return instance;
	}
}