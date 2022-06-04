package tarea.files;

import java.util.ArrayList;

public class Javapato implements Atraccion {
    private String nombre;



    public Integer visitar(ArrayList<Persona> lista) {
        Integer personasG, personasH, personasC;
        personasC = personasG = personasH = 0;
        for (int i = 0; i < lista.size(); i++) {
            if (lista.get(i) instanceof Cientifico){
                personasC +=1;
            }
            if (lista.get(i) instanceof Herrero){
                personasH +=1;
            }
            if (lista.get(i) instanceof Granjero){
                personasG +=1;
            }
        }

        Integer cantidad_reto = (3*personasG)+((6/4)*personasC)+(3*personasH);
        return cantidad_reto;
    }


    /**
     * Setter y getter de la clase
     * 
     */
    public void setNombre(String x){
        nombre = x;
    }
    public String getNombre(){
        return nombre;
    }
    
    public Javapato(String newNombre){
        nombre = newNombre;
    }
}