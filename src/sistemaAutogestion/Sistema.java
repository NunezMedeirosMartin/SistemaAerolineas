package sistemaAutogestion;

import dominio.*;
import java.util.Date;
import tads.Lista;
import tads.Nodo;

public class Sistema implements IObligatorio {

    private Lista<Aerolinea> listaAerolineas;
    private Lista<Avion> listaAviones;    
    private Lista<Vuelo> listaVuelos;   
    private Lista<Pasaje> listaTodosPasajes; 
    private Lista<Pasaje> listaPasajesPClase; 
    private Lista<Pasaje> listaPasajesClaseE;    
    private Lista<Pasaje> listaPasajesEsperaPClase;    
    private Lista<Pasaje> listaPasajesEsperaClaseE;
    private Lista<Cliente> listaClientes;
    private Lista<Vuelo> listaVuelosClientes;    
    private Lista<Pasaje> listaPasajesDevueltos;
    private Lista<Pasaje> listaPasajesDevueltosAerolinea;

    //metodos creacion de siestema
    public Sistema(){
        listaAerolineas = new Lista();
        listaAviones = new Lista();        
        listaVuelos = new Lista();
        listaTodosPasajes = new Lista();
        listaPasajesPClase = new Lista();
        listaPasajesClaseE = new Lista();
        listaPasajesEsperaPClase = new Lista();
        listaPasajesEsperaClaseE = new Lista();      
        listaClientes = new Lista();
        listaVuelosClientes = new Lista();
        listaPasajesDevueltos  = new Lista();
        listaPasajesDevueltosAerolinea = new Lista();
    }
    
    @Override
    public Retorno crearSistemaDeGestion() {
        
        listaAerolineas = new Lista();
        listaAviones = new Lista();        
        listaVuelos = new Lista();
        listaTodosPasajes = new Lista();
        listaPasajesPClase = new Lista();
        listaPasajesClaseE = new Lista();
        listaPasajesEsperaPClase = new Lista();
        listaPasajesEsperaClaseE = new Lista();
        listaClientes = new Lista();
        listaVuelosClientes = new Lista();
        listaPasajesDevueltos  = new Lista();
        listaPasajesDevueltosAerolinea = new Lista();

       
        return Retorno.ok();
    }

    //metodos de crear y eliminar aerolinea
    @Override
    public Retorno crearAerolinea(String nombre, String pais, int cantMaxAviones) {
    
        boolean cantMaxCorrecta = cantMaxAviones > 0;
        boolean tieneNombreUnico = true;

        if (cantMaxCorrecta) {
            Nodo<Aerolinea> actual = listaAerolineas.getCabeza();

            while (actual != null) {
                if (actual.getDato().getNombre().equalsIgnoreCase(nombre)) {
                    tieneNombreUnico = false;
                    break;
                }
                actual = actual.getSiguiente();
            }
        }

        if (tieneNombreUnico) {
            if (cantMaxCorrecta) {
                Aerolinea a = new Aerolinea(nombre, pais, cantMaxAviones);
                listaAerolineas.agregar(a);
                return Retorno.ok();
            } else {
                return Retorno.error2();
            }
        } else {
            return Retorno.error1();
        }
    }

