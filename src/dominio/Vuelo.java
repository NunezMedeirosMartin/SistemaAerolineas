package dominio;

import tads.Lista;

public class Vuelo<T> {
    private String codigoVuelo;
    private String aerolinea;
    private String codAvion;
    private String paisDestino;
    private int dia;    
    private int mes;
    private int año;
    private int cantPasajesEcon;
    private int cantPasajesPClase;

    private Lista <T> listaTodosPasajes;
    private Lista <T> listaPasajesPClase;
    private Lista <T> listaPasajesClaseE;
    private Lista <T> listaPasajesEsperaPClase;
    private Lista <T> listaPasajesEsperaClaseE;
    private Lista <T> listaPasajesDevueltos;
    

    
   
    //constructor
   
    public Vuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
        this.codigoVuelo = codigoVuelo;
        this.aerolinea = aerolinea;
        this.codAvion = codAvion;
        this.paisDestino = paisDestino;
        this.dia = dia;
        this.mes = mes;
        this.año = año;
        this.cantPasajesEcon = cantPasajesEcon;
        this.cantPasajesPClase = cantPasajesPClase;
        this.listaTodosPasajes = new Lista<>();
        this.listaPasajesPClase = new Lista<>();   
        this.listaPasajesClaseE = new Lista<>();        
        this.listaPasajesEsperaPClase = new Lista<>();        
        this.listaPasajesEsperaClaseE = new Lista<>();
        this.listaPasajesDevueltos = new Lista<>();

        
        


    }
    
    //método para agregar un vuelo a un avion
    public void agregarPasajePClase(T pasaje){
        listaPasajesPClase.agregarFinal(pasaje);        

    }
    
     public void agregarPasajeClaseE(T pasaje){
        listaPasajesClaseE.agregar(pasaje);

    }
     
    public void agregarPasajeEsperaPClase(T pasaje){
        listaPasajesEsperaPClase.agregar(pasaje);

    }
      
    public void agregarPasajeEsperaClaseE(T pasaje){
        listaPasajesEsperaClaseE.agregar(pasaje);
    }
    

    
    //get set

    public String getCodigoVuelo() {
        return codigoVuelo;
    }

    public void setCodigoVuelo(String codigoVuelo) {
        this.codigoVuelo = codigoVuelo;
    }

    public String getAerolinea() {
        return aerolinea;
    }

    public void setAerolinea(String aerolinea) {
        this.aerolinea = aerolinea;
    }

    public String getCodAvion() {
        return codAvion;
    }

    public void setCodAvion(String codAvion) {
        this.codAvion = codAvion;
    }

    public String getPaisDestino() {
        return paisDestino;
    }

    public void setPaisDestino(String paisDestino) {
        this.paisDestino = paisDestino;
    }

    public int getDia() {
        return dia;
    }

    public void setDia(int dia) {
        this.dia = dia;
    }

    public int getMes() {
        return mes;
    }

    public void setMes(int mes) {
        this.mes = mes;
    }

    public int getAño() {
        return año;
    }

    public void setAño(int año) {
        this.año = año;
    }

    public int getCantPasajesEcon() {
        return cantPasajesEcon;
    }

    public void setCantPasajesEcon(int cantPasajesEcon) {
        this.cantPasajesEcon = cantPasajesEcon;
    }

    public int getCantPasajesPClase() {
        return cantPasajesPClase;
    }

    public void setCantPasajesPClase(int cantPasajesPClase) {
        this.cantPasajesPClase = cantPasajesPClase;
    }

    public Lista<T> getListaPasajesPClase() {
        return listaPasajesPClase;
    }

    public void setListaPasajesPClase(Lista<T> listaPasajesPClase) {
        this.listaPasajesPClase = listaPasajesPClase;
    }

    public Lista<T> getListaPasajesClaseE() {
        return listaPasajesClaseE;
    }

    public void setListaPasajesClaseE(Lista<T> listaPasajesClaseE) {
        this.listaPasajesClaseE = listaPasajesClaseE;
    }

    public Lista<T> getListaPasajesEsperaPClase() {
        return listaPasajesEsperaPClase;
    }

    public void setListaPasajesEsperaPClase(Lista<T> listaPasajesEsperaPClase) {
        this.listaPasajesEsperaPClase = listaPasajesEsperaPClase;
    }

    public Lista<T> getListaPasajesEsperaClaseE() {
        return listaPasajesEsperaClaseE;
    }

    public void setListaPasajesEsperaClaseE(Lista<T> listaPasajesEsperaClaseE) {
        this.listaPasajesEsperaClaseE = listaPasajesEsperaClaseE;
    }

    public Lista<T> getListaTodosPasajes() {
        return listaTodosPasajes;
    }

    public void setListaTodosPasajes(Lista<T> listaTodosPasajes) {
        this.listaTodosPasajes = listaTodosPasajes;
    }

    public Lista<T> getListaPasajesDevueltos() {
        return listaPasajesDevueltos;
    }

    public void setListaPasajesDevueltos(Lista<T> listaPasajesDevueltos) {
        this.listaPasajesDevueltos = listaPasajesDevueltos;
    }
    
    
    
    //toString
    public String toString() {
    int vendidosEcon = 0;
    int vendidosPClase = 0;
    int disponiblesEcon = cantPasajesEcon - vendidosEcon;
    int disponiblesPClase = cantPasajesPClase - vendidosPClase;
    int totalDisponibles = disponiblesEcon + disponiblesPClase;
    
    if(!listaPasajesClaseE.esVacia()){
        vendidosEcon = listaPasajesClaseE.tamaño();
    }
    if(!listaPasajesPClase.esVacia()){
        vendidosPClase = listaPasajesPClase.tamaño();
    }

    return codigoVuelo + "-" + aerolinea + "-" + codAvion + "-" +
           vendidosEcon + "-" + vendidosPClase + "-" +
           totalDisponibles;
    }
    
   
}



