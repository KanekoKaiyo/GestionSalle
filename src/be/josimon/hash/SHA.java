package be.josimon.hash;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SHA {
	public static String hash(String input) {
		try {
			// Selection de l'algo de hashage
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			
			// Appel de la méthode digest pour calculer le digest de l'input string, on a besoin d'un array de byte
			byte[] messageDigest = md.digest(input.getBytes());
			
			// Convertion du byte array en BigInteger
			BigInteger no = new BigInteger(1,messageDigest);
			
			// Convertion du messageDigest en valeur hexa
			String hashtext = no.toString(16);
			
			// on ajoute de 0 pour que la valeur sois en 32bits
			while(hashtext.length() < 32) {
				hashtext = "0" + hashtext;
			}
			// on revoit le message hash
			return hashtext;
		} catch(NoSuchAlgorithmException e) {
			throw new RuntimeException(e);
		}
	}
}