 module co.edu.uniquindio.gestortareas {
    requires javafx.controls;
    requires javafx.fxml;


    opens co.edu.uniquindio.gestortareas to javafx.fxml;
    opens co.edu.uniquindio.gestortareas.controller to javafx.fxml;
    exports co.edu.uniquindio.gestortareas;
}