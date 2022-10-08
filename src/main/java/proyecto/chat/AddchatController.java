package proyecto.chat;

import java.io.IOException;

import Dao.UsersDao;
import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import model.User;

public class AddchatController {
	
	@FXML
	private TextField nick;
	@FXML
	private Button login;

    @FXML
    private void switchToNext() throws IOException {
        App.setRoot("chats");
    }
    
    @FXML
    public void validNick() throws IOException {
    	String name= nick.getText();
    	boolean valid = Controller.validNick(name);
    	if(valid) {
    		UsersDao us=new UsersDao();
    		us.addUser(new User(name));
    		switchToNext();
    	}

    	
    }
    
    
}
