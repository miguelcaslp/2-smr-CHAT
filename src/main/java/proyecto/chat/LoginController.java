package proyecto.chat;

import java.io.IOException;

import Dao.UsersDao;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;

public class LoginController {
	@FXML
	private TextField nick;
	
	@FXML
	private Button login;

    @FXML
    private void switchToNext() throws IOException {
        App.setRoot("chats");
    }
    
    @FXML
    private void validNick() throws IOException {
    	String name= nick.getText();
    	boolean valid = Controller.validNick(name);
    	if(valid) {
    		UsersDao us=new UsersDao();
    		name= nick.getText().toLowerCase();
    		if(us.addUser(new User(name))) {
    			Controller.setUser(new User(name));
    			switchToNext();
    		}else {
    			Controller.error("Nick ya en uso", "El nick que has puesto"
    					+ " esta en uso, introduce un nuevo nombre.");
    		}
    	}else {
    		Controller.error("Nick erroneo", "El nick que has eligido"
					+ " no es valido, introduce un nuevo nombre.");

    	}
    }
}