package be.josimon.GSPOJO;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import be.josimon.GSDAO.AbstractDAOFactory;
import be.josimon.GSDAO.DAO;

/**
 * @author Simon Jonathan
 * @version 0.1
 */
public class Spectacle {
	private int idSpectacle;
	private String titre;
	private List<Artiste> listArtiste = new ArrayList<Artiste>();
	private int placeParClient;
	private Configuration config;
	private PlanningSalle plan;
	
	static AbstractDAOFactory adf = AbstractDAOFactory.getFactory(AbstractDAOFactory.DAO_FACTORY);
	static DAO<Spectacle> specDAO = adf.getSpectacleDAO();
	
	
	public Spectacle(int idSpectacle, String titre, List<Artiste> listArtiste, int placeParClient,
			Configuration config, PlanningSalle plan) {
		this.idSpectacle = idSpectacle;
		this.titre = titre;
		this.listArtiste = listArtiste;
		this.placeParClient = placeParClient;
		this.config = config;
		this.plan = plan;
	}

	public Spectacle() {
	}

	public int getIdSpectacle() {
		return idSpectacle;
	}

	public void setIdSpectacle(int idSpectacle) {
		this.idSpectacle = idSpectacle;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public List<Artiste> getListArtiste() {
		return listArtiste;
	}

	public void setListArtiste(List<Artiste> listArtiste) {
		this.listArtiste = listArtiste;
	}

	public int getPlaceParClient() {
		return placeParClient;
	}

	public void setPlaceParClient(int placeParClient) {
		this.placeParClient = placeParClient;
	}

	public Configuration getConfig() {
		return config;
	}

	public void setConfig(Configuration config) {
		this.config = config;
	}
	
	public List<Configuration> getAllConfig(){
		this.config = new Configuration();
		return config.getAll();
	}
	
	public PlanningSalle getPlan() {
		return plan;
	}

	public void setPlan(PlanningSalle plan) {
		this.plan = plan;
	}

	public void addArt(Artiste art) {
		if(listArtiste.isEmpty()) {
			listArtiste.add(art);
		} else {
			if(listArtiste.contains(art)) {
				
			} else {
				listArtiste.add(art);
			}
		}
		
	}
	
	public boolean create() {
		return specDAO.Create(this);
	}
}
