package co.edu.uniquindio.gestortareas.controller;

import co.edu.uniquindio.gestortareas.model.Tarea;
import co.edu.uniquindio.gestortareas.model.TareaMangment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.UUID;

public class DashboardController implements Initializable {

    @FXML
    private Label lblTotalTareas;

    @FXML
    private Label lblCompletadas;

    @FXML
    private Label lblPendientes;

    @FXML
    private ListView<String> listTareasRecientes;

    @FXML
    private Button btnVerLista;

    @FXML
    private Button btnAgregarTarea;

    @FXML
    private Button btnEliminarTarea;

    @FXML
    private Button btnCambiarEstado;

    private TareaMangment tareaMangment = TareaMangment.getInstance();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        actualizarEstadisticas();
        cargarTareasRecientes();
    }

    private void actualizarEstadisticas() {
        int total = tareaMangment.mostrarTareas().size();
        int completadas = tareaMangment.obtenerTareasCompletadas().size();
        int pendientes = tareaMangment.obtenerTareasPendientes().size();
        lblTotalTareas.setText(String.valueOf(total));
        lblCompletadas.setText(String.valueOf(completadas));
        lblPendientes.setText(String.valueOf(pendientes));
    }

    private void cargarTareasRecientes() {
        ObservableList<String> items = FXCollections.observableArrayList();
        for (Tarea tarea : tareaMangment.mostrarTareas()) {
            items.add("ID: " + tarea.getId() + " | Título: " + tarea.getTitulo() + " | Descripción: " + tarea.getDescripcion() + " | Completada: " + (tarea.isCompletada() ? "Sí" : "No") + " | Tipo: " + tarea.getTipo());
        }
        listTareasRecientes.setItems(items);
    }

    @FXML
    private void irAListaTareas() {


    }

    @FXML
    private void irAAgregarTarea() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/co/edu/uniquindio/gestortareas/AgregarTarea.fxml"));
            Parent root = loader.load();
            AgregarTareaController controller = loader.getController();
            Stage stage = new Stage();
            stage.initModality(Modality.APPLICATION_MODAL);
            stage.setTitle("Agregar Nueva Tarea");
            stage.setScene(new Scene(root));
            controller.setStage(stage);
            stage.showAndWait();
            actualizarEstadisticas();
            cargarTareasRecientes();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void eliminarTareaSeleccionada() {
        String selectedItem = listTareasRecientes.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String id = selectedItem.split(" \\| ")[0].replace("ID: ", "");
            Tarea tarea = tareaMangment.buscarTareaPorId(id);
            if (tarea != null) {
                tareaMangment.eliminarTarea(tarea);
                actualizarEstadisticas();
                cargarTareasRecientes();
            }
        }
    }

    @FXML
    private void cambiarEstadoTareaSeleccionada() {
        String selectedItem = listTareasRecientes.getSelectionModel().getSelectedItem();
        if (selectedItem != null) {
            String id = selectedItem.split(" \\| ")[0].replace("ID: ", "");
            tareaMangment.cambiarEstadoTarea(id);
            actualizarEstadisticas();
            cargarTareasRecientes();
        }
    }

}
