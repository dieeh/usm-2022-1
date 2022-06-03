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
            System.out.format("%n");
            
            if (opcion_jugador.equals(1)) {
                String clase_perCrear, nombre_perCrear;
                System.out.println("¿Qué tipo de persona quieres crear: un granjero, un científico o un herrero?");
                clase_perCrear = input.nextLine();
                System.out.println("¿Cuál va a ser su nombre?");
                nombre_perCrear = input.nextLine();

                if (clase_perCrear.equals("Granjero")){
                    Granjero temp = new Granjero(nombre_perCrear);
                    System.out.println("Se ha creado un nuevo granjero llamado "+nombre_perCrear);
                    player.agregar_persona(temp);
                } else if (clase_perCrear.equals("Cientifico")){
                    Cientifico temp = new Cientifico(nombre_perCrear);
                    System.out.println("Se ha creado un nuevo científico llamado "+nombre_perCrear);
                    player.agregar_persona(temp);
                } else if (clase_perCrear.equals("Herrero")){
                    Herrero temp = new Herrero(nombre_perCrear);
                    System.out.println("Se ha creado un nuevo herrero llamado "+nombre_perCrear);
                    player.agregar_persona(temp);
                }
                

            } else if (opcion_jugador.equals(2)){
                System.out.println("¿Qué tipo de edificio quieres crear: un Granero, un Laboratorio, una Herrería o una Zona Común?"); 

            } else if (opcion_jugador.equals(3)){
                System.out.println("¿Qué tipo de atracción quieres crear: una Feria, un Museo o un Javapato?");

            } else if (opcion_jugador.equals(4)){
                System.out.println("¿Qué persona quieres mejorar? Ingresa su nombre:");
                String nombre_perMejorar = input.nextLine();
                for (int i = 0; i < player.getPersonas().size(); i++){
                    if (player.getPersonas().get(i).getNombre().equals(nombre_perMejorar)){
                        player.getPersonas().get(i).mejorar();
                    }
                }
                for (int i = 0; i < player.getEdificios().size(); i++){
                    for (int j = 0; j < player.getEdificios().get(i).getPersonas().size(); j++){
                        if (player.getEdificios().get(i).getPersonas().get(j).getNombre().equals(nombre_perMejorar)){
                            player.getEdificios().get(i).getPersonas().get(j).mejorar();
                        }   
                    }
                }

            } else if (opcion_jugador.equals(5)){
                System.out.println("¿Cúal edificio quieres mejorar? Ingresa el nombre:");
                String nombre_ediMejorar = input.nextLine();
                for (int i = 0; i < player.getEdificios().size(); i++){
                    if (player.getEdificios().get(i).getNombre().equals(nombre_ediMejorar)){
                        player.getEdificios().get(i).mejorar();
                    }
                }
                
            } else if (opcion_jugador.equals(6)){
                System.out.println("¿Cúal persona quieres mover?");
                String nombre_perMover = input.nextLine();
                Integer indice_perMover = 0;
                for (int i = 0; i < player.getPersonas().size(); i++){
                    if (player.getPersonas().get(i).getNombre().equals(nombre_perMover)){
                        indice_perMover = i;
                    }
                }
                System.out.println("¿A qué edificio la quieres mover?");
                String nombre_ediMover = input.nextLine();
                for (int i = 0; i < player.getEdificios().size(); i++){
                    if (player.getEdificios().get(i).getNombre().equals(nombre_ediMover)){
                        player.getEdificios().get(i).agregar_persona(player.getPersonas().get(indice_perMover));
                        player.getPersonas().remove(indice_perMover);
                    }
                }
            } else if (opcion_jugador.equals(7)){
                System.out.println("¿De cuál edificio quieres sacar gente?");
                String nombre_ediSacar = input.nextLine();
                String tabla = "| %-12s |%n";
                System.out.format("+--------------+%n");
                System.out.format("|   Edificio   |%n");
                System.out.format("+--------------+%n");
                Integer indice_ediSacar = 0;
                for (int i = 0; i < player.getEdificios().size(); i++){
                    if (player.getEdificios().get(i).getNombre().equals(nombre_ediSacar)){
                        indice_ediSacar = i;
                    }
                }
                for (int i = 0; i < player.getEdificios().get(indice_ediSacar).getPersonas().size(); i++){
                    System.out.format(tabla, player.getEdificios().get(indice_ediSacar).getPersonas().get(i).getNombre());
                }
                System.out.format("+--------------+%n");
                System.out.println("¿A quién quieres sacar?");
                String nombre_perSacar = input.nextLine();
                for (int i = 0; i < player.getEdificios().get(indice_ediSacar).getPersonas().size(); i++){
                    if (player.getEdificios().get(indice_ediSacar).getPersonas().get(i).getNombre().equals(nombre_perSacar)){
                        player.agregar_persona(player.getEdificios().get(indice_ediSacar).getPersonas().get(i));
                        player.getEdificios().get(indice_ediSacar).getPersonas().remove(i);
                    }
                }

            } else if (opcion_jugador.equals(8)){
                System.out.println("Las siguientes personas no están en ningún edificio");
                String tablita = "| %-20s | %-4d | %-5d |%n";
                System.out.format("+----------------------+------+-------+%n");
                System.out.format("| Nombre de la persona | Edad | Nivel |%n");
                System.out.format("+----------------------+------+-------+%n");
                for (int i = 0; i < player.getPersonas().size(); i++){
                    System.out.format(tablita, player.getPersonas().get(i).getNombre());
                }
                System.out.format("+----------------------+------+-------+%n");
                

            } else if (opcion_jugador.equals(9)){
                System.out.println("Estos son los edificios que has construido hasta ahora:");
                String leftAlignFormat = "| %-19s | %-5d |%n";  
                System.out.format("+---------------------+-------+%n");
                System.out.format("| Nombre del edificio | Nivel |%n");
                System.out.format("+---------------------+-------+%n");
                for (int i = 0; i < player.getEdificios().size(); i++) {
                    System.out.format(leftAlignFormat, player.getEdificios().get(i).getNombre(), player.getEdificios().get(i).getNivel());
                }
                System.out.format("+---------------------+-------+%n");

            } else if (opcion_jugador.equals(10)){
                System.out.println("Estas son las atracciones que has construido hasta ahora:");
                String formatoAtrac = "| %-22s | %-17s |%n";
                System.out.format("+------------------------+-------------------+%n");
                System.out.format("| Nombre de la atracción | Tipo de atracción |%n");
                System.out.format("+------------------------+-------------------+%n");
                for (int i = 0; i < player.getFerias().size(); i++){
                    System.out.format(formatoAtrac, player.getFerias().get(i).getNombre(), "Feria");
                }
                for (int i = 0; i < player.getMuseos().size(); i++){
                    System.out.format(formatoAtrac, player.getMuseos().get(i).getNombre(), "Museo");
                }
                for (int i = 0; i < player.getJavapatos().size(); i++){
                    System.out.format(formatoAtrac, player.getJavapatos().get(i).getNombre(), "Javapato");
                }

            } else if (opcion_jugador.equals(11)){
                System.out.println("Decidiste terminar esta partida, ¡adiós!");
                System.exit(0);

            } else {
                System.out.println("Ingresaste un número que no está dentro de las opciones, intentalo otra vez.");
                continue;
            }
        }
    }
}