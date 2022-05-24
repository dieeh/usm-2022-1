package tarea.files;

import java.util.ArrayList;

public class Granero extends Edificio{
    
    public void mejorar(){
        setNivel( getNivel() + 1);
        setCapacidad(getCapacidad() + 3);
    }
    
    public ArrayList<Integer> producir(){
        ArrayList<Persona> temporal = getPersonas();
        int contador = 0;
        int contadorCient = 0;
        for (int i = 0; i < temporal.size(); i++) {
            if (temporal.get(i).getClass().getName() == "Granjero"){
                contador += 1;
            }
            if (temporal.get(i).getClass().getName() == "Cientifico"){
                contadorCient += 1;
            }
        }
        boolean flag = false;
        if (contador > (temporal.size()/2)) {
            flag = true;
        }
        ArrayList<Integer> temp;
        temp = new ArrayList<Integer>(4);

        if (flag == true) {
            Integer sum = 0;
            for (int i = 0; i < temporal.size(); i++) {
                sum += temporal.get(i).trabajo_realizado();
            }
            temp.add(sum/temporal.size()); //javalares
            temp.add(0); //hierro
            temp.add(sum/(temporal.size()/2));  //trigo
            temp.add(contadorCient/2);  //tecnologia
        }else{
            temp.add(-2 * temporal.size());
            temp.add(0);
            temp.add(0);
            temp.add(0);
        }

        //0 : javalares
        //1 : hierro
        //2 : trigo
        //3 : tecnologia

        return temp;
    }

    public Granero(String name){
        setNombre(name);
        setNivel(1);
        setCapacidad(5);
        initArray();
    }
}