    @Override
    public Retorno eliminarAerolinea(String nombre) {
       
        Nodo<Aerolinea> actual = listaAerolineas.getCabeza();

        while (actual != null && !actual.getDato().getNombre().equals(nombre)) {
            actual = actual.getSiguiente();
        }
        if (actual != null) {
            if(actual.getDato().getListaAviones().esVacia()){ 
                listaAerolineas.borrarElemento(actual.getDato());
                return Retorno.ok();
            } else {
                return Retorno.error2();
            }
        } else{
           return Retorno.error1();
        }
    }

    
    //metodos de registrar y eliminar avion
    @Override
    public Retorno registrarAvion(String codigo, int capacidadMax, String nomAerolinea) {
        
        boolean existeAerolinea = false;   
        boolean capacidad = capacidadMax > 8 && capacidadMax % 3 == 0;
                    
        Nodo<Aerolinea> aerolineaActual = listaAerolineas.getCabeza();

        while(aerolineaActual != null && !existeAerolinea){ 
            if(aerolineaActual.getDato().getNombre().equalsIgnoreCase(nomAerolinea)){
                existeAerolinea = true;  
            }else {
                aerolineaActual = aerolineaActual.getSiguiente();
            }
        }
        if(existeAerolinea){
            Lista<Avion> avionesAerolinea =  aerolineaActual.getDato().getListaAviones();
            if(!avionesAerolinea.esVacia()){
                int contadorAviones = avionesAerolinea.cantElementos();
                int cantMaxAviones = aerolineaActual.getDato().getCantMaxAviones();
                if(contadorAviones >= cantMaxAviones){
                    return Retorno.error4();
                } 
                Nodo<Avion> avionActual = avionesAerolinea.getCabeza();
                while(avionActual != null && !avionActual.getDato().getCodigo().equals(codigo)){
                    avionActual = avionActual.getSiguiente();
                }
                if(avionActual != null){
                    return Retorno.error1();
                }
            }             
            if (capacidad) {
                Avion nuevoAvion = new Avion<>(codigo, capacidadMax, nomAerolinea);
                avionesAerolinea.agragarInicio(nuevoAvion);
                return Retorno.ok();  
            } else {
                return Retorno.error2(); 
            }
        } 
        return Retorno.error3();
    }

