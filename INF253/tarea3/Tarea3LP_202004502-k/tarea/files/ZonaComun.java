package tarea.files;

import java.util.ArrayList;

public class ZonaComun extends Edificio {

    public void mejorar(){
        setNivel( getNivel() + 1);
        setCapacidad(getCapacidad() + 4);
    }
    
    public ArrayList<Integer> producir(){
        ArrayList<Persona> tempo = getPersonas();

        ArrayList<Integer> retorno = new ArrayList<Integer>();
        retorno.add(tempo.size());
        retorno.add(0);
        retorno.add(0);
        retorno.add(0);

        return retorno;        
    }

    public ZonaComun(String x){
        setNombre(x);
        setNivel(1);
        setCapacidad(6);
        initArray();
    }
}