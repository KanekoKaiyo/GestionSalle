package be.josimon.GSDAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import be.josimon.GSPOJO.Configuration;

/**
 * @author Simon Jonathan
 * @version 0.1
 * 
 * 
 */
public class ConfigurationDAO extends DAO<Configuration>{

	public ConfigurationDAO(Connection conn) {
		super(conn);
	}

	@Override
	public boolean Create(Configuration obj) {
		return false;
	}

	@Override
	public boolean Delete(Configuration obj) {
		return false;
	}

	@Override
	public Configuration Update(Configuration obj) {
		return null;
	}

	@Override
	public Configuration Find(Configuration obj) {
		return null;
	}

	@Override
	public List<Configuration> getAll(Configuration obj) {
		return null;
	}

	@Override
	public List<Configuration> getAll() {
		List<Configuration> list = new ArrayList<Configuration>();
		try {
			String sql = "SELECT * FROM Configurations";
			PreparedStatement ps = this.connect.prepareStatement(sql);
			ResultSet result = ps.executeQuery();
			
			while(result.next()) {
				Configuration conf = new Configuration();
				conf.setIdConfiguration(result.getInt("idconfiguration"));
				conf.setType(result.getString("typeconf"));
				conf.setDescription(result.getString("descriptions"));
				
				list.add(conf);
			}
			return list;
		}catch(Exception ex) {
			ex.printStackTrace();
			return null;
		}
	}


}
