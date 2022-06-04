package tarea.files;

import java.util.ArrayList;

public class Laboratorio extends Edificio {

    public void mejorar(){
        setNivel( getNivel() + 1);
        setCapacidad(getCapacidad() + 2);
    }
    
    public ArrayList<Integer> producir(){
        ArrayList<Persona> temp = getPersonas();
        Integer contador1 = 0; //cientificos
        Integer contador2 = 0; //no cientificos
        for (int i = 0; i < temp.size(); i++) {
            if (temp.get(i) instanceof Cientifico) {
                contador1 += 1;
            }else{
                contador2 +=1;
            }
        }
        boolean flag = false;
        if (contador1 > 0.75*(contador1+contador2)){
            flag = true;
        }
        ArrayList<Integer> tempor = new ArrayList<Integer>(4);
        if (flag == true){
            Integer suma = 0;
            for (int i = 0; i < temp.size(); i++) {
                if (temp.get(i) instanceof Cientifico) {
                    suma += temp.get(i).trabajo_realizado();
                }
            }
            tempor.add(  (suma/ (temp.size()/contador2))  );
            tempor.add(0);
            tempor.add(0);
            tempor.add(suma);
        }else{
            tempor.add(-4 * temp.size());
            tempor.add(0);
            tempor.add(0);
            tempor.add(0);
        }
        return tempor;
    }

    public Laboratorio(String nombre){
        setNombre(nombre);
        setNivel(1);
        setCapacidad(5);
        initArray();
    }
}