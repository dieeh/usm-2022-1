package tarea.files;

import java.util.ArrayList;

public abstract class Edificio{
    private String nombre;
    private Integer nivel;
    private Integer capacidad;
    private ArrayList<Persona> personas;

    /**
     * ArrayList<Integer> producir()
     * 
     * Retorna un array de largo 4 donde cada celda tiene
     * un valor que corresponde a los Javalares, Hierro, Trigo y Tecnologia
     * producidos por el edificio basado en la cantidad de personas de cada clase
     */
    public abstract ArrayList<Integer> producir();

    /**
     * void mejorar()
     * 
     * Mejora el nivel del edificio y aumenta su capacidad
    */
    public abstract void mejorar();


    public void sacar_persona(String name){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equals(name)) {
                personas.remove(i);
            }
        }
    }
    public void agregar_persona(Persona wacho){
        personas.add(wacho);
    }
    

    /**
     * Setters y getters de la clase
     */
    public ArrayList<Persona> getPersonas(){
        return personas;
    }

    public void setNombre(String x){
        nombre = x;
    }
    public String getNombre(){
        return nombre;
    }
    public void setNivel(Integer newNivel){
        nivel = newNivel;
    }
    public Integer getNivel(){
        return nivel;
    }
    public void setCapacidad(Integer newCapacidad){
        capacidad = newCapacidad;
    }
    public Integer getCapacidad(){
        return capacidad;
    }

    /**
     * void InitArray()
     * 
     * Inicializa los arrays del objeto
     */
    public void initArray(){
        personas = new ArrayList<Persona>();
    }
}