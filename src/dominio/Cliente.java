package dominio;

import tads.Lista;

public class Cliente<T> {
    private String pasaporte;
    private String nombre; 
    private int edad;
    
    private Lista <T> listaVuelosCliente;    
    private Lista <T> listaVuelos;

    
         
    //constructor
    public Cliente(String pasaporte, String nombre, int edad) {
        this.pasaporte = pasaporte;
        this.nombre = nombre;
        this.edad = edad;
        this.listaVuelosCliente = new Lista<>();              
        this.listaVuelos = new Lista<>();        
  

    }
    
    
    //get set
    public String getPasaporte() {
        return pasaporte;
    }

    public void setPasaporte(String pasaporte) {
        this.pasaporte = pasaporte;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public Lista<T> getListaVuelosCliente() {
        return listaVuelosCliente;
    }

    public void setListaVuelosCliente(Lista<T> listaVuelosCliente) {
        this.listaVuelosCliente = listaVuelosCliente;
    }
    
    
    //toString
    public String toString(){
        return   pasaporte + "-" + nombre + "-" + edad + "|\n";
    }
}
