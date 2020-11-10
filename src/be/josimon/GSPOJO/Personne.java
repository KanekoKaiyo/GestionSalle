package be.josimon.GSPOJO;

import be.josimon.hash.SHA;

/**
 * @author Simon Jonathan
 * @version 0.2
 * 
 * 
 */
public class Personne {
	// Variable
	protected int idPersonne;
	protected String nom;
	protected String prenom;
	protected String rue;
	protected int numRue;
	protected int cp;
	protected String ville;
	protected String role;
	protected String email;
	protected String motDePasse;
	
	// Getter & Setter
	public int getIdPersonne() {
		return idPersonne;
	}
	public void setIdPersonne(int idPersonne) {
		this.idPersonne = idPersonne;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public int getNumRue() {
		return numRue;
	}
	public void setNumRue(int numRue) {
		this.numRue = numRue;
	}
	public int getCp() {
		return cp;
	}
	public void setCp(int cp) {
		this.cp = cp;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	public String getMotDePasse() {
		return motDePasse;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public void setMotDePasse(String motDePasse) {
		this.motDePasse = SHA.hash(motDePasse);
	}
	// Constructor
	public Personne() { }
	
	public Personne(String nom, String prenom, String rue, int numRue, int cp, String ville,
			String email, String motDePasse) {
		this.nom = nom;
		this.prenom = prenom;
		this.rue = rue;
		this.numRue = numRue;
		this.cp = cp;
		this.ville = ville;
		this.email = email;
		this.motDePasse = SHA.hash(motDePasse);
	} 
}
