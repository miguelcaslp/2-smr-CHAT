package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Controller {
	
	public static boolean validNick(String nick) {
		String regex = "^[A-Za-z]\\w{3,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(nick);
		
		return m.matches();
	}

}
