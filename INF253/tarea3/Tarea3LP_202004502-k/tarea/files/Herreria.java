package tarea.files;

import java.util.ArrayList;

public class Herreria extends Edificio {

    public void mejorar(){
        setNivel( getNivel() + 1);
        setCapacidad(getCapacidad() + 4);
    }
    
    public ArrayList<Integer> producir(){


    }
}