//package INF253.tarea3;
package LOM.files;

import java.util.Random;



public class Malo extends NPC {
    private int cantidad_energia;
    private int cantidad_mana;

    /**
     * void interaccion()
     * 
     * Esta funcion representa la interaccion entre el jugador y el NPC
     * de la casilla, en este caso este npc intenta bajar las stats del jugador.
     * 
     * Input:
     *  Jugador jugador: Este parametro es el personaje creado en la
     *                   ejecucion del programa.
     * 
     * Output:
     *  Ninguno.
     */
    public void interaccion(Jugador jugador){
        System.out.println("<"+GetNombre() +">: ¡¡SOY MALO, DISMINUIRÉ TU ENERGÍA Y MANA EN "+Integer.toString(cantidad_energia)+" Y "+Integer.toString(cantidad_mana)+"!!");
        boolean probabilidad1 = new Random().nextInt(100) <= 60;
        if (probabilidad1 == true ) {
            jugador.SetEnergia(jugador.GetEnergia() - cantidad_energia);
            if (jugador.GetEnergia() < 0) {
                jugador.SetEnergia(0);
            }
        }
        boolean probabilidad2 = new Random().nextInt(100) <= 60;
        if (probabilidad2 == true) {
            jugador.SetMana(jugador.GetMana() - cantidad_mana);
            if (jugador.GetMana() < 0) {
                jugador.SetMana(0);
            }
        }
    }


    /**
     * Malo()
     * 
     * Este es el constructor de una de las subclases de NPC,
     * esta en este caso recibe 3 parametros.
     * 
     * Input:
     *  String x: Nombre del npc.
     *  int y: Cantidad de energia a restar.
     *  int z: Cantidad de mana a restar.
     */
    public Malo(String x, int y, int z){
        SetNombre(x);
        this.cantidad_energia = y;
        this.cantidad_mana = z;
    }
}
