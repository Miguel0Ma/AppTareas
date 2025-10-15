package co.edu.uniquindio.gestortareas.controller;

import co.edu.uniquindio.gestortareas.model.Tarea;
import co.edu.uniquindio.gestortareas.model.TareaMangment;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.net.URL;
import java.util.ResourceBundle;

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
            items.add(tarea.getTitulo() + " - " + (tarea.isCompletada() ? "Completada" : "Pendiente"));
        }
        listTareasRecientes.setItems(items);
    }

    @FXML
    private void irAListaTareas() {
        // Lógica para cambiar a la vista de lista de tareas
        System.out.println("Navegando a lista de tareas");
    }

    @FXML
    private void irAAgregarTarea() {
        // Lógica para cambiar a la vista de agregar tarea
        System.out.println("Navegando a agregar tarea");
    }
}
