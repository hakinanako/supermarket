module org.hakiko.supermarket {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.hakiko.supermarket to javafx.fxml;
    exports org.hakiko.supermarket;
    exports org.hakiko.supermarket.controller;
    opens org.hakiko.supermarket.controller to javafx.fxml;
}