//package INF253.tarea3;
package LOM.files;

import java.util.Random;


public class Bosque extends Tierra {



    /**
     * boolean accion()
     * 
     * Este metodo implementa las acciones del jugador al llegar a una casilla,
     * calcula si puede llegar efectivamente a esta y luego hace interactuar al
     * jugador con el npc si es que hay y combatir con el monstruo si es que aparece.
     * 
     * Input:
     *  Jugador jugador: Es el objeto de clase jugador que representa al personaje que crea
     *                   el usuario en la ejecucion de programa.
     * 
     * Output:
     *      boolean: retorna true si es que el jugador pudo llegar a la casilla y llevar a cabo
     *              las interacciones, y retorna false si no puede llegar a la casilla.
     */
    public boolean accion(Jugador jugador){
        if (jugador.GetMana() <= 0) {
            System.out.println("¡No tienes maná suficiente para llegar al bosque!");
            return false;
        }
        if (jugador.GetMana() > 0) {
            int cobro = jugador.GetMana() - 3;
            if (cobro < 0){
                jugador.SetVida(jugador.GetVida() + cobro);
            }else{
                jugador.SetMana(jugador.GetMana() - cobro);
            }
            if (GetNPC() != null) {
                GetNPC().interaccion(jugador);
            }
            int temp = (int) GetPosi()*100;
            boolean probabilidad = new Random().nextInt(100) < temp ;
            if(probabilidad == true){
                if (GetMonstruo() != null) {
                    //System.out.println("¡Ha aparecido un monstruo!");
                    GetMonstruo().combate(jugador);
                } else if (GetJefe() != null){
                    //System.out.println("¡Te has encontrado al Jefe Final!");
                    GetJefe().combate(jugador);
                }
            }
        }
        return true;
    }

    /**
     * Bosque()
     * 
     * Es uno de los constructores de clase, que inicializan ciertos
     * valores para su uso en el resto del programa.
     * 
     * Input:
     *  Monstruo mons: Es el monstruo que estará en esta casilla.
     *  float prob: Es la probabilidad de que este monstruo aparezca.
     * 
     */
    public Bosque(Monstruo mons, float prob){
        SetPosi(prob);
        SetMonstruo(mons);
        SetNPC(null);
    }

    /**
     * Bosque()
     * 
     * Es uno de los constructores de clase, que inicializan ciertos
     * valores para su uso en el resto del programa.
     * 
     * Input:
     *  Jefe_Final mons: Es el jefe final que estará en esta casilla.
     *  float prob: Es la probabilidad de que este jefe aparezca.
     * 
     */
    public Bosque(Jefe_Final mons, float prob){
        SetPosi(prob);
        SetJefe(mons);
        SetNPC(null);
    }

    /**
     * Bosque()
     * 
     * Es uno de los constructores de clase, que inicializan ciertos
     * valores para su uso en el resto del programa.
     * 
     * Input:
     *  Monstruo mons: Es el monstruo que estará en esta casilla.
     *  float prob: Es la probabilidad de que este monstruo aparezca.
     *  NPC we: Es el npc que estará en esta casilla.
     * 
     */
    public Bosque(Monstruo mons, NPC we, float prob ){
        SetPosi(prob);
        SetMonstruo(mons);
        SetNPC(we);
    }

    /**
     * Bosque()
     * 
     * Es uno de los constructores de clase, que inicializan ciertos
     * valores para su uso en el resto del programa.
     * 
     * Input:
     *  Jefe_Final mons: Es el jefe final que estará en esta casilla.
     *  float prob: Es la probabilidad de que este jefe aparezca.
     *  NPC we: Es el npc que estará en esta casilla.
     * 
     */
    public Bosque(Jefe_Final mons, NPC we, float prob ){
        SetPosi(prob);
        SetJefe(mons);
        SetNPC(we);
    }
}
