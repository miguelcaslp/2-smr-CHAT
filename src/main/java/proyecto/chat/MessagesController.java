package proyecto.chat;


import java.awt.Label;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import Dao.TextToSendDao;
import controller.Controller;
import controller.userUpdateController;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import model.TextToSend;
import model.*;


public class MessagesController implements Initializable {
	private TextToSendDao td = new TextToSendDao();
			
	
	@FXML
	private TableView<TextToSend> myMessages ;
	@FXML
	private TableColumn<TextToSend, String> nick;
	@FXML
	private TableColumn<TextToSend, String> message;
	@FXML
	private TableColumn<TextToSend, String> time;
	
	
	@FXML
	Button back;
	@FXML
	Button send;
	@FXML
	TextField text;

	
	@FXML
    private void switchToBack() throws IOException {
        App.setRoot("chats");
    }
	
	@FXML
	public void updateTable() {
		ArrayList<TextToSend>messages= td.loadMessages(Controller.getChat().getId());
		if(messages!=null) {
			ObservableList<TextToSend> oList = FXCollections.observableArrayList(messages);
			myMessages.getItems().addAll(oList);
		}
		
		nick.setCellValueFactory(InfoPedido -> {
			SimpleStringProperty a = new SimpleStringProperty();
			a.setValue(InfoPedido.getValue().getUser().getId());
			return a;
		});
		
		message.setCellValueFactory(InfoPedido -> {
			SimpleStringProperty a = new SimpleStringProperty();
			a.setValue(InfoPedido.getValue().getText());
			return a;
		});
		
		time.setCellValueFactory(InfoPedido -> {
			SimpleStringProperty a = new SimpleStringProperty();
			a.setValue(InfoPedido.getValue().getTime());
			return a;
		});
		
		
	}
	
	@FXML 
	private void sendMessage() {
		if(Controller.validMessage(text.getText())) {
			TextToSend MessageToSend = new TextToSend(Controller.getUser(),text.getText());
			td.addTexttoSend(MessageToSend, Controller.getChat().getId());
			myMessages.getItems().clear();
			updateTable();
		}
	}
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		updateTable();
		
	} 
	
	
}