
package LOM.files;
//package INF253.tarea3;

public abstract class NPC {
    private String nombre;
    public abstract void interaccion(Jugador jugador);


    /**
     * String GetNombre()
     * 
     * Esta funcion getter tiene como objetivo retornar
     * el nombre del NPC desde la clase abstracta.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  NPC: retorna el nombre del npc desde la clase abstracta
     */
    public String GetNombre(){
        return nombre;
    }

    /**
     * void SetNombre()
     * 
     * Esta funcion setter tiene como objetivo retornar
     * el nombre del NPC desde la clase abstracta.
     * 
     * Input:
     *  String x: El nombre a asignarle al NPC
     * 
     * Output:
     *  Ninguno.
     */
    public void SetNombre(String x){
        nombre = x;
    }
}
