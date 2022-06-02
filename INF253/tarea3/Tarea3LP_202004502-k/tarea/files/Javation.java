package tarea.files;

import java.util.Scanner;

public class Javation {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("<<< Bienvenido a Javation V  >>>");
        System.out.println("Ingresa el nombre para tu jugador:");
        String nombre_player = input.nextLine();
        Jugador player = new Jugador(nombre_player);
        System.out.println("Bienvenido/a " + nombre_player);

        boolean flag_game = true;
        while (flag_game) {
            System.out.println("¿Que deseas hacer? Elije una opción:");
            System.out.println("<<------------------------------------------------->>");
            System.out.println("1.-  Crear una nueva persona");
            System.out.println("2.-  Crear un nuevo dificio");
            System.out.println("3.-  Crear una nueva atracción");
            System.out.println("4.-  Mejorar una persona existente");
            System.out.println("5.-  Mejorar un edificio existente");
            System.out.println("6.-  Mover una persona a un edificio");
            System.out.println("7.-  Sacar una persona de un edificio");
            System.out.println("8.-  Mostrar personas que no están en edificios");
            System.out.println("9.-  Mostrar edificios construidos");
            System.out.println("10.- Mostrar atracciones construidas");
            System.out.println("11.- Terminar la partida y salir del juego");
            System.out.println("<<------------------------------------------------->>");
            System.out.print("Ingresa el numero correspondiente a tu elección: ");
            Integer opcion_jugador = input.nextInt();
            
            if (opcion_jugador.equals(1)) {
                
            } else if (opcion_jugador.equals(2)){
                
            } else if (opcion_jugador.equals(3)){
                
            } else if (opcion_jugador.equals(4)){
                
            } else if (opcion_jugador.equals(5)){
                
            } else if (opcion_jugador.equals(6)){
                
            } else if (opcion_jugador.equals(7)){
                
            } else if (opcion_jugador.equals(8)){
                
            } else if (opcion_jugador.equals(9)){
                
            } else if (opcion_jugador.equals(10)){
                
            } else if (opcion_jugador.equals(11)){
                System.out.println("Decidiste terminar esta partida, adiós!");
                System.exit(0);
            } else {
                System.out.println("Ingresaste un número que no está dentro de las opciones, intentalo otra vez.");
                continue;
            }



        }
    }
    
}