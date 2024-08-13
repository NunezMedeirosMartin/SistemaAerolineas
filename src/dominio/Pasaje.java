package dominio;

import tads.Lista;

public class Pasaje {
    private String pasaporteCliente; 
    private String codigoVuelo; 
    private int categoríaPasaje;
   
    
    //constructor
    public Pasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        this.pasaporteCliente = pasaporteCliente;
        this.codigoVuelo = codigoVuelo;
        this.categoríaPasaje = categoríaPasaje;
    }

    //get set

    public String getPasaporteCliente() {
        return pasaporteCliente;
    }

    public void setPasaporteCliente(String pasaporteCliente) {
        this.pasaporteCliente = pasaporteCliente;
    }

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public int getCategoríaPasaje() {
        return categoríaPasaje;
    }

    public void setCategoríaPasaje(int categoríaPasaje) {
        this.categoríaPasaje = categoríaPasaje;
    }
    
    
    //toString
    public String toString(){
        return   pasaporteCliente  + "-" +  codigoVuelo ;
    }
    
    

}
