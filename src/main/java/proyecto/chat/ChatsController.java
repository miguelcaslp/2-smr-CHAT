package proyecto.chat;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import javax.swing.JOptionPane;

import Dao.ChatDao;
import controller.Controller;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.Chat;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.value.ObservableValue;
import javafx.beans.property.ObjectProperty;



public class ChatsController implements Initializable {
	private ChatDao ch = new ChatDao();
	
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
    		Controller.setChat(chatname);
    		App.setRoot("Messages");
    	}
    }
    
    @FXML
	private void updateTable() {
    	ArrayList<Chat>chats = ch.chatsList();
		ObservableList<Chat> oList = FXCollections.observableArrayList(chats);
		
		name.setCellValueFactory(InfoPedido -> {
			SimpleStringProperty a = new SimpleStringProperty();
			a.setValue(InfoPedido.getValue().getId());
			return a;
		});
    	
    	online.setCellValueFactory(InfoPedido -> {
    		ObservableValue<Integer> a = new SimpleIntegerProperty().asObject();
            ((ObjectProperty<Integer>) a).setValue(InfoPedido.getValue().getOnline());
            return a;

        });
    	myChats.getItems().addAll(oList);
    }

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		updateTable();
	}
    
}