package co.edu.uniquindio.gestortareas.model;

public class Tarea {
    private String id;
    private String titulo;
    private String descripcion;
    private boolean completada;
    private String tipo;
    public boolean isCompletada;


    private Tarea(TareaBuilder builder){
        this.id=builder.id;
        this.titulo=builder.titulo;
        this.descripcion=builder.descripcion;
        this.completada=builder.completada;
        this.tipo=builder.tipo;

    }

    public String getId() {
        return id;
    }

    public String getTitulo() {
        return titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public boolean isCompletada() {
        return completada;
    }

    public String getTipo() {
        return tipo;
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

        public TareaBuilder Id(String id){
            this.id=id;
            return this;
        }
        
        public TareaBuilder Titulo(String titulo){
            this.titulo=titulo;
            return this;
        }
        public TareaBuilder Descripcion(String descripcion){
            this.descripcion=descripcion;
            return this;
        }
        public TareaBuilder Completada(boolean completada){
            this.completada=completada;
            return this;
        }
        public TareaBuilder Tipo(String tipo){
            this.tipo=tipo;
            return this;
        }





    
        
    }





}
