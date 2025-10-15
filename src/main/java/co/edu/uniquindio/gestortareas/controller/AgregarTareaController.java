package co.edu.uniquindio.gestortareas.controller;

import co.edu.uniquindio.gestortareas.model.Tarea;
import co.edu.uniquindio.gestortareas.model.TareaFactory;
import co.edu.uniquindio.gestortareas.model.TareaMangment;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class AgregarTareaController implements Initializable {

    @FXML
    private TextField txtId;

    @FXML
    private TextField txtTitulo;


    @FXML
    private ComboBox<String> cbTipo;

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnCancelar;

    private TareaMangment tareaMangment = TareaMangment.getInstance();
    private Stage stage;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        cbTipo.getItems().addAll("Urgente", "Normal");
        cbTipo.setValue("Normal");
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    private void guardarTarea() {
        String id = txtId.getText();
        String titulo = txtTitulo.getText();
        String tipo = cbTipo.getValue();

        if (titulo != null && !titulo.isEmpty() && id != null && !id.isEmpty()) {
            Tarea tareaBase = TareaFactory.build(tipo.toLowerCase());
            Tarea nuevaTarea = new Tarea.TareaBuilder()
                .Id(id)
                .Titulo(titulo)
                .Descripcion(tareaBase.getDescripcion())
                .Completada(false)
                .Tipo(tipo)
                .build();
            tareaMangment.agregarTarea(nuevaTarea);
            stage.close();
        }
    }

    @FXML
    private void cancelar() {
        stage.close();
    }
}