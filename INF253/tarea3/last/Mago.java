//package INF253.tarea3;
package LOM.files;

//import java.util.ArrayList;
//import java.util.List;

public class Mago extends Jugador {
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
        int v_int = GetInteligencia()/4;
        int retorno = (GetFuerza() * v_int) + GetEnergia();
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
        int v_fuer = GetFuerza()/4;
        int retorno2 = (GetInteligencia() * v_fuer) + GetMana();
        SetMana(GetMana() - 5);
        return retorno2;
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
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 2!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 2) && (((50>xp)&&(xp>=25))|| (xp >50) )){
            level +=1;
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 3!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 3)&&(((100>xp)&&(xp>=50)) || (xp >100)) ){
            level +=1;
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 4!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 4)&&(((200>xp)&&(xp>=100))|| (xp >200) ) ){
            level +=1;
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 5!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 5)&&(((350>xp)&&(xp>=200)) || (xp >350))){
            level +=1;
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 6!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 6)&&(((600>xp)&&(xp>=350)) || (xp >600))){
            level +=1;
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 7!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        } 
        if ((level == 7)&&(((900>xp)&&(xp>=600)) || (xp >900))){
            level +=1;
            SetVidaMax(GetVidaMax() + 2*level);
            SetFuerza(GetFuerza() + 1);
            SetInteligencia(GetInteligencia() + 3*level);
            SetEnergiaMax(GetEnergiaMax() + 1);
            SetManaMax(GetManaMax() + 3*level);
            System.out.println("¡Has subido al nivel 8!");
            SetVida(GetVidaMax());
            SetEnergia(GetEnergiaMax());
            SetMana(GetManaMax());
        }
    }


    /**
     * Mago()
     * 
     * Este es el constructor de una de las subclases de jugador.
     * 
     * Input:
     *  String x: Nombre del jugador.
     * 
     */
    public Mago(String x){
        SetNombre(x);
        SetVida(10);
        SetXP(0);
        SetFuerza(3);
        SetInteligencia(10);
        SetEnergia(6);
        SetMana(15);
        SetVidaMax(10);
        SetEnergiaMax(6);
        SetManaMax(15);
        InitMisiones();
    }
}
