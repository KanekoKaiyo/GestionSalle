package be.josimon.GSPOJO;

import java.util.Set;

/**
 * @author Simon Jonathan
 * @version 0.1
 * 
 * Classe Commande qui corresponds à la commande d'un client 
 */
public class Commande {
	private String modePayement;
	private String modeLivraison;
	private double coutTotal;
	
	private Set<Place> ticket;
	
}
