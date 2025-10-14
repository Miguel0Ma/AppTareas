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
    


}
