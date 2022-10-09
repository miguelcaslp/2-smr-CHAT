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
	private TextField namechat;
	@FXML
	private Button create;

    @FXML
    private void switchToNext() throws IOException {
        App.setRoot("Messages");
    }
    
    @FXML
    public void validName() throws IOException {
    	String name= namechat.getText();
    	
    }
    
    
}
