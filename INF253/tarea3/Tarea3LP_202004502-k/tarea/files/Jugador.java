package tarea.files; 

import java.util.ArrayList;

public class Jugador {
    private String nombre;
    private Integer javalares;
    private Integer hierro;
    private Integer trigo;
    private Integer tecnologia;
    private ArrayList<Persona> personas;
    private ArrayList<Edificio> edificios;
    private ArrayList<Atraccion> atracciones;


    public void sacar_persona(String persona){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre() == persona) {
                personas.remove(i);
            }
        }
    }
    public void agregar_persona(Persona persona){
        personas.add(persona);
    }
    public void sacar_edificio(String edificio){}
    public void agregar_edificio(Edificio edificio){
        edificios.add(edificio);
    }
    public void sacar_atraccion(String atraccion){}
    public void agregar_atraccion(Atraccion atraccion){
        atracciones.add(atraccion);
    }

    public void setNombre(String x){
        nombre = x;
    }
    public String getNombre(){
        return nombre;
    }
    public void setJavalares(Integer x){
        javalares = x;
    }
    public Integer getJavalares(){
        return javalares;
    }
    public void setHierro(Integer x){
        hierro = x;
    }
    public Integer getHierro(){
        return hierro;
    }
    public void setTrigo(Integer x){
        trigo = x;
    }
    public Integer getTrigo(){
        return trigo;
    }
    public void setTecnologia(Integer x){
        tecnologia = x;
    }
    public Integer getTecnologia(){
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
        initArrays();
    }
}