package tarea.files;


import java.util.ArrayList;
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
        boolean flag_turno = false;
        while (flag_game) {
            System.out.println("¿Que deseas hacer? Elije una opción:");
            System.out.println("<<------------------------------------------------->>");
            System.out.println("1.-  Crear una nueva persona");
            System.out.println("2.-  Crear un nuevo edificio");
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
            input.nextLine();
            
            if (opcion_jugador.equals(1)) {
                System.out.println("Crear personas tiene un costo: los granjeros, los cientificos y los herreros cuestan 5, 8 y 6 Javalares respectivamente.");
                System.out.println("Actualmente tienes "+player.getJavalares()+" Javalares.");
                String clase_perCrear, nombre_perCrear;
                System.out.println("¿Qué tipo de persona quieres crear: un granjero, un científico o un herrero?");
                clase_perCrear = input.nextLine();
                System.out.println("¿Cuál va a ser su nombre?");
                nombre_perCrear = input.nextLine();

                if (clase_perCrear.equals("Granjero")){
                    if (player.getJavalares() >= 5){
                        Granjero temp = new Granjero(nombre_perCrear);
                        System.out.println("Se ha creado un nuevo granjero llamado "+nombre_perCrear);
                        player.agregar_persona(temp);
                        player.setJavalares( player.getJavalares() - 5);
                    }else {
                        System.out.println("No tienes suficientes Javalares para crear un granjero");
                        continue;
                    }
                } else if (clase_perCrear.equals("Cientifico")){
                    if (player.getJavalares() >= 8){
                        Cientifico temp = new Cientifico(nombre_perCrear);
                        System.out.println("Se ha creado un nuevo científico llamado "+nombre_perCrear);
                        player.agregar_persona(temp);
                        player.setJavalares( player.getJavalares() - 8);
                    }else {
                        System.out.println("No tienes suficientes Javalares para crear un científico");
                        continue;
                    }
                } else if (clase_perCrear.equals("Herrero")){
                    if (player.getJavalares() >= 6){
                        Herrero temp = new Herrero(nombre_perCrear);
                        System.out.println("Se ha creado un nuevo herrero llamado "+nombre_perCrear);
                        player.agregar_persona(temp);
                        player.setJavalares( player.getJavalares() - 6);
                    }else {
                        System.out.println("No tienes suficientes Javalares para crear un herrero");
                        continue;
                    }
                }
                
                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(2)){
                System.out.println("Construir edificios tiene un costo:");
                System.out.println("Actualmente tienes "+player.getJavalares()+" Javalares, "+player.getHierro()+" de Hierro, "+player.getTrigo()+" de Trigo y "+player.getTecnologia()+" de Tecnología");
                System.out.println("Los graneros cuestan 10 Javalares, 5 de Hierro y 5 de Trigo");
                System.out.println("Los laboratorios cuestan 30 Javalares, 10 de Hierro y 6 de Tecnología");
                System.out.println("Las herrerías cuestan 20 Javalares y 20 de Hierro");
                System.out.println("Las zonas comunes cuestan 15 Javalares, 3 de Hierro, 3 de Trigo y 3 de Tecnología");
                String clase_ediCrear, nombre_ediCrear;
                System.out.println("¿Qué tipo de edificio quieres crear: un Granero, un Laboratorio, una Herrería o una Zona Común?");
                clase_ediCrear = input.nextLine();
                System.out.println("¿Cuál va a ser su nombre?");
                nombre_ediCrear = input.nextLine();
                


                
                // (((player.getJavalares() >= 10) && (player.getHierro() >= 5)) && (player.getTrigo() >= 5))
                // (((player.getJavalares() >= 30) && (player.getHierro() >= 10)) && (player.getTecnologia() >= 6))
                // (((player.getJavalares() >= 15) && (player.getHierro() >= 3)) && ((player.getTrigo() >= 3) && (player.getTecnologia() >= 3)))

                if (clase_ediCrear.equals("Granero")){
                    if ((((player.getJavalares() >= 10) && (player.getHierro() >= 5)) && (player.getTrigo() >= 5))){
                        Granero temp = new Granero(nombre_ediCrear);
                        System.out.println("Se ha creado un nuevo granero llamado "+nombre_ediCrear);
                        player.agregar_edificio(temp);
                        player.setJavalares( player.getJavalares() - 10);
                        player.setHierro( player.getHierro() - 5);
                        player.setTrigo( player.getTrigo() - 5);
                    }else {
                        System.out.println("No tienes suficientes recursos para crear un granero");
                        continue;
                    }
                } else if (clase_ediCrear.equals("Laboratorio")){
                    if ((((player.getJavalares() >= 30) && (player.getHierro() >= 10)) && (player.getTecnologia() >= 6))){
                        Laboratorio temp = new Laboratorio(nombre_ediCrear);
                        System.out.println("Se ha creado un nuevo laboratorio llamado "+nombre_ediCrear);
                        player.agregar_edificio(temp);
                        player.setJavalares( player.getJavalares() - 30);
                        player.setHierro( player.getHierro() - 10);
                        player.setTrigo( player.getTecnologia() - 6);
                    }else {
                        System.out.println("No tienes suficientes recursos para crear un laboratorio");
                        continue;
                    }
                } else if (((clase_ediCrear.equals("Herreria")) || (clase_ediCrear.equals("Herrería")))){
                    if (((player.getJavalares() >= 20) && (player.getHierro() >= 20))){
                        Herreria temp = new Herreria(nombre_ediCrear);
                        System.out.println("Se ha creado una nueva herrería llamada "+nombre_ediCrear);
                        player.agregar_edificio(temp);
                        player.setJavalares( player.getJavalares() - 20);
                        player.setHierro( player.getHierro() - 20);
                    }else{
                        System.out.println("No tienes suficientes recursos para crear una herrería");
                        continue;
                    }
                } else if ((clase_ediCrear.equals("Zona Comun"))||(clase_ediCrear.equals("Zona Común"))){
                    if ((((player.getJavalares() >= 15) && (player.getHierro() >= 3)) && ((player.getTrigo() >= 3) && (player.getTecnologia() >= 3)))){
                        ZonaComun temp = new ZonaComun(nombre_ediCrear);
                        System.out.println("Se ha creado una nueva zona común llamada "+nombre_ediCrear);
                        player.agregar_edificio(temp);
                        player.setJavalares( player.getJavalares() - 15);
                        player.setHierro( player.getHierro() - 3);
                        player.setTrigo( player.getTrigo() - 3);
                        player.setTrigo( player.getTecnologia() - 3);
                    }else{
                        System.out.println("No tienes suficientes recursos para crear una zona común");
                        continue;
                    }
                    
                }

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(3)){
                System.out.println("Construir atracciones tiene un costo:");
                System.out.println("Actualmente tienes "+player.getJavalares()+" Javalares, "+player.getHierro()+" de Hierro, "+player.getTrigo()+" de Trigo y "+player.getTecnologia()+" de Tecnología");
                System.out.println("Las ferias cuestan 50 Javalares, 25 de Hierro, 25 de Trigo y 10 de Tecnología");
                System.out.println("Los museos cuestan 50 Javalares, 30 de Hierro, 3 de Trigo y 30 de Tecnología");
                System.out.println("Los Javapatos cuestan 50 Javalares, 40 de Hierro y 20 de Tecnología");
                String clase_atrCrear, nombre_atrCrear;
                System.out.println("¿Qué tipo de atracción quieres crear: una Feria, un Museo o un Javapato?");
                clase_atrCrear = input.nextLine();
                System.out.println("¿Cuál va a ser su nombre?");
                nombre_atrCrear = input.nextLine();

                if(clase_atrCrear.equals("Feria")){
                    if ((((player.getJavalares() >= 50) && (player.getHierro() >= 25)) && ((player.getTrigo() >= 25) && (player.getTecnologia() >= 10)))){
                        Feria temp = new Feria(nombre_atrCrear);
                        System.out.println("Se ha creado una nueva feria llamada "+nombre_atrCrear);
                        player.agregar_feria(temp);
                        player.setJavalares( player.getJavalares() - 50);
                        player.setHierro( player.getHierro() - 25);
                        player.setTrigo( player.getTrigo() - 25);
                        player.setTrigo( player.getTecnologia() - 10);
                    }else{
                        System.out.println("No tienes suficientes recursos para crear una feria");
                        continue;
                    }
                }else if (clase_atrCrear.equals("Museo")){
                    if ((((player.getJavalares() >= 50) && (player.getHierro() >= 30)) && ((player.getTrigo() >= 3) && (player.getTecnologia() >= 30)))){
                        Museo temp = new Museo(nombre_atrCrear);
                        System.out.println("Se ha creado un nuevo museo llamado "+nombre_atrCrear);
                        player.agregar_museo(temp);
                        player.setJavalares( player.getJavalares() - 50);
                        player.setHierro( player.getHierro() - 30);
                        player.setTrigo( player.getTrigo() - 3);
                        player.setTrigo( player.getTecnologia() - 30);
                    }else {
                        System.out.println("No tienes suficientes recursos para crear un museo");
                        continue;
                    }
                }else if (clase_atrCrear.equals("Javapato")){
                    if ((((player.getJavalares() >= 50) && (player.getHierro() >= 40)) && (player.getTecnologia() >= 20))){
                        Javapato temp = new Javapato(nombre_atrCrear);
                        System.out.println("Se ha creado un nuevo Javapato llamado "+nombre_atrCrear);
                        player.agregar_javapato(temp);
                        player.setJavalares( player.getJavalares() - 50);
                        player.setHierro( player.getHierro() - 40);
                        player.setTrigo( player.getTecnologia() - 20);
                    }else {
                        System.out.println("No tienes suficientes recursos para crear un Javapato");
                        continue;
                    }
                }

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(4)){
                System.out.println("Mejorar personas cuesta 15 Javalares cada uno");
                System.out.println("Actualmente tienes "+player.getJavalares()+" Javalares.");
                System.out.println("¿Qué persona quieres mejorar? Ingresa su nombre:");
                String nombre_perMejorar = input.nextLine();
                if (player.getJavalares() >= 15){
                    for (int i = 0; i < player.getPersonas().size(); i++){
                        if (player.getPersonas().get(i).getNombre().equals(nombre_perMejorar)){
                            player.getPersonas().get(i).mejorar();
                            player.setJavalares( player.getJavalares() - 15);
                            System.out.println("Has mejorado a "+nombre_perMejorar);

                        }
                    }
                    for (int i = 0; i < player.getEdificios().size(); i++){
                        for (int j = 0; j < player.getEdificios().get(i).getPersonas().size(); j++){
                            if (player.getEdificios().get(i).getPersonas().get(j).getNombre().equals(nombre_perMejorar)){
                                player.getEdificios().get(i).getPersonas().get(j).mejorar();
                                player.setJavalares( player.getJavalares() - 15);
                                System.out.println("Has mejorado a "+nombre_perMejorar);
                            }   
                        }
                    }
                }else{
                    System.out.println("No tienes suficientes Javalares para mejorar personas");
                    continue;
                }

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(5)){
                System.out.println("Mejorar edificios tiene un costo asociado a su tipo:");
                System.out.println("Los graneros cuestan 20 Javalares, 10 de Hierro y 15 de Trigo");
                System.out.println("Los laboratorios cuestan 20 Javalares, 15 de Hierro y 10 de Tecnología");
                System.out.println("Las herrerías cuestan 20 Javalares y 20 de Hierro");
                System.out.println("Las zonas comunes cuestan 15 Javalares, 10 de Hierro, 10 de Trigo y 10 de Tecnología");
                System.out.println("Actualmente tienes "+player.getJavalares()+" Javalares, "+player.getHierro()+" de Hierro, "+player.getTrigo()+" de Trigo y "+player.getTecnologia()+" de Tecnología");
                System.out.println("¿Cúal edificio quieres mejorar? Ingresa el nombre:");
                String nombre_ediMejorar = input.nextLine();
                for (int i = 0; i < player.getEdificios().size(); i++){
                    if (player.getEdificios().get(i).getNombre().equals(nombre_ediMejorar)){
                        if (player.getEdificios().get(i) instanceof Granero){
                            if ((((player.getJavalares() >= 20) && (player.getHierro() >= 10)) && (player.getTrigo() >= 15))){
                                player.getEdificios().get(i).mejorar();
                                System.out.println("Se ha mejorado el granero llamado "+nombre_ediMejorar);
                                player.setJavalares( player.getJavalares() - 20);
                                player.setHierro( player.getHierro() - 10);
                                player.setTrigo( player.getTrigo() - 15);
                            }else{
                                System.out.println("No tienes suficientes recursos para mejorar este granero");
                                continue;
                            }
                        }else if (player.getEdificios().get(i) instanceof Laboratorio){
                            if ((((player.getJavalares() >= 20) && (player.getHierro() >= 15)) && (player.getTecnologia() >= 10))){
                                player.getEdificios().get(i).mejorar();
                                System.out.println("Se ha mejorado el laboratorio llamado "+nombre_ediMejorar);
                                player.setJavalares( player.getJavalares() - 20);
                                player.setHierro( player.getHierro() - 15);
                                player.setTecnologia( player.getTecnologia() - 10);
                            }else{
                                System.out.println("No tienes suficientes recursos para mejorar este laboratorio");
                                continue;
                            }
                        }else if (player.getEdificios().get(i) instanceof Herreria){
                            if (((player.getJavalares() >= 20) && (player.getHierro() >= 20))){
                                player.getEdificios().get(i).mejorar();
                                System.out.println("Se ha mejorado la herrería llamada "+nombre_ediMejorar);
                                player.setJavalares( player.getJavalares() - 20);
                                player.setHierro( player.getHierro() - 20);
                            }else{
                                System.out.println("No tienes suficientes recursos para mejorar esta herrería");
                                continue;
                            }
                        }else if (player.getEdificios().get(i) instanceof ZonaComun){
                            if ((((player.getJavalares() >= 15) && (player.getHierro() >= 10)) && ((player.getTrigo() >= 10) && (player.getTecnologia() >= 10)))){
                                player.getEdificios().get(i).mejorar();
                                System.out.println("Se ha mejorado la zona común llamada "+nombre_ediMejorar);
                                player.setJavalares( player.getJavalares() - 15);
                                player.setHierro( player.getHierro() - 10);
                                player.setTrigo( player.getTrigo() - 10);
                                player.setTrigo( player.getTecnologia() - 10);
                            }else{
                                System.out.println("No tienes suficientes recursos para mejorar esta zona común");
                                continue;
                            }
                        }
                    }
                }
                
                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(6)){
                System.out.println("¿Cúal persona quieres mover?");
                String nombre_perMover = input.nextLine();
                int indice_perMover = 0;
                for (int i = 0; i < player.getPersonas().size(); i++){
                    if (player.getPersonas().get(i).getNombre().equals(nombre_perMover)){
                        indice_perMover = i;
                    }
                }
                System.out.println("¿A qué edificio la quieres mover?");
                String nombre_ediMover = input.nextLine();
                for (int i = 0; i < player.getEdificios().size(); i++){
                    if (player.getEdificios().get(i).getNombre().equals(nombre_ediMover)){
                        if ((player.getEdificios().get(i).getPersonas().size() + 1) <= player.getEdificios().get(i).getCapacidad()){
                        player.getEdificios().get(i).agregar_persona(player.getPersonas().get(indice_perMover));
                        player.getPersonas().remove(indice_perMover);
                        }else{
                            System.out.println("El edificio está en su máxima capacidad, no puedes mover a esa persona ahí");
                        }
                    }
                }

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
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

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(8)){
                System.out.println("Las siguientes personas no están en ningún edificio");
                String tablita = "| %-20s | %-4d | %-5d |%n";
                System.out.format("+----------------------+------+-------+%n");
                System.out.format("| Nombre de la persona | Edad | Nivel |%n");
                System.out.format("+----------------------+------+-------+%n");
                for (int i = 0; i < player.getPersonas().size(); i++){
                    System.out.format(tablita, player.getPersonas().get(i).getNombre(), player.getPersonas().get(i).getEdad(), player.getPersonas().get(i).getNivel());
                }
                System.out.format("+----------------------+------+-------+%n");
                
                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(9)){
                Integer flag = 1;
                System.out.println("Estos son los edificios que has construido hasta ahora:");
                String leftAlignFormat = "| %-19s | %-5d |%n";  
                System.out.format("+---------------------+-------+%n");
                System.out.format("| Nombre del edificio | Nivel |%n");
                System.out.format("+---------------------+-------+%n");
                for (int i = 0; i < player.getEdificios().size(); i++) {
                    System.out.format(leftAlignFormat, player.getEdificios().get(i).getNombre(), player.getEdificios().get(i).getNivel());
                }
                System.out.format("+---------------------+-------+%n");
                System.out.println("");
                System.out.println("Y estas son las personas que están en cada edificio");
                String leftAlignFormat2 = "| %-19s | %-20s |%n";  
                System.out.format("+---------------------+----------------------+%n");
                System.out.format("| Nombre del edificio | Nombre de la persona |%n");
                System.out.format("+---------------------+----------------------+%n");
                for (int i = 0; i < player.getEdificios().size(); i++) {
                    flag = 1;
                    for (int j = 0; j < player.getEdificios().get(i).getPersonas().size(); j++) {
                        if (flag.equals(1)){
                            System.out.format(leftAlignFormat2, player.getEdificios().get(i).getNombre(), player.getEdificios().get(i).getPersonas().get(j).getNombre());
                            flag = 0;
                        }else{
                            System.out.format(leftAlignFormat2, "", player.getEdificios().get(i).getPersonas().get(j).getNombre());
                        }
                    }
                }
                System.out.format("+---------------------+----------------------+%n");

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
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
                System.out.format("+------------------------+-------------------+%n");

                System.out.println("");
                System.out.println("¿Quieres terminar el turno? (Si/No)");
                String turno = input.nextLine();
                if (turno.equals("Si")){
                    flag_turno = true;
                }
            } else if (opcion_jugador.equals(11)){
                System.out.println("Decidiste terminar esta partida, ¡adiós!");
                System.exit(0);
                input.close();
            } else {
                System.out.println("Ingresaste un número que no está dentro de las opciones, intentalo otra vez.");
                continue;
            }

            if (flag_turno == true){
                for (int i = 0; i < player.getEdificios().size(); i++) {
                    ArrayList<Integer> temp = player.getEdificios().get(i).producir();
                    player.setJavalares( player.getJavalares() + temp.get(0));
                    player.setHierro( player.getHierro() + temp.get(1));
                    player.setTrigo( player.getTrigo() + temp.get(2));
                    player.setTecnologia( player.getTecnologia() + temp.get(3));
                }

                Integer suma = 0;
                for (int i = 0; i < player.getFerias().size(); i++) {
                    suma += player.getFerias().get(i).visitar(player.getPersonas());
                    for (int j = 0; j < player.getEdificios().size(); j++) {
                        suma += player.getFerias().get(i).visitar( player.getEdificios().get(j).getPersonas());
                    }
                }
                for (int i = 0; i < player.getMuseos().size(); i++) {
                    suma += player.getMuseos().get(i).visitar(player.getPersonas());
                    for (int j = 0; j < player.getEdificios().size(); j++) {
                        suma += player.getMuseos().get(i).visitar( player.getEdificios().get(j).getPersonas());
                    }
                }
                for (int i = 0; i < player.getJavapatos().size(); i++) {
                    suma += player.getJavapatos().get(i).visitar(player.getPersonas());
                    for (int j = 0; j < player.getEdificios().size(); j++) {
                        suma += player.getJavapatos().get(i).visitar( player.getEdificios().get(j).getPersonas());
                    }
                }
                player.setJavalares( player.getJavalares() + suma);
                ArrayList<String> lista_muertos = new ArrayList<String>();
                for (int i = 0; i < player.getPersonas().size(); i++) {
                    player.getPersonas().get(i).envejecer();
                    if (player.getPersonas().get(i).getEdad() > 30){
                        lista_muertos.add(player.getPersonas().get(i).getNombre());
                        player.getPersonas().remove(i);
                    }else{
                        System.out.println(player.getPersonas().get(i).getNombre()+" ha cumplido "+player.getPersonas().get(i).getEdad()+" años!");
                    }
                }
                for (int j = 0; j < player.getEdificios().size(); j++) {
                    for (int j2 = 0; j2 < player.getEdificios().get(j).getPersonas().size(); j2++) {
                        player.getEdificios().get(j).getPersonas().get(j2).envejecer();
                        if (player.getEdificios().get(j).getPersonas().get(j2).getEdad() > 30) {
                            lista_muertos.add(player.getEdificios().get(j).getPersonas().get(j2).getNombre());
                            player.getEdificios().get(j).getPersonas().remove(j2);
                        }else{
                            System.out.println(player.getEdificios().get(j).getPersonas().get(j2).getNombre()+" ha cumplido "+player.getEdificios().get(j).getPersonas().get(j2).getEdad()+" años!") ;
                        }
                    }
                }

                System.out.println("En este turno han muerto las siguientes personas:");
                for (int j2 = 0; j2 < lista_muertos.size(); j2++) {
                    System.out.println(lista_muertos.get(j2));
                }

                flag_turno = false;
                System.out.println("En este turno has quedado con "+player.getJavalares()+" Javalares, "+player.getHierro()+" de Hierro, "+player.getTrigo()+" de Trigo y "+player.getTecnologia()+" de Tecnología");
                System.out.println("");
            }
        }
    }
}