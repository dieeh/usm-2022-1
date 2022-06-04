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
    private ArrayList<Feria> ferias ;
    private ArrayList<Museo> museos;
    private ArrayList<Javapato> javapatos;

    /**
     * void sacar_persona(String persona)
     * 
     * Saca a la persona que tenga de nombre el parametro entregado
     * de la lista de personas del jugador
     * 
     * String persona: nombre de la persona a sacar
     */
    public void sacar_persona(String persona){
        for (int i = 0; i < personas.size(); i++) {
            if (personas.get(i).getNombre().equals(persona)) {
                personas.remove(i);
            }
        }
    }

    /**
     * void agregar_persona(Persona persona)
     * 
     * Agrega el objeto Persona a el array personas
     */
    public void agregar_persona(Persona persona){
        personas.add(persona);
    }

    /**
     * void sacar_edificio(String edificio)
     * 
     * Saca el edificio que tenga de nombre el parametro entregado
     * de la lista de edificios del jugador
     * 
     * String edificio: nombre del edificio a sacar
     */
    public void sacar_edificio(String edificio){
        for (int i = 0; i < edificios.size(); i++) {
            if (edificios.get(i).getNombre().equals(edificio)){
                personas.remove(i);
            }
        }
    }

    /**
     * void agregar_edificio(Edificio edificio)
     * 
     * Agrega el objeto Edificio a el array edificios
     */
    public void agregar_edificio(Edificio edificio){
        edificios.add(edificio);
    }

    /*
     * void sacar_atraccion(String atraccion, String clase)
     * 
     * Saca la atraccion de la lista correspondiente segun el parametro
     * clase entregado
     */
    public void sacar_atraccion(String atraccion, String clase){
        if (clase.equals("Feria")){
            for (int i = 0; i < ferias.size(); i++) {
                if (ferias.get(i).getNombre().equals(atraccion)){
                    ferias.remove(i);
                }
            }
        }
        if (clase.equals("Museo")){
            for (int i = 0; i < museos.size(); i++) {
                if (museos.get(i).getNombre().equals(atraccion)){
                    museos.remove(i);
                }
            }
        }
        if (clase.equals("Javapato")){
            for (int i = 0; i < javapatos.size(); i++) {
                if (javapatos.get(i).getNombre().equals(atraccion)){
                    javapatos.remove(i);
                }
            }
        }
    }

    /**
     * void agregar_feria(Feria feria)
     * 
     * agrega el objeto Feria a la lista de ferias
     */
    public void agregar_feria(Feria feria){
        ferias.add(feria);
    }

    /**
     * void agregar_museo(Museo museo)
     * 
     * agrega el objeto museo a la lista de museos
     */
    public void agregar_museo(Museo museo){
        museos.add(museo);
    }

    /**
     * void agregar_javapato(Javapato javapato){
     * 
     * agrega el objeto Javapato a la lista de Javapatos
     */
    public void agregar_javapato(Javapato javapato){
        javapatos.add(javapato);
    }


    /**
     * Getters y setters de la clase
     * 
     */
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
    public ArrayList<Persona> getPersonas(){
        return personas;
    }
    public ArrayList<Edificio> getEdificios(){
        return edificios;
    }
    public ArrayList<Feria> getFerias(){
        return ferias;
    }
    public ArrayList<Museo> getMuseos(){
        return museos;
    }
    public ArrayList<Javapato> getJavapatos(){
        return javapatos;
    }

    /**
     * void InitArray()
     * 
     * Inicializa los arrays del objeto
     */
    public void initArrays(){
        personas = new ArrayList<Persona>();
        edificios = new ArrayList<Edificio>();
        ferias = new ArrayList<Feria>();
        museos = new ArrayList<Museo>();
        javapatos = new ArrayList<Javapato>();
    }



    public Jugador(String x){
        nombre = x;
        javalares = 30;
        hierro = 30;
        trigo = 10;
        tecnologia = 6;
        initArrays();
    }
}