package tarea.files;

public abstract class Persona{
    private String nombre;
    private int edad;
    private int nivel;
    private int productividad;

    public void envejecer(){
        edad +=1;
    }

    public abstract void mejorar();
    public abstract int trabajo_realizado();





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
    public int getEdad(){
        return edad;
    }
    public void setEdad(int new_edad){
        edad = new_edad;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNivel(int new_nivel){
        nivel = new_nivel;
    }
    public int getProductividad(){
        return productividad;
    }
    public void setProductividad(int new_productividad){
        productividad = new_productividad;
    }
}