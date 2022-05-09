package tarea.files;

public class Granjero extends Persona {
    

    public void mejorar(){
        setProductividad( getProductividad() + 2);
    }
    public int trabajo_realizado(){
        int temp = ((getProductividad()*2) + (getNivel()/2));
        return temp;
    }

    public Granjero(String x){
        setNombre(x);
        setEdad(15);
        setProductividad(8);
        setNivel(0);
    }
}