    @Override
    public Retorno eliminarAvion(String nomAerolinea, String codAvion) {
        
        boolean existeAerolinea = false;  
        
        Nodo<Aerolinea> aerolineaActual = listaAerolineas.getCabeza();

        while(aerolineaActual != null && !existeAerolinea){ 
            if(aerolineaActual.getDato().getNombre().equalsIgnoreCase(nomAerolinea)){
                existeAerolinea = true;  
            }else {
                aerolineaActual = aerolineaActual.getSiguiente();
            }
        }
        
        boolean tienePasajes = false;
        Vuelo vuelo = null;
        Nodo<Vuelo> vueloActual = listaVuelos.getCabeza();
        while(vueloActual != null && !tienePasajes){
            if(vueloActual.getDato().getCodAvion().equals(codAvion)){
                vuelo = vueloActual.getDato();
                if(!vuelo.getListaPasajesClaseE().esVacia() || !vuelo.getListaPasajesPClase().esVacia()){
                    tienePasajes = true;
                }              
            } else {
                vueloActual= vueloActual.getSiguiente();
            }
        }
        
        if(tienePasajes){
            return Retorno.error3();

        }
        
        if(existeAerolinea){
            Lista<Avion> avionesAerolinea =  aerolineaActual.getDato().getListaAviones();
            if(!avionesAerolinea.esVacia()){
                Nodo<Avion> avionActual = avionesAerolinea.getCabeza();
                while(avionActual != null && !avionActual.getDato().getCodigo().equals(codAvion)){
                    avionActual = avionActual.getSiguiente();
                              
                }
                if(avionActual == null){
                    return Retorno.error2();
                }
            }
        }
     
        if(aerolineaActual == null && !existeAerolinea){
            return Retorno.error1(); 
        }  
        
        return Retorno.ok(); 
    }

    
    //metodo de registrar cliente
    @Override
    public Retorno registrarCliente(String pasaporte, String nombre, int edad) {

        if (edad <= 0) {
            return Retorno.error1();
        }
    
        Nodo<Cliente> clienteActual = listaClientes.getCabeza();
        while (clienteActual != null) {
            if (clienteActual.getDato().getPasaporte().equalsIgnoreCase(pasaporte)) {
                return Retorno.error3(); 
            }
            clienteActual = clienteActual.getSiguiente();
        }

        if (pasaporte.length() != 7) {
            return Retorno.error2(); 
        }

        Cliente nuevoCliente = new Cliente(pasaporte, nombre, edad);
        listaClientes.agragarInicio(nuevoCliente);

        return Retorno.ok();
        
    }

    
    //metodo de cerar un vuelo
    @Override
    public Retorno crearVuelo(String codigoVuelo, String aerolinea, String codAvion, String paisDestino, int dia, int mes, int año, int cantPasajesEcon, int cantPasajesPClase) {
       
        boolean existeAerolinea = false;   
        boolean existeAvion = false;  
        int capacidadAvion = 0;
        
        Nodo<Vuelo> vueloActual = listaVuelos.getCabeza();
        while (vueloActual != null) {
            if (vueloActual.getDato().getCodigoVuelo().equalsIgnoreCase(codigoVuelo)) {
                return Retorno.error1(); 
            }
            if(vueloActual.getDato().getCodAvion().equals(codAvion)){
                if(vueloActual.getDato().getAño() == año && vueloActual.getDato().getMes() == mes && vueloActual.getDato().getDia() == dia){
                   return Retorno.error4(); 
                }               
            }
            vueloActual = vueloActual.getSiguiente();
        } 

        Nodo<Aerolinea> aerolineaActual = listaAerolineas.getCabeza();
        while(aerolineaActual != null && !existeAerolinea){ 
            if(aerolineaActual.getDato().getNombre().equalsIgnoreCase(aerolinea)){
                existeAerolinea = true;  
                Nodo<Avion> avionActualA = aerolineaActual.getDato().getListaAviones().getCabeza();
                while(avionActualA != null && !existeAvion){
                    if(avionActualA.getDato().getCodigo().equals(codAvion)){
                      existeAvion = true;  
                      capacidadAvion = avionActualA.getDato().getCapacidadMax();
                      
                    }
                    avionActualA = avionActualA.getSiguiente();
                }                        
            }
            aerolineaActual = aerolineaActual.getSiguiente();
        }
        
        if(!existeAerolinea){
            return Retorno.error2(); 
        } else if(!existeAvion){
            return Retorno.error3(); 
        } 
           
        if(cantPasajesEcon % 3 != 0 || cantPasajesPClase % 3 != 0){
            return Retorno.error5(); 
        } 
        
        if((cantPasajesEcon + cantPasajesPClase) > capacidadAvion){
            return Retorno.error6(); 

        }

        Vuelo nuevoVuelo = new Vuelo(codigoVuelo, aerolinea, codAvion, paisDestino, dia, mes, año, cantPasajesEcon, cantPasajesPClase);
        listaVuelos.agregarFinal(nuevoVuelo);

        return Retorno.ok();
    }
    
    
    //metodos de comprar y devolver pasajes
    @Override
    public Retorno comprarPasaje(String pasaporteCliente, String codigoVuelo, int categoríaPasaje) {
        
        boolean existePasaporte = false;
        boolean existeVuelo = false;
        int capacidadClaseE = 0;
        int capacidadPClase = 0;
        Vuelo vueloEncontrado = null;
        
        Nodo<Cliente> clienteActual = listaClientes.getCabeza();
        while(clienteActual != null && !existePasaporte){
            if(clienteActual.getDato().getPasaporte().equals(pasaporteCliente)){
                existePasaporte = true; 
            }
            clienteActual = clienteActual.getSiguiente();
        }
        
        if(!existePasaporte){
            return Retorno.error1();   
        }
        
        Nodo<Vuelo> vueloActual = listaVuelos.getCabeza();
        while(vueloActual != null && !existeVuelo){
            if(vueloActual.getDato().getCodigoVuelo().equals(codigoVuelo)){
                existeVuelo = true; 
                vueloEncontrado = vueloActual.getDato();
                capacidadClaseE = vueloEncontrado.getCantPasajesEcon();                
                capacidadPClase = vueloEncontrado.getCantPasajesPClase();
            }          
            vueloActual = vueloActual.getSiguiente();
        }
        if(!existeVuelo){
            return Retorno.error2();   
        }
        
        Pasaje nuevoPasaje = new Pasaje(pasaporteCliente, codigoVuelo, categoríaPasaje);
        
        if(categoríaPasaje == 1){
             if(listaPasajesClaseE.esVacia() || capacidadClaseE -1 > listaPasajesClaseE.tamaño()){
               vueloEncontrado.getListaPasajesClaseE().agregarFinal(nuevoPasaje);
               vueloEncontrado.getListaTodosPasajes().agragarInicio(nuevoPasaje);
               listaTodosPasajes.agragarInicio(nuevoPasaje);
               return Retorno.ok();      
             } else{
               vueloEncontrado.getListaTodosPasajes().agragarInicio(nuevoPasaje);
               vueloEncontrado.getListaPasajesEsperaClaseE().agregarFinal(nuevoPasaje);    
               listaTodosPasajes.agragarInicio(nuevoPasaje);
               return Retorno.ok();      
             }
             
        } else {
            if(listaPasajesPClase.esVacia() || capacidadPClase -1 > listaPasajesPClase.tamaño()){
               vueloEncontrado.getListaPasajesPClase().agregarFinal(nuevoPasaje);
               vueloEncontrado.getListaTodosPasajes().agragarInicio(nuevoPasaje);
               listaTodosPasajes.agragarInicio(nuevoPasaje);
               return Retorno.ok();      
            } else{
               vueloEncontrado.getListaPasajesEsperaPClase().agregarFinal(nuevoPasaje);
               vueloEncontrado.getListaTodosPasajes().agragarInicio(nuevoPasaje);
               listaTodosPasajes.agragarInicio(nuevoPasaje);
               return Retorno.ok();      
            }
        }             
        
    }
    
