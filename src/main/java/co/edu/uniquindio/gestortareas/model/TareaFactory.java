package co.edu.uniquindio.gestortareas.model;

public class TareaFactory {
    public static Tarea build(String tipo) {
        Tarea.TareaBuilder builder = new Tarea.TareaBuilder().setTipo(tipo).setCompletada(false);

        switch (tipo.toLowerCase()) {
            case "urgente":
                // Configuraciones específicas para tarea urgente
                builder.setTipo("Urgente").setDescripcion("Realizar esta tarea los mas antes posible ");
                break;
            case "normal":
                // Configuraciones específicas para tarea normal
                builder.setTipo("Normal").setDescripcion("No dejar pasar");
                break;
            default:
                // Configuración por defecto
                builder.setTipo("Tarea").setDescripcion("Hacer");
                break;
        }

        return builder.build();
    }
}
