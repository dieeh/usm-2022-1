//package INF253.tarea3;
package LOM.files;


import java.util.ArrayList;
import java.util.List;

public abstract class Jugador {
    private String nombre;
    private int vida;
    private int xp;
    private int fuerza;
    private int inteligencia;
    private int energia;
    private int mana;
    private int vida_max;
    private int energia_max;
    private int mana_max;
    private List<Mision> lista_misiones;
    public abstract int ataque();
    public abstract int hechizo();
    public abstract void subir_experiencia(int xp);


    /**
     * Funciones Get y Set
     * 
     * Estas funciones retornan y asignan respectivamente las siguientes variables
     * de la clase abstracta
     * 
     * -nombre
     * -vida
     * -xp
     * -fuerza
     * -inteligencia
     * -energia
     * -mana
     * -vida_max
     * -energia_max
     * -mana_max
     * 
     */
    public String GetNombre(){
        return nombre;
    }
    public void SetNombre(String x){
        nombre = x;
    }
    public int GetVida(){
        return vida;
    }
    public void SetVida(int x){
        vida = x;
    }
    public int GetXP(){
        return xp;
    }
    public void SetXP(int x){
        xp = x;
    }
    public int GetFuerza(){
        return fuerza;
    }
    public void SetFuerza(int x){
        fuerza = x;
    }
    public int GetInteligencia(){
        return inteligencia;
    }
    public void SetInteligencia(int x){
        inteligencia = x;
    }
    public int GetEnergia(){
        return energia;
    }
    public void SetEnergia(int x){
        energia = x;
    }
    public int GetMana(){
        return mana;
    }
    public void SetMana(int x){
        mana = x;
    }
    public int GetVidaMax(){
        return vida_max;
    }
    public void SetVidaMax(int x){
        vida_max = x;
    }
    public int GetEnergiaMax(){
        return energia_max;
    }
    public void SetEnergiaMax(int x){
        energia_max = x;
    }
    public int GetManaMax(){
        return mana_max;
    }
    public void SetManaMax(int x){
        mana_max = x;
    }


    /**
     * void InitMisiones()
     * 
     * Este metodo inicializa la lista de misiones
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  Ninguno
     */
    public void InitMisiones(){
        lista_misiones = new ArrayList<Mision>();
    }

    /**
     * List<Mision> GetMisiones()
     * 
     * Este metodo retorna la lista de misiones del jugador.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  List<Mision>: Es la lista de misiones del jugador.
     */
    public List<Mision> GetMisiones(){
        return lista_misiones;
    }

    /**
     * void AddMisiones()
     * 
     * Este metodo agrega misiones a la lista de misiones del jugador.
     * 
     * Input:
     *  Mision mision: Mision a agregar a la lista.
     * 
     * Output:
     *  Ninguno.
     * 
     */
    public void AddMisiones(Mision mision){
        lista_misiones.add(mision);
    }
}