    @Override
public Retorno devolverPasaje(String pasaporteCliente, String codigoVuelo) {

    boolean clienteExiste = false;
    
    Nodo<Cliente> clienteActual = listaClientes.getCabeza();
        while(clienteActual != null && !clienteExiste){
            if(clienteActual.getDato().getPasaporte().equals(pasaporteCliente)){
                clienteExiste = true; 
            }   else {
                clienteActual = clienteActual.getSiguiente();
            }       
            
        }
    
    if(!clienteExiste){
        return Retorno.error1();   
    }

    boolean existeVuelo = false;
    Vuelo esteVuelo = null;
    
    Nodo<Vuelo> vueloActual = listaVuelos.getCabeza();
        while(vueloActual != null && !existeVuelo){
            if(vueloActual.getDato().getCodigoVuelo().equals(codigoVuelo)){
                existeVuelo = true; 
                esteVuelo = vueloActual.getDato();
            }  else {
                vueloActual = vueloActual.getSiguiente();
            }
        }
        
    if(!existeVuelo){
        return Retorno.error2();   
    }

    boolean pasajeEncontrado = false;
    Pasaje pasajeDevuelto = null;
    String estaAerolinea = null;
    
    Nodo<Pasaje> pasajeActualClaseE = esteVuelo.getListaPasajesClaseE().getCabeza();
        while(pasajeActualClaseE != null && !pasajeEncontrado){
            if(pasajeActualClaseE.getDato().getPasaporteCliente().equals(pasaporteCliente)){
                pasajeEncontrado = true;    
                pasajeDevuelto = pasajeActualClaseE.getDato();
                estaAerolinea = esteVuelo.getAerolinea();

                esteVuelo.getListaPasajesDevueltos().agregarFinal(pasajeDevuelto);
                listaPasajesDevueltos.agregarFinal(pasajeDevuelto);

                Nodo<Pasaje> estePasaje1 = listaPasajesEsperaClaseE.getCabeza();
                if(estePasaje1 != null){
                    pasajeActualClaseE.setDato(estePasaje1.getDato()); 
                    return Retorno.ok();
                } else {
 
                    if(pasajeActualClaseE.getSiguiente() != null){
                      pasajeActualClaseE.setDato(pasajeActualClaseE.getSiguiente().getDato()); 
                      return Retorno.ok();  
                    }
                    pasajeActualClaseE.setDato(null); 
                    return Retorno.ok();
                }
            }          
            pasajeActualClaseE = pasajeActualClaseE.getSiguiente();
        }
        
    Nodo<Pasaje> pasajeActualPClase = esteVuelo.getListaPasajesPClase().getCabeza();
        while(pasajeActualPClase != null && !pasajeEncontrado){
            if(pasajeActualPClase.getDato().getPasaporteCliente().equals(pasaporteCliente)){
                pasajeEncontrado = true; 
                pasajeDevuelto = pasajeActualPClase.getDato();
                esteVuelo.getListaPasajesDevueltos().agregarFinal(pasajeDevuelto);
                listaPasajesDevueltos.agregarFinal(pasajeDevuelto);

                Nodo<Pasaje> estePasaje2 = esteVuelo.getListaPasajesEsperaPClase().getCabeza();
                if(estePasaje2 != null){
                    pasajeActualPClase.setDato(estePasaje2.getDato()); 
                    return Retorno.ok();
                } else {
                    if(pasajeActualPClase.getSiguiente() != null){
                      pasajeActualPClase.setDato(pasajeActualPClase.getSiguiente().getDato()); 
                      return Retorno.ok();  
                    }
                    pasajeActualPClase.setDato(null); 
                    return Retorno.ok();  
                    
                }
            }          
            pasajeActualPClase = pasajeActualPClase.getSiguiente();
        }
    return Retorno.error3();       
}
   
    
    @Override
    public Retorno listarAerolineas() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
     
