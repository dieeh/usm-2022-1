package tarea.files;

public class Cientifico extends Persona {


    public void mejorar(){
        setProductividad( getProductividad() + 1);
    }
    public int trabajo_realizado(){
        int temp = ((getProductividad()*3) + getNivel());
        return temp;
    }

    public Cientifico(String x){
        setNombre(x);
        setEdad(24);
        setProductividad(10);
        setNivel(0);
    }
}