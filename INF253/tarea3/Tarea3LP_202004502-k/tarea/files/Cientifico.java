package tarea.files;

public class Cientifico extends Persona {

    
    public void mejorar(){
        setNivel( getNivel() + 1);
        setProductividad( getProductividad() + 1);
    }
    public Integer trabajo_realizado(){
        Integer temp = ((getProductividad()*3) + getNivel());
        return temp;
    }

    public Cientifico(String x){
        setNombre(x);
        setEdad(24);
        setProductividad(10);
        setNivel(1);
    }
}