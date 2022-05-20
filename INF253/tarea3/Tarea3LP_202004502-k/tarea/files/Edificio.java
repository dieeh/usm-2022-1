package tarea.files;

import java.util.ArrayList;

public abstract class Edificio{
    private String nombre;
    private Integer nivel;
    private Integer capacidad;
    private ArrayList<Persona> personas;

    public abstract ArrayList<Integer> producir();
    public abstract void mejorar();

    public void sacar_persona(String name){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre() == name) {
                personas.remove(i);
            }
        }
    }

    public void agregar_persona(Persona wacho){
        personas.add(wacho);
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
}