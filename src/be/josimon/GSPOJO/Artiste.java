package be.josimon.GSPOJO;

public class Artiste extends Personne{
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
	public Artiste() {
		super();
		this.role = "Artiste";
	}

	public Artiste(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Artiste";
	}
	

	
}
