package proytecto.chat;

import java.io.IOException;
import javafx.fxml.FXML;

public class MessagesController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("primary");
    }
}