open module org.hakiko.supermarket {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires static lombok;
    requires org.slf4j;
    exports org.hakiko.supermarket;
    exports org.hakiko.supermarket.controller;
}