        String listarAerolineas = listaAerolineas.mostrar();
        r.valorString = listarAerolineas;
        
        return r;
    }
   
    
    @Override
    public Retorno listarAvionesDeAerolinea(String nombre) {
        
        Retorno r = new Retorno(Retorno.Resultado.OK);
        
       
        boolean existeAerolinea = false;   
               
        Nodo<Aerolinea> aerolineaActual = listaAerolineas.getCabeza();

        while(aerolineaActual != null && !existeAerolinea){ 
            if(aerolineaActual.getDato().getNombre().equalsIgnoreCase(nombre)){
                existeAerolinea = true;  
            }else {
                aerolineaActual = aerolineaActual.getSiguiente();
            }
        }
         if(existeAerolinea){
             Lista<Avion> avionesAerolinea =  aerolineaActual.getDato().getListaAviones();
             r.valorString = avionesAerolinea.mostrar();
             return r;

        }
       return Retorno.error1();

    }

    @Override
    public Retorno listarClientes() {
        Retorno r = new Retorno(Retorno.Resultado.OK);
     
        String listarClientes = listaClientes.mostrarRecursivo(this.listaClientes.getCabeza());
        r.valorString = listarClientes;
        
        return r;
    }

   @Override
public Retorno listarVuelos() {
    Retorno r = new Retorno(Retorno.Resultado.OK);
    String listarVuelos = listaVuelos.mostrarElementos();
    r.valorString = listarVuelos;
    return r;    
}

