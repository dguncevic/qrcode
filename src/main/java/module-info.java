module com.mycompany.qrcode {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires qrgen;

    opens com.mycompany.qrcode to javafx.fxml;
    exports com.mycompany.qrcode;
}
