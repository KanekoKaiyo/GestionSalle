package be.josimon.GSPOJO;

import java.util.List;

import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;

/**
 * @author Simon Jonathan
 * @version 0.1
 * 
 * Classe Configuration corresponds au possibilité d'aménagement de la salle : debout, assis concert/cirque
 */
public class Configuration {
	private int idConfiguration;
	private String type;
	private String description;
	
	static AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	static DAO<Configuration> confDAO = adf.getConfigurationDAO();
	
	public Configuration() {};
	
	public Configuration(String type) {
		this.type = type;
	}
	
	public Configuration(int idConfiguration, String type, String description) {
		this.idConfiguration = idConfiguration;
		this.type = type;
		this.description = description;
	}

	public int getIdConfiguration() {
		return idConfiguration;
	}

	public void setIdConfiguration(int idConfiguration) {
		this.idConfiguration = idConfiguration;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public List<Configuration> getAll(){
		return confDAO.getAll();
	}
	
}
