package tarea.files; 

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private int javalares;
    private int hierro;
    private int trigo;
    private int tecnologia;
    private ArrayList<Persona> personas;
    private ArrayList<Edificio> edificios;
    private ArrayList<Atraccion> atracciones;


    public void sacar_persona(String);
    public void agregar_persona(Persona);
    public void sacar_edificio(String);
    public void agregar_edificio(Edificio);
    public void sacar_atraccion(String);
    public void agregar_atraccion(Atraccion);

    public void setNombre(String x){
        nombre = x;
    }
    public String getNombre(){
        return nombre;
    }
    public void setJavalares(int x){
        javalares = x;
    }
    public int getJavalares(){
        return javalares;
    }
    public void setHierro(int x){
        hierro = x;
    }
    public int getHierro(){
        return hierro;
    }
    public void setTrigo(int x){
        trigo = x;
    }
    public int getTrigo(){
        return trigo;
    }
    public void setTecnologia(int x){
        tecnologia = x;
    }
    public int getTecnologia(){
        return tecnologia;
    }
    public void initArrays(){
        personas = new ArrayList<Persona>();
        edificios = new ArrayList<Edificio>();
        atracciones = new ArrayList<Atraccion>(); 
    }

    public Jugador(String x){
        nombre = x;
        javalares = 30;
        hierro = 15;
        trigo = 10;
        tecnologia = 6;
    }
}