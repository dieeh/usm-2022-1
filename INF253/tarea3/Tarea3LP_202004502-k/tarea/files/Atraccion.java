package tarea.files;

import java.util.ArrayList;

public interface Atraccion {

    /**
     * Integer visitar
     * 
     * ArrayList<Persona> lista: Array de personas para visitar
     * 
     * Esta funcion que es implementada en todas las atracciones
     * retorna un integer basado en la cantidad de personas de cada
     * clase dentro del array
     * 
     * Integer: cantidad de Javalares que retorna por visita
     */
    public Integer visitar(ArrayList<Persona> lista);
}