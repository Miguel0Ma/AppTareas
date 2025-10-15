package co.edu.uniquindio.gestortareas.model;

import java.util.ArrayList;

public class TareaMangment {
    private static TareaMangment instance;
    private ArrayList<Tarea> tareas;

    public static TareaMangment getInstance(){
        if(instance==null){
            instance= new TareaMangment();
        }
        return instance;
    }

    private TareaMangment(){
        tareas = new ArrayList<>();
    }

    public void agregarTarea(Tarea tarea){
        tareas.add(tarea);
    }

    public void eliminarTarea(Tarea tarea){
        tareas.remove(tarea);
    }
    public ArrayList<Tarea> mostrarTareas(){
        return new ArrayList<>(tareas);
    }

    public Tarea buscarTareaPorId(String id){
        if (id == null || id.isEmpty()) {
            return null;
        }
        for (Tarea tarea : tareas){
            if (tarea.getId() != null && tarea.getId().equals(id)){
                return tarea;
            }
        }
        return null;
    }

    public ArrayList<Tarea> obtenerTareasCompletadas(){
        ArrayList<Tarea> tareasCompletadas = new ArrayList<>();
        for(Tarea tarea : tareas){
            if(tarea.isCompletada()){
                tareasCompletadas.add(tarea);
            }
        }
        return tareasCompletadas;
    }

    public ArrayList<Tarea> obtenerTareasPendientes(){
        ArrayList<Tarea> tareasPendientes = new ArrayList<>();
        for (Tarea tarea : tareas){
            if(!tarea.isCompletada()){
                tareasPendientes.add(tarea);
            }
        }
        return tareasPendientes;
    }

    public ArrayList<Tarea> obtenerTareasTipo(String tipo){
        ArrayList<Tarea> tareasTipo = new ArrayList<>();
        for(Tarea tarea : tareas){
            if(tarea.getTipo().equals(tipo)){
                tareasTipo.add(tarea);
            }
        }
        return tareasTipo;
    }

    public void marcarCompletada(String id) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            Tarea nuevaTarea = new Tarea.TareaBuilder()
                .Id(tarea.getId())
                .Titulo(tarea.getTitulo())
                .Descripcion(tarea.getDescripcion())
                .Completada(true)
                .Tipo(tarea.getTipo())
                .build();
            int index = tareas.indexOf(tarea);
            tareas.set(index, nuevaTarea);
        }
    }

    public void marcarPendiente(String id){
        Tarea tarea = buscarTareaPorId(id);
        if(tarea!=null){
            Tarea nuevaTarea= new Tarea.TareaBuilder().
            Id(tarea.getId()).
            Titulo(tarea.getTitulo()).
            Descripcion(tarea.getDescripcion())
            .Completada(false)
            .Tipo(tarea.getTipo())
            .build();
            int index= tareas.indexOf(tarea);
            tareas.set(index, nuevaTarea);
        }
    }

    public void cambiarEstadoTarea(String id) {
        Tarea tarea = buscarTareaPorId(id);
        if (tarea != null) {
            boolean nuevoEstado = !tarea.isCompletada();
            Tarea nuevaTarea = new Tarea.TareaBuilder()
                .Id(tarea.getId())
                .Titulo(tarea.getTitulo())
                .Descripcion(tarea.getDescripcion())
                .Completada(true)
                .Tipo(tarea.getTipo())
                .build();
            int index = tareas.indexOf(tarea);
            tareas.set(index, nuevaTarea);
        }
    }

}
