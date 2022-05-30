package tarea.files;

import java.util.ArrayList;

public class Herreria extends Edificio {
    
    public void mejorar(){
        setNivel( getNivel() + 1);
        setCapacidad(getCapacidad() + 4);
    }
    
    public ArrayList<Integer> producir(){
        ArrayList<Persona> temp = getPersonas();
        Integer contador1 = 0; //cientificos
        Integer contador2 = 0; //no herreros
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getClass().getName().equals("Cientifico")) {
                contador1 += 1;
            }
            if (!(temp.get(i).getClass().getName().equals("Herrero"))){
                contador2 +=1;
            }
        }
        ArrayList<Integer> tempor = new ArrayList<Integer>(4);
        Integer sum1 = 0, sum2 = 0;
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i).getClass().getName().equals("Herrero")) {
                sum1 += temp.get(i).trabajo_realizado();
            }
            if (temp.get(i).getClass().getName().equals("Cientifico")) {
                sum2 += (temp.get(i).trabajo_realizado() * (1/3));
            }
        }
        tempor.add(sum1 / temp.size());  //javalares
        tempor.add(sum1 / contador2);  //hierro
        tempor.add(0);   //trigo
        tempor.add(sum2 / contador1);  //tecnologia
        return tempor;
    }

    public Herreria(String name){
        setNombre(name);
        setNivel(1);
        setCapacidad(8);
        initArray();
    }
}