package proytecto.chat;

import java.io.IOException;
import javafx.fxml.FXML;

public class ChatsController {

    @FXML
    private void switchToPrimary() throws IOException {
        App.setRoot("login");
    }
}