//Para esta funcion recurrimos a herremientas tales como la de StringBuilder y append.
//Ya que operamos bastante con la concatenacion, decidimos hacerlo con StringBuilder.
//Y como usamos el StringBuilder también tuvmios que usar el append para poder agregar el texto.
@Override
public Retorno vuelosDeCliente(String pasaporte) {
    Retorno r = new Retorno(Retorno.Resultado.OK);
    StringBuilder vuelosCliente = new StringBuilder();

    Nodo<Cliente> clienteActual = listaClientes.getCabeza();
    boolean existeCliente = false;

    while (clienteActual != null) {
        if (clienteActual.getDato().getPasaporte().equalsIgnoreCase(pasaporte)) {
            existeCliente = true;
            break;
        }
        clienteActual = clienteActual.getSiguiente();
    }

    if (!existeCliente) {
        return Retorno.error1(); 
    }

    Nodo<Pasaje> pasajeActual = listaTodosPasajes.getCabeza();
    StringBuilder pasajesOrdenados = new StringBuilder();

    while (pasajeActual != null) {
        Pasaje pasaje = pasajeActual.getDato();
        if (pasaje.getPasaporteCliente().equalsIgnoreCase(pasaporte)) {
            String estado = "";
            if (pasaje.getCategoríaPasaje() == 1 || pasaje.getCategoríaPasaje() == 2) {
                estado = "CPR|";
            }
            pasajesOrdenados.append(pasaje.getCodigoVuelo()).append("-").append(estado).append("\n");
        }
        pasajeActual = pasajeActual.getSiguiente();
    }

    vuelosCliente.append(pasajesOrdenados);

    
    
    Nodo<Pasaje> pasajeActualD = listaPasajesDevueltos.getCabeza();
    while (pasajeActualD != null) {
        if (pasajeActualD.getDato().getPasaporteCliente().equalsIgnoreCase(pasaporte)) {
            vuelosCliente.append(pasajeActualD.getDato().getCodigoVuelo()).append("-DEV|\n");
        }
        pasajeActualD = pasajeActualD.getSiguiente();
    }

    r.valorString = vuelosCliente.toString().trim(); 
    return r;
}


    @Override
    public Retorno pasajesDevueltos(String nombreAerolinea) {

        Retorno r = new Retorno(Retorno.Resultado.OK);
        
        boolean existeAerolinea = false;   
        Aerolinea aerolineaEncontrada = null;        
        Lista<Pasaje> listaPasajesDevueltosAerolinea = null; 
        
        Nodo<Aerolinea> aerolineaActual = listaAerolineas.getCabeza();

        while(aerolineaActual != null && !existeAerolinea){ 
            if(aerolineaActual.getDato().getNombre().equalsIgnoreCase(nombreAerolinea)){
                existeAerolinea = true;  
                aerolineaEncontrada = aerolineaActual.getDato();
            }else {
                aerolineaActual = aerolineaActual.getSiguiente();
            }
        }   

        if(!existeAerolinea){
            return Retorno.error1();
        } 
        
        Lista<Pasaje> listaPasajesDevueltosVuelo = null; 
        
        Nodo<Vuelo> vueloActual = listaVuelos.getCabeza() ;

        while(vueloActual != null){ 
            if(vueloActual.getDato().getAerolinea() == nombreAerolinea) {
               listaPasajesDevueltosVuelo = vueloActual.getDato().getListaPasajesDevueltos();
               Nodo<Pasaje> pasajeActual = listaPasajesDevueltosVuelo.getCabeza();
               while(pasajeActual != null){
                   aerolineaEncontrada.getListaPasajesDevueltosAerolinea().agregarFinal(pasajeActual.getDato());  
                   pasajeActual = pasajeActual.getSiguiente();
               }
    
            }
            vueloActual = vueloActual.getSiguiente();
        }   
        
        
            String listarPasajesDevueltos = aerolineaEncontrada.getListaPasajesDevueltosAerolinea().mostrarElementos();
            r.valorString = listarPasajesDevueltos;
 
            return r;
    }



    @Override
    public Retorno vistaDeVuelo(String codigoVuelo) {

        Retorno r = new Retorno(Retorno.Resultado.OK);

        Vuelo vuelo = null;

        boolean vueloEncontrado = false;
        Nodo<Vuelo> vueloActual = listaVuelos.getCabeza();
        while(vueloActual != null && !vueloEncontrado){
            if(vueloActual.getDato().getCodigoVuelo().equals(codigoVuelo)){
                vueloEncontrado = true;
                vuelo = vueloActual.getDato();
            }else{
                vueloActual = vueloActual.getSiguiente();
            }        
        }

        Lista<Pasaje> pasajesPClase = vuelo.getListaPasajesPClase();
        Lista<Pasaje> pasajesClaseE = vuelo.getListaPasajesClaseE();

        StringBuilder resultado = new StringBuilder();
        resultado.append("************\n");
        resultado.append("* PRIMERA *\n");
        resultado.append("************\n");
        resultado.append(crearVista(pasajesPClase, vuelo.getCantPasajesPClase())); 
        resultado.append("* ECONÓMICA *\n");
        resultado.append("************\n");
        resultado.append(crearVista(pasajesClaseE, vuelo.getCantPasajesEcon())); 

        r.valorString = resultado.toString();
        return r;
    }


    	private String crearVista(Lista<Pasaje> pasajes, int cantLugares) {
        
        Nodo<Pasaje> pasajeActual = pasajes.getCabeza();

        int filas = (int) Math.ceil((double) cantLugares / 3);
        int lugar = 0;

        StringBuilder vista = new StringBuilder();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < 3; j++) {
                if (cantLugares > lugar) {
                    if (pasajeActual != null) {
                        vista.append(" * ").append(pasajeActual.getDato().getPasaporteCliente()).append(" * ");
                        pasajeActual = pasajeActual.getSiguiente();
                    } else {
                        vista.append(" * XXXXXXXX * ");
                    }
                    lugar++;
                } else {
                    vista.append(" * XXXXXXXX * ");
                }
            }
            vista.append("\n************\n");
        }

        return vista.toString();
    }
  

}
