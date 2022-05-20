package tarea.files;

public abstract class Persona{
    private String nombre;
    private Integer edad;
    private Integer nivel;
    private Integer productividad;

    public void envejecer(){
        edad +=1;
    }

    public abstract void mejorar();
    public abstract Integer trabajo_realizado();





    /**
    * Funciones Get y Set
    * 
    * Estas funciones retornan y asignan respectivamente las siguientes variables
    * de la clase abstracta
    *
    * -nombre
    * -edad
    * -nivel
    * -productividad
    */
    public String getNombre(){
        return nombre;
    }
    public void setNombre(String new_nombre){
        nombre = new_nombre;
    }
    public Integer getEdad(){
        return edad;
    }
    public void setEdad(Integer new_edad){
        edad = new_edad;
    }
    public Integer getNivel(){
        return nivel;
    }
    public void setNivel(Integer new_nivel){
        nivel = new_nivel;
    }
    public Integer getProductividad(){
        return productividad;
    }
    public void setProductividad(Integer new_productividad){
        productividad = new_productividad;
    }
}