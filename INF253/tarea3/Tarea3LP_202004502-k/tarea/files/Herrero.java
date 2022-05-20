package tarea.files;

public class Herrero extends Persona {

    public void mejorar(){
        setProductividad( getProductividad() + 3);
    }

    public Integer trabajo_realizado(){
        Integer temp = (getProductividad() + (getNivel() * 2));
        return temp;
    }

    public Herrero(String x){
        setNombre(x);
        setEdad(18);
        setProductividad(9);
        setNivel(0);
    }
}