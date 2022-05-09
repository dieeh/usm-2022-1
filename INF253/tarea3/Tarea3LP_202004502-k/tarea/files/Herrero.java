package tarea.files;

public class Herrero extends Persona {


    public void mejorar(){
        setProductividad( getProductividad() + 3);
    }

    public int trabajo_realizado(){
        int temp = (getProductividad() + (getNivel() * 2));
    }

    public Herrero(String x){
        setNombre(x);
        setEdad(18);
        setProductividad(9);
        setNivel(0);
    }
}