package proyecto.chat;

import java.io.IOException;

import Dao.UsersDao;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.User;

public class PrimaryController {
	
	private TextField nick;

    @FXML
    private void switchToNext() throws IOException {
        App.setRoot("secondary");
    }
    
    @FXML
    private void validNick() {
    	String name= nick.getText();
    	boolean valid = Controller.validNick(name);
    	if(valid) {
    		UsersDao us= new UsersDao();
    		us.addUser(new User("name"));
    	}
    	
    }
    
    
}
