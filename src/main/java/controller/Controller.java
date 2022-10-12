package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.scene.control.Alert;
import model.Chat;
import model.User;

public class Controller {
	private static User user;
	private static Chat chat;
	
	public static void setUser(User aux) {
		user=aux;
	}
	public static void setChat(Chat aux) {
		chat=aux;
	}
	
	public static User getUser() {
		return user;
	}
	public static Chat getChat() {
		return chat;
	}
	
	
	
	public static boolean validNick(String nick) {
		String regex = "^[A-Za-z]{3,10}$";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(nick);
		
		return m.matches();
	}
	
	public static boolean validMessage(String message) {
		if(message.length()>=1) {
			return true;
		} else {
			return false;
		}
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

}