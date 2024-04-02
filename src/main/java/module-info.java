module org.hakiko.supermarket {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.hakiko.supermarket to javafx.fxml;
    exports org.hakiko.supermarket;
}