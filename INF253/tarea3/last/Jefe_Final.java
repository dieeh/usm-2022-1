//package INF253.tarea3;
package LOM.files;

import java.util.Scanner;



public class Jefe_Final implements Enemigo {
    private String nombre;
    private int vida;
    private int vida_i;
    private int dano_base;
    private int fase;

    /**
     * void combate()
     * 
     * Este metodo representa el combate entre el Jefe final y el jugador
     * 
     * Input:
     *  Jugador jugador: Es el personaje creado en la ejecucion del programa.
     * 
     * Output:
     *  Ninguno.
     */
    public void combate(Jugador jugador){
        System.out.println("¡¡Te has topado con el Jefe Final!!");
        System.out.println("¡Este Jefe Final se llama " + nombre + "!");
        while ((jugador.GetVida()> 0)&&(vida > 0)){
            Scanner input = new Scanner(System.in);
            System.out.println("¡Jugador, elige hacer un ataque o un hechizo contra el Jefe Final!");
            System.out.println("1: Ataque");
            System.out.println("2: Hechizo");
            int eleccion = input.nextInt();
            int dmg = 0;
            if (eleccion == 1) {
                dmg = jugador.ataque();
                System.out.println("¡Has realizado un ataque!");
            } else if (eleccion == 2){
                dmg = jugador.hechizo();
                System.out.println("¡Has lanzado un hechizo!");
            }
            vida = vida - dmg;
            System.out.println("¡Le has realizado " + Integer.toString(dmg) + " puntos de daño al Jefe Final!");
            if (vida <= 0) {
                vida = 0;
                System.out.println("¡Has vencido al Jefe Final "+nombre+"!");
                System.out.println("Has salvado el mundo, felicidades.");
                System.out.println("<===== Fin del juego =====>");
                input.close();
                System.exit(0);
            }
            System.out.println("Ahora atacará el Jefe Final...");
            if (vida <= vida_i/2){
                fase = 1;
            }
            jugador.SetVida(jugador.GetVida() - (dano_base + 2*fase));
            System.out.println("¡El Jefe Final te ha provocado "+ Integer.toString(dano_base + 2*fase) +" puntos de daño!");
            if (jugador.GetVida() <= 0) {
                //System.out.println("Has sido derrotado por el monstruo...");
                jugador.SetVida(0);
            }
        }
        //if (jugador.GetVida() <= 0) {
        //    //System.out.println("Has perdido...");
        //} else if (vida <= 0){
        //    System.out.println("¡Has vencido al Jefe Final!");
        //    System.out.println("Has salvado el mundo, felicidades.");
        //    System.out.println("<===== Fin del juego =====>");
        //    System.exit(0);
        //}
    }


    /**
     *  Jefe_Final()
     * 
     * Este es el segundo constructor de la clase Jefe_Final, y recibe
     * como parametro solo el nombre del Jefe, y el resto de los atributos
     * son definidos por defecto.
     * 
     * Input:
     *  String x: Nombre del jefe
     * 
     */
    public Jefe_Final(String x){
        this.nombre = x;
        this.vida = 50;
        this.vida_i = this.vida;
        this.dano_base = 15;
        this.fase = 2;
    }

    /**
     *  Jefe_Final()
     * 
     * Este es el constructor de la clase Jefe_Final, y recibe
     * como parametro el nombre del Jefe, la vida y el daño base
     * 
     * Input:
     *  String x: Nombre del jefe
     *  int y: Vida del jefe
     *  int z: Daño base del jefe.
     * 
     */
    public Jefe_Final(String x, int y, int z){
        this.nombre = x;
        this.vida = y;
        this.vida_i = this.vida;
        this.dano_base = z;
        this.fase = 2;
    }
}

