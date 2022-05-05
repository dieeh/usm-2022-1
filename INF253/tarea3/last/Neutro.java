//package INF253.tarea3;
package LOM.files;
import java.util.Scanner;



public class Neutro extends NPC {
    private char requisito; 
    private int valor;
    private int recompensa;
    private int ya_dio_mision;

    /**
     * void interaccion()
     * 
     * Esta funcion representa la interaccion entre el jugador y el NPC
     * de la casilla, en este caso este npc ofrece una mision.
     * 
     * Input:
     *  Jugador jugador: Este parametro es el personaje creado en la
     *                   ejecucion del programa.
     * 
     * Output:
     *  Ninguno.
     */
    public void interaccion(Jugador jugador){
        if (ya_dio_mision == 0) {
            Scanner input = new Scanner(System.in);
            String text1;
            String text2;
            if (requisito == 'v') {
                text1 = "llegar a la casilla ";
                text2 = " del mundo ";
            } else{
                text1 = "matar una cantidad de ";
                text2 = " Monstruos ";
            }
            System.out.println("<"+GetNombre() +">: ¡Hola!, ¿Quieres cumplir esta misión? Deberás "+text1+Integer.toString(valor)+text2+"y recibirás "+Integer.toString(recompensa)+ " de experiencia.");
            System.out.println("<"+GetNombre() +">: Entonces, ¿aceptas? (Y/n)");
            String elecc = input.nextLine();
            if (elecc.equals("Y") == true){
                Mision temp = new Mision(requisito, valor, 0, recompensa);
                jugador.AddMisiones(temp);
                ya_dio_mision = 1;
                System.out.println("<"+GetNombre() +">: ¡Bien! He añadido la misión a tu lista de misiones, ¡adios!");
            } else if (elecc.equals("n") == true){
                System.out.println("<"+GetNombre() +">: Oh, es una lastima entonces, adios.");
            }
        } else if (ya_dio_mision != 0){
            System.out.println("<"+GetNombre() +">: Ya te di una misión, saludos.");
        }
    }


    /**
     * Neutro()
     * 
     * Este es el constructor de una de las subclases de NPC,
     * que recibe más parametros que las otras debido a que necesita
     * tener los datos para crear una mision.
     * 
     * Input:
     *  String nombre: Nombre del npc.
     *  char requisito: requisito de la mision, v para viajar y m para matar monstruos.
     *  int valor: la coordenada de la casilla a viajar o la cantidad de monstruos.
     *  int recompensa: la cantidad de xp que será recompensada al completar la mision.
     */
    public Neutro(String nombre, char requisito, int valor, int recompensa){
        SetNombre(nombre);
        this.requisito = requisito;
        this.valor = valor;
        this.recompensa = recompensa;
        this.ya_dio_mision = 0;
    }
}
