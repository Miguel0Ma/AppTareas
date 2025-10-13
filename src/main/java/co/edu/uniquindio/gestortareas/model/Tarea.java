package co.edu.uniquindio.gestortareas.model;

public class Tarea {
    private String id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private String tipo;


    private Tarea(TareaBuilder builder){
        this.id=builder.id;
        this.titulo=builder.titulo;
        this.descripcion=builder.descripcion;
        this.completada=builder.completada;
        this.tipo=builder.tipo;

    }


    public static  class TareaBuilder {
        private String id;
        private String titulo;
        private String descripcion;
        private boolean completada;
        private String tipo;

        public Tarea build(){
            return new Tarea(this);
        }

        public TareaBuilder setId(String id){
            this.id=id;
            return this;
        }
        
        public TareaBuilder setTitulo(String titulo){
            this.titulo=titulo;
            return this;
        }
        public TareaBuilder setDescripcion(String descripcion){
            this.descripcion=descripcion;
            return this;
        }
        public TareaBuilder setCompletada(boolean completada){
            this.completada=completada;
            return this;
        }
        public TareaBuilder setTipo(String tipo){
            this.tipo=tipo;
            return this;
        }





    
        
    }





}
