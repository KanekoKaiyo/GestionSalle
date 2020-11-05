package be.josimon.GSPOJO;

public class Gestionnaire extends Personne{
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
	public Gestionnaire() {
		super();
		this.role = "Gestionnaire";
	}

	public Gestionnaire(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Gestionnaire";
	}
	
	
}
