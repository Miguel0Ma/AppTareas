package co.edu.uniquindio.gestortareas.model;

public class TareaFactory {
    public static Tarea build(String tipo) {
        Tarea.TareaBuilder builder = new Tarea.TareaBuilder().setTipo(tipo).setCompletada(false);

        switch (tipo.toLowerCase()) {
            case "urgente":
                // Configuraciones específicas para tarea urgente
                builder.setTitulo("Tarea Urgente").setDescripcion("Descripción por defecto para tarea urgente");
                break;
            case "normal":
                // Configuraciones específicas para tarea normal
                builder.setTitulo("Tarea Normal").setDescripcion("Descripción por defecto para tarea normal");
                break;
            default:
                // Configuración por defecto
                builder.setTitulo("Tarea").setDescripcion("Descripción por defecto");
                break;
        }

        return builder.build();
    }
}
