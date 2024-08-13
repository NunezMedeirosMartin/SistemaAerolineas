package sistemaAutogestion;


public interface IObligatorio {
    
    /*
    **************** REGISTROS **************************************
    */
    
    public Retorno crearSistemaDeGestion();
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones); 
    public Retorno eliminarAerolinea(String nombre);
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea); 
    public Retorno eliminarAvion(String nomAerolinea, String codAvion); 
    public Retorno registrarCliente(String pasaporte, String nombre, int edad);
    
    
    /*
    **************** GESTIÓN DE VUELOS Y PASAJES **************************************
    */
    
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase);
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje);
    public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo);

    
    /*
    **************** REPORTES Y CONSULTAS **************************************
    */
    
    public Retorno listarAerolineas();
    public Retorno listarAvionesDeAerolinea(String nombre);
    public Retorno listarClientes();
    public Retorno listarVuelos();
    public Retorno vuelosDeCliente(String pasaporte);
    public Retorno pasajesDevueltos(String nombreAerolinea);
    public Retorno vistaDeVuelo(String codigoVuelo);
    
}
