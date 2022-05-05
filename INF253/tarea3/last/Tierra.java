package LOM.files;
//package INF253.tarea3;

public abstract class Tierra {
    private float probabilidad_enemigo;
    private Monstruo monstruo;
    private Jefe_Final jefe_final;
    private NPC npc;
    public abstract boolean accion(Jugador jugador);


    /**
     * void SetNPC()
     * 
     * Esta funcion setter tiene como objetivo asignar 
     * el valor de la variable entregada a los atributos de
     * la clase abstracta.
     * 
     * Input:
     *  NPC temp: Es el npc a asignar al atributo NPC npc de la clase abstracta.
     * 
     * Output:
     *  void: No retorna, solo hace cambios internos.
     */
    public void SetNPC(NPC temp){
        npc = temp;
    }

    /**
     * NPC GetNPC()
     * 
     * Esta funcion getter tiene como objetivo retornar
     * el NPC desde la clase abstracta.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  NPC: retorna el npc desde la clase abstracta.
     */
    public NPC GetNPC(){
        return npc;
    }

    /**
     * void SetPosi()
     * 
     * Esta funcion setter tiene como objetivo asignar 
     * el valor de la variable entregada a los atributos de
     * la clase abstracta.
     * 
     * Input:
     *  float prob: Es la probabilidad de que el enemigo aparezca en la casilla.
     * 
     * Output:
     *  void: No retorna, solo hace cambios internos.
     */
    public void SetPosi(float prob){
        probabilidad_enemigo = prob;
    }

    /**
     * float GetPosi()
     * 
     * Esta funcion getter tiene como objetivo retornar
     * la probabilidad de aparicion del enemigo desde la clase abstracta.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  float: retorna la probabilidad desde la clase abstracta.
     */
    public float GetPosi(){
        return probabilidad_enemigo;
    }

    /**
     * void SetMonstruo()
     * 
     * Esta funcion setter tiene como objetivo asignar 
     * el valor de la variable entregada a los atributos de
     * la clase abstracta.
     * 
     * Input:
     *  Monstruo mons: Es el monstruo correspondiente a la casilla.
     * 
     * Output:
     *  void: No retorna, solo hace cambios internos.
     */
    public void SetMonstruo(Monstruo mons){
        monstruo = mons;
    }


    /**
     * Monstruo GetMonstruo()
     * 
     * Esta funcion getter tiene como objetivo retornar
     * el monstruo desde la clase abstracta.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  Monstruo: retorna el monstruo desde la clase abstracta.
     */
    public Monstruo GetMonstruo(){
        return monstruo;
    }

    /**
     * void SetJefe()
     * 
     * Esta funcion setter tiene como objetivo asignar 
     * el valor de la variable entregada a los atributos de
     * la clase abstracta.
     * 
     * Input:
     *  Jefe_Final jefe: Es el jefe final correspondiente a la casilla.
     * 
     * Output:
     *  void: No retorna, solo hace cambios internos.
     */
    public void SetJefe(Jefe_Final jefe){
        jefe_final = jefe;
    }


    /**
     * Jefe_Final GetJefe()
     * 
     * Esta funcion getter tiene como objetivo retornar
     * el Jefe final desde la clase abstracta.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  Jefe_Final: retorna el jefe final desde la clase abstracta.
     */
    public Jefe_Final GetJefe(){
        return jefe_final;
    }
}
