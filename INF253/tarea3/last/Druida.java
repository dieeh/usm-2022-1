//package INF253.tarea3;
package LOM.files;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Set;

public class Druida extends Jugador {
    private int level = 1;
    //private List<Mision> lista_misiones = new ArrayList<Mision>();


    /**
     * int ataque()
     * 
     * Esta funcion calcula el daño del ataque a realizar por
     * el jugador en base a sus stats.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  int: Retorna la cantidad de daño
     */
    public int ataque(){
        if (GetEnergia() <= 0) {
            System.out.println("<< ¡No te queda energía! >>");
            SetEnergia(0);
            return 0;
        }
        int v_fyi = (GetFuerza() + GetInteligencia()) / 3;
        int v_em = Math.max(GetEnergia()/3, GetMana()/2);
        int retorno = v_fyi * v_em;
        SetEnergia(GetEnergia() - 3);
        return retorno;
    }

    /**
     * int hechizo()
     * 
     * Esta funcion calcula el daño del hechizo a lanzar por
     * el jugador en base a sus stats.
     * 
     * Input:
     *  Ninguno.
     * 
     * Output:
     *  int: Retorna la cantidad de daño
     */
    public int hechizo(){
        if (GetMana() <= 0) {
            System.out.println("<< ¡No te queda maná! >>");
            SetMana(0);
            return 0;
        }
        int v_fyi = (GetFuerza() + GetInteligencia()) / 3;
        int v_em = Math.max(GetEnergia()/2, GetMana()/3);
        int retorno = v_fyi * v_em;
        SetMana(GetMana() - 3);
        return retorno;
    }


    /**
     * void subir_experiencia()
     * 
     * Este metodo revisa si con la experiencia actual el jugador
     * sube o no de nivel.
     * 
     * Input:
     *  int xp: los puntos de experiencia del jugador.
     * 
     * Output:
     *  Ninguno.
     */
    public void subir_experiencia(int xp){
        if ((level == 1)&&(((25>xp)&&(xp>=10) )|| (xp >25) )) {
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 2!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        }
        if ((level == 2) && (((50>xp)&&(xp>=25))|| (xp >50) )){
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 3!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 3)&&(((100>xp)&&(xp>=50)) || (xp >100)) ){
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 4!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 4)&&(((200>xp)&&(xp>=100))|| (xp >200) ) ){
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 5!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 5)&&(((350>xp)&&(xp>=200)) || (xp >350))){
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 6!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 6)&&(((600>xp)&&(xp>=350)) || (xp >600))){
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 7!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 7)&&(((900>xp)&&(xp>=600)) || (xp >900))){
            level +=1;
            SetVidaMax(GetVidaMax() + level);
            SetFuerza(GetFuerza() + level);
            SetInteligencia(GetInteligencia() + level);
            SetEnergiaMax(GetEnergiaMax() + level);
            SetManaMax(GetManaMax() + level);
            System.out.println("¡Haz subido al nivel 8!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        }
    }



    /**
     * Druida()
     * 
     * Este es el constructor de una de las subclases de jugador.
     * 
     * Input:
     *  String x: Nombre del jugador.
     * 
     */
    public Druida(String x){
        SetNombre(x);
        SetVida(15);
        SetXP(0);
        this.level = 1;
        SetFuerza(5);
        SetInteligencia(5);
        SetEnergia(5);
        SetMana(5);
        SetVidaMax(5);
        SetEnergiaMax(5);
        SetManaMax(5);
        InitMisiones();
    }
}
