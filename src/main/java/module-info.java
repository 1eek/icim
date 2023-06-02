module com.example.demo {
    requires javafx.controls;
    requires javafx.fxml;
    requires junit;

    opens com.example.demo to javafx.fxml;
    exports com.example.demo;
    exports com.example.demo.Controller;
    opens com.example.demo.Controller to javafx.fxml;
    opens com.example.demo.pojo to javafx.base;

}