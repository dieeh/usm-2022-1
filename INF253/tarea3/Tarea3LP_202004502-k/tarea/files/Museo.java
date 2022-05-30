package tarea.files;

import java.util.ArrayList;

public class Museo implements Atraccion {
    private String nombre;

    public Integer visitar(ArrayList<Persona> lista) {
        Integer personasG, personasH, personasC;
        personasC = personasG = personasH = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i).getClass().getName().equals("Cientifico")){
                personasC +=1;
            }
            if (lista.get(i).getClass().getName().equals("Herrero")){
                personasH +=1;
            }
            if (lista.get(i).getClass().getName().equals("Granjero")){
                personasG +=1;
            }
        }

        Integer cantidad_reto = personasG+(4*personasC)+(2*personasH);
        return cantidad_reto;
    }

    public void setNombre(String x){
        nombre = x;
    }
    public String getNombre(){
        return nombre;
    }
    
    public Museo(String newNombre){
        nombre = newNombre;
    }
}