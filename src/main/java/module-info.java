module proytecto.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.xml.bind;
    

    opens proytecto.chat to javafx.fxml, java.xml,jaxb.core,java.xml.bind;
    opens Dao to javafx.fxml, java.xml,jaxb.core,java.xml.bind;
    opens model to javafx.fxml, java.xml,jaxb.core,java.xml.bind;
    exports model;
    exports proytecto.chat;
}
