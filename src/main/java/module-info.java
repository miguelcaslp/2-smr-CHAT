module proytecto.chat {
    requires javafx.controls;
    requires javafx.fxml;

    opens proytecto.chat to javafx.fxml;
    exports proytecto.chat;
}
