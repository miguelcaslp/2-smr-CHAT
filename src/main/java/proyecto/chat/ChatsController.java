package proyecto.chat;

import java.io.IOException;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Chat;

public class ChatsController {
	
	@FXML
	private TableView<Chat> myChats;
	@FXML
	private TableColumn<Chat, String> name;
	@FXML
	private TableColumn<Chat, Integer> online;
	
    @FXML
    private void switchToLogin() throws IOException {
        App.setRoot("login");
    }
    
    @FXML
    private void switchToAddChat(ActionEvent event) throws IOException {
    	App.setRoot("addchat");
    }
    
    @FXML
    private void switchToMessages(ActionEvent event) throws IOException {
    	Chat chatname = this.myChats.getSelectionModel().getSelectedItem();
    	if(chatname==null) {
    		JOptionPane.showMessageDialog(null, "Debes seleccionar un chat primero");
    	} else {
    		App.setRoot("Messages");
    	}
    	
    }
    
}