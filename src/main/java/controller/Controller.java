package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import model.Chat;
import model.User;

public class Controller {
	
	public static boolean validNick(String nick) {
		String regex = "^[A-Za-z]\\w{3,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(nick);
		
		return m.matches();
	}
	
	public static void error (String header, String context) {
		Alert alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Error");
		alert.setHeaderText(header);
		alert.setContentText(context);
		alert.showAndWait();
	}
	
	public static void info (String header) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText(header);
		alert.show();
	}
	
	public static void setNick(User nick) {
		User useraux = new User();
		useraux = nick;
	}
	
	public static void setChat(Chat name) {
		Chat chataux = new Chat(null);
		chataux = name;
	}

}
