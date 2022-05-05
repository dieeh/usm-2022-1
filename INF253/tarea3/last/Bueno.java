//package INF253.tarea3;
package LOM.files;



public class Bueno extends NPC {
    private String atributo;
    private int cantidad;

    /**
     * void interaccion()
     * 
     * Esta funcion representa la interaccion entre el jugador y el NPC
     * de la casilla, en este caso este npc aumenta stats del jugador.
     * 
     * Input:
     *  Jugador jugador: Este parametro es el personaje creado en la
     *                   ejecucion del programa.
     * 
     * Output:
     *  Ninguno.
     */
    public void interaccion(Jugador jugador){
        System.out.println("<"+GetNombre() +">: Creo que necesitas un poco de ayuda, ¡te subiré "+Integer.toString(cantidad)+" puntos a tu "+atributo+"!");
        if (atributo.equals("vida") == true) {
            jugador.SetVida(jugador.GetVida() + cantidad);
        } else if (atributo.equals("xp") == true){
            jugador.SetXP(jugador.GetXP() + cantidad);
            jugador.subir_experiencia(jugador.GetXP());
        } else if (atributo.equals("energia") == true){
            jugador.SetEnergia(jugador.GetEnergia() + cantidad);
        } else if (atributo.equals("mana") == true){
            jugador.SetMana(jugador.GetMana() + cantidad);
        }

        if (jugador.GetVida() > jugador.GetVidaMax()) {
            jugador.SetVida(jugador.GetVidaMax());
        }
        if (jugador.GetEnergia() > jugador.GetEnergiaMax()){
            jugador.SetEnergia(jugador.GetEnergiaMax());
        }
        if (jugador.GetMana() > jugador.GetManaMax()) {
            jugador.SetMana(jugador.GetManaMax());
        }
    }


    /**
     * Bueno()
     * 
     * Este es el constructor de una de las subclases de NPC,
     * este recibe 3 parametros.
     * 
     * Input:
     *  String w: Nombre del npc.
     *  String x: Atributo a subir.
     *  int y: Cantidad a subir el atributo.
     * 
     */
    public Bueno(String w, String x, int y){
        SetNombre(w);
        this.atributo = x;
        this.cantidad = y;
    }
}
