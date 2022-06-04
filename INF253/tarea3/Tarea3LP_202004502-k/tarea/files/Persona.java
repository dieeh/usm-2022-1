package tarea.files;

public abstract class Persona{
    private String nombre;
    private Integer edad;
    private Integer nivel;
    private Integer productividad;


    /**
    * void envejecer()
    * 
    * Aumenta en 1 la edad de la persona
    */
    public void envejecer(){
        edad +=1;
    }

    /**
     * void mejorar()
     * 
     * Aumenta en 1 el nivel de la persona y aumenta la productividad
     * dependiendo de la clase
     */
    public abstract void mejorar();

    /**
     * Integer trabajo_realizado()
     * 
     * Retorna un Integer cuyo valor depende de la productividad
     * y el nivel de la persona
     */
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