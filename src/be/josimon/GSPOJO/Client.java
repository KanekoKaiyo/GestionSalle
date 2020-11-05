package be.josimon.GSPOJO;

/**
 * @author Simon Jonathan
 * @version 0.2
 */
public class Client extends Personne{
	// Variable
	private String role;
	
	// Getter & Setter
	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}
	// Constructor
	public Client() {
		super();
		this.role = "Client";
	}
	public Client(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email,String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Client";
	}
	
	// Methods
	
	
	
}
