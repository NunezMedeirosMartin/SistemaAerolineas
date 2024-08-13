package dominio;

import tads.Lista;

public class Aerolinea<T> {
    private String nombre;
    private String pais;
    private int cantMaxAviones;
    
    private Lista <T> listaAviones;
    private Lista <T> listaPasajesDevueltosAerolinea;
    
    
   //constructor 
    public Aerolinea(String nombre, String pais, int cantMaxAviones) {
        this.nombre = nombre;
        this.pais = pais;
        this.cantMaxAviones = cantMaxAviones;
        this.listaAviones = new Lista<>();        
        this.listaPasajesDevueltosAerolinea = new Lista<>();

    }
    
    
    //método para agregar un avion a una aerolinea
    public void agregarAvion(T avion){
        listaAviones.agregar(avion);
    }
    
    public void agregarPasaje(T pasaje){
        listaPasajesDevueltosAerolinea.agregar(pasaje);
    }
    public String getNombre(){
        return   nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public int getCantMaxAviones() {
        return cantMaxAviones;
    }

    public void setCantMaxAviones(int cantMaxAviones) {
        this.cantMaxAviones = cantMaxAviones;
    }

    public Lista<T> getListaAviones() {
        return listaAviones;
    }

    public void setListaAviones(Lista<T> listaAviones) {
        this.listaAviones = listaAviones;
    }

    public Lista<T> getListaPasajesDevueltosAerolinea() {
        return listaPasajesDevueltosAerolinea;
    }

    //get set
    public void setListaPasajesDevuelosAerolinea(Lista<T> listaPasajesDevueltosAerolinea) {
        this.listaPasajesDevueltosAerolinea = listaPasajesDevueltosAerolinea;
    }

    //toString
    public String toString() {
        return   nombre + "-" + pais + "-" + cantMaxAviones + "\n";
    }
    

    
    
}
