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

    public void AgregarTareas(Tarea tarea){
        tareas.add(tarea);
    }

    public void EliminarTareas(Tarea tarea){
        tareas.remove(tarea);
    }
    public ArrayList<Tarea>mostrarTareas(){
        return tareas;
    }

    public Tarea buscarTareaId(String id){
        for (Tarea tarea : tareas){
            if (tarea.getId().equals(id)){
                return tarea;
            }
        }
        return null;
    }

    public ArrayList<Tarea> obtenerTareasCompletadas(){
        ArrayList<Tarea>tareasCompletadas=new ArrayList<>();
        for(Tarea tarea:tareas){
            if(tarea.isCompletada()){
                tareasCompletadas.add(tarea);
            }
        }
        return tareasCompletadas;
    }

    public ArrayList<Tarea>obtenerTareasPendientes(){
        ArrayList<Tarea>tareasPendientes=new ArrayList<>();
        for (Tarea tarea:tareas){
            if(tarea.isCompletada!=true){
                tareasPendientes.add(tarea);
            }
        }
        return tareasPendientes;
    }

    public ArrayList<Tarea>ObtenerTareasTipo(String tipo){
        ArrayList<Tarea>tareasTipo=new ArrayList<>();
        for(Tarea tarea: tareas){
            if(tarea.getTipo().equals(tipo)){
                tareasTipo.add(tarea);
            }
        }
        return tareasTipo;

    }
}
