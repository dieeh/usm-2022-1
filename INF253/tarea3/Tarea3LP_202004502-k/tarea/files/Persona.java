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
    public abstract void trabajo_realizado();

    public String getNombre(){
        return nombre;
    }
    public void setNombre(String x){
        nombre = x;
    }
    public int getEdad(){
        return edad;
    }
    public void setEdad(int x){
        edad = x;
    }
    public int getNivel(){
        return nivel;
    }
    public void setNivel(int x){
        nivel = x;
    }
    public int getProductividad(){
        return productividad;
    }
    public void setProductividad(int x){
        productividad= x;
    }
}