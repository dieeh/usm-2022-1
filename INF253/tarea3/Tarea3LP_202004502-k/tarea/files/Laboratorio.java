package tarea.files;

import java.util.ArrayList;

public class Laboratorio extends Edificio {

    public void mejorar(){
        setNivel( getNivel() + 1);
        setCapacidad(getCapacidad() + 2);
    }
    
    public ArrayList<Integer> producir(){
        
        
    }

    public Laboratorio(String nombre){
        setNombre(nombre);
        setNivel(1);
        setCapacidad(5);
        initArray();
    }
}