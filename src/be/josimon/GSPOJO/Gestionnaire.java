package be.josimon.GSPOJO;

public class Gestionnaire extends Personne{
	// Constructor
	public Gestionnaire() {
		super();
		this.role = "Gestionnaire";
	}
	public Gestionnaire(Personne pr) {
		// Ce consturcteur permet de caster l'objet Personne en Client, ce qui n'est pas possible avec un cast classique
		super(pr.getNom(),pr.getPrenom(),pr.getRue(),pr.getNumRue(),pr.getCp(),pr.getVille(),pr.getEmail(),pr.getMotDePasse());
		this.role = "Client";
	}
	public Gestionnaire(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		super(nom, prenom, rue, numRue, cp, ville, email, motDePasse);
		this.role = "Gestionnaire";
	}
	
	
}
