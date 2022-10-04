package proytecto.chat;

import java.io.IOException;

import controller.Controller;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

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
    	
    }
    
    
}
