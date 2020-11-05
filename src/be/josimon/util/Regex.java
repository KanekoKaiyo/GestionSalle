package be.josimon.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {
	private static String regexmail = "^\\S+@\\S+\\.\\S+$";
	private static Pattern patternmail = Pattern.compile(regexmail);
	
	private static String regexlettre = "^[a-zA-Z]+$";
	private static Pattern patternlettre = Pattern.compile(regexlettre);
	
	private static String regexcp = "^[0-9]{4}$";
	private static Pattern patterncp = Pattern.compile(regexcp);
	
	private static String regexnum = "^[0-9]{3}$";
	private static Pattern patternnum = Pattern.compile(regexnum);
	
	private static String regexpass = "^.(?=.{8,})((?=.*[!@#$%^&*()=+{};:,<.>]){1,})((?=.*\\\\\\\\d){0,})((?=.*[a-z]){0,1})((?=.*[A-Z]){0,1}).*$";
	private static Pattern patternpass = Pattern.compile(regexpass);
	
	public static boolean verifMail(String mail) {
		Matcher matchermail = patternmail.matcher(mail);
		if(matchermail.matches() == true)
			return true;
		else
			return false;
	}
	
	public static boolean verifPass(String pass) {
		Matcher matcherpass = patternpass.matcher(pass);
		if(matcherpass.matches() == true)
			return true;
		else
			return false;
	}
	
	public static boolean verifLettre(String str) {
		Matcher matcherlettre = patternlettre.matcher(str);
		if(matcherlettre.matches() == true)
			return true;
		else
			return false;
	}
	
	public static boolean verifNum(String num) {
		Matcher matchernum = patternnum.matcher(num);
		if(matchernum.matches() == true)
			return true;
		else
			return false;
	}
	
	public static boolean verifCP(String cp) {
		Matcher matchercp = patterncp.matcher(cp);
		if(matchercp.matches() == true)
			return true;
		else
			return false;
	}
	
}