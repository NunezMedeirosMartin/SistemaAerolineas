package dominio;

import tads.Lista;
        
public class Avion<T> {
    private String codigo;    
    private int capacidadMax;
    private String nomAerolinea;
    private Lista <T> listaVuelos;

    
    //constructor
    public Avion(String codigo, int capacidadMax, String nomAerolinea) {
        this.codigo = codigo;
        this.capacidadMax = capacidadMax;
        this.nomAerolinea = nomAerolinea;
    }
    
    
    //método para agregar un vuelo a un avion
    public void agregarVuelo(T vuelo){
        listaVuelos.agregar(vuelo);
    }
     
     
    //get set
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public int getCapacidadMax() {
        return capacidadMax;
    }

    public void setCapacidadMax(int capacidadMax) {
        this.capacidadMax = capacidadMax;
    }

    public String getNomAerolinea() {
        return nomAerolinea;
    }

    public void setNomAerolinea(String nomAerolinea) {
        this.nomAerolinea = nomAerolinea;
    }

    public Lista<T> getListaVuelos() {
        return listaVuelos;
    }

    public void setListaVuelos(Lista<T> listaVuelos) {
        this.listaVuelos = listaVuelos;
    }
    
    
    //toString
    public String toString(){
        return codigo + "-"+capacidadMax +"|\n";
    }
    

    
    
    
    
}
