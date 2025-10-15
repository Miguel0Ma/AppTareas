package co.edu.uniquindio.gestortareas.model;

public class TareaFactory {
    public static Tarea build(String tipo) {
        Tarea.TareaBuilder builder = new Tarea.TareaBuilder().Tipo(tipo).Completada(false);

        switch (tipo.toLowerCase()) {
            case "urgente":
                builder.Tipo("Urgente").Descripcion("Realizar esta tarea los mas antes posible ");
                break;
            case "normal":
                builder.Tipo("Normal").Descripcion("No dejar pasar");
                break;
            default:
                builder.Tipo("Tarea").Descripcion("Hacer");
                break;
        }

        return builder.build();
    }
}
