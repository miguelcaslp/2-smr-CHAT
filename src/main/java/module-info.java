module proytecto.chat {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.xml;
    requires java.xml.bind;
    requires jcifs;
    requires javafx.graphics;
    requires java.desktop;
    

    opens proyecto.chat to javafx.fxml, java.xml,jaxb.core,java.xml.bind;
    opens Dao to javafx.fxml, java.xml,jaxb.core,java.xml.bind;
    opens model;
    
    opens prueba to jcifs;
    
    exports model;
    exports proyecto.chat;
}
