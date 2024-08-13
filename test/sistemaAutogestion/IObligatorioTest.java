package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class IObligatorioTest {

    private Sistema miSistema;
    
    @Before
    public void setUp() {
        miSistema = new Sistema();
        miSistema.crearSistemaDeGestion();
    }
    
    // crear sistema de gestion
    
    @Test
    public void testCrearSistemaDeGestion() {
        // crear sistema de gestion
        Retorno r = miSistema.crearSistemaDeGestion();
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    
    // crear aerolinea

    @Test
    public void testCrearAerolineaOK() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Uruguay", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Gol", "Brasil", 5);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR1() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR2() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Air X", "Francia", 0);
        assertEquals(Retorno.error2().resultado, r.resultado );
    }

    // eliminar aerolinea
    
    @Test
    public void testEliminarAerolineaOK() {
        // crear aerolinea        
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar aerolinea
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR1() {
        // crear aerolinea        
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar aerolinea
        r = miSistema.eliminarAerolinea("TAP Portugal");
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("ORT Airlines");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Pluna", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar aerolinea
        r = miSistema.eliminarAerolinea("Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Pluna");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    // registrar avion
    
    @Test
    public void testRegistrarAvionOK() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR1() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA700", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 18, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR2() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 3, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 14, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("Vuelo", 10, "Pluna");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR3() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 12, "Porter Airlines");
        assertEquals(Retorno.error3().resultado, r.resultado); 
    }
    
    @Test
    public void testRegistrarAvionERROR4() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA346", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA347", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.error4().resultado, r.resultado);        
    }
    
    // eliminar avion

    @Test
    public void testEliminarAvionOK() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar avion
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR1() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar avion
        r = miSistema.eliminarAvion("Gol Brasil", "AA345");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR2() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar avion
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "YY111");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }
    
    @Test
    public void testEliminarAvionERROR3() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA346", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "AA346", "Uruguay", 11, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //registrar cliente
        r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //comprar pasaje
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // eliminar avion
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA346");
        assertEquals(Retorno.error3().resultado, r.resultado);        
    }
    
    // registrar cliente

    @Test
    public void testRegistrarClienteOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("AM11111", "Alfonso Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }    
    
    @Test
    public void testRegistrarClienteERROR1() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("1234568", "Bruno Giordano", -1);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarClienteERROR2() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("12345688", "Lucas Giordano", 19);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarCliente("123456", "Mauro Giordano", 47);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarClienteERROR3() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("1234569", "Clara Norte", 17);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("1234569", "Agustina Garcia", 18);
        assertEquals(Retorno.error3().resultado, r.resultado);
    }
    
    // crear vuelo
    
    @Test
    public void testCrearVueloOK() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2341", "Aerolineas Argentinas", "FLY300", "Brasil", 1, 11, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR1() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA1112", "Aerolineas Argentinas", "FLY300", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Brasil", 1, 11, 2024, 6, 3);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR2() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Arg", "FLY300", "Brasil", 1, 11, 2024, 6, 3);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR3() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY900", "Brasil", 1, 11, 2024, 6, 3);
        assertEquals(Retorno.error3().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR4() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Brasil", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR5() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 1, 3);
        assertEquals(Retorno.error5().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY300", "Brasil", 10, 12, 2024, 12, 4);
        assertEquals(Retorno.error5().resultado, r.resultado);
    }

    @Test
    public void testCrearVueloERROR6() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("FLY300", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY300", "Brasil", 10, 12, 2024, 15, 3);
        assertEquals(Retorno.error6().resultado, r.resultado);
    }
    
    // comprar pasaje
    
    @Test
    public void testComprarPasajeOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testComprarPasajeERROR1() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("1234567", "AA1111", 2);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testComprarPasajeERROR2() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "Ab1111", 2);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }
    
    // devolver pasaje
    
    @Test
    public void testDevolverPasajeOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeERROR1() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("1234567", "AA1111");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeERROR2() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "Ab1111");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testDevolverPasajeERROR3() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }
    
    // listar aerolineas
    
    @Test
    public void testListarAerolineasOk() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAerolineas();
        assertEquals("Aerolineas Argentinas-Argentina-10|\nCopa Airlines-Panamá-30|\nDelta Air Lines-Estados Unidos-30|\nIberia-España-20|", r.valorString);
    }
    
    // listar aviones

    @Test
    public void testListarAvionesDeAerolineaOK() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // listar aviones
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA311-21|AA345-12|", r.valorString);
    }

    @Test
    public void testListarAvionesDeAerolineaERROR1() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("Varig", "Brazil", 14);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Panam", "EEUU", 24);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarAvionesDeAerolinea("Fiu Fiu");
        assertEquals(Retorno.error1().resultado, r.resultado);    
    }
    
    // listar clientes
    
    @Test
    public void testListarClienteOK() {
        // regirstrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("AM11111", "Alfonso Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // listar clientes
        r = miSistema.listarClientes();
        assertEquals("CB34555-Camila Barcos-54|\nAM11111-Alfonso Miguez-34|\nMF34111-Martina Fernandez-1|", r.valorString);
    }
    
    // listar vuelos

    @Test
    public void testListarVuelosOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 2, 10, 2024, 6, 9);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 5, 9, 2024, 3, 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarVuelos();
        assertEquals("AA1111-Aerolineas Argentinas-FLY221-0-0-15|\nAA2222-Aerolineas Argentinas-FLY221-0-0-15|\nAA3333-Aerolineas Argentinas-FLY221-0-0-15|", r.valorString);
        // comprar pasaje
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA2222", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // listar vuelos
        r = miSistema.listarVuelos();
        assertEquals("AA1111-Aerolineas Argentinas-FLY221-1-0-14|\nAA2222-Aerolineas Argentinas-FLY221-0-1-14|\nAA3333-Aerolineas Argentinas-FLY221-0-0-15|", r.valorString);
    }
    
    // listar vuelos de clientes

    @Test
    public void testListarVuelosDeClientesOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrare avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 11, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 14, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA2222", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA3333", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje (se deberia otorgar a clientes en espera)
        r = miSistema.devolverPasaje("MF34111", "AA2222");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // listar vuelos de clientes
        r = miSistema.vuelosDeCliente("MF34111");
        assertEquals("AA1111-CPR|\nAA2222-DEV|\nAA3333-CPR|", r.valorString);
    }

    @Test
    public void testListarVuelosDeClientesERROR1() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 11, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 14, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA2222", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA3333", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje (se deberia otorgar a clientes en espera)
        r = miSistema.devolverPasaje("MF34111", "AA2222");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // listar vuelos de clientes
        r = miSistema.vuelosDeCliente("1234567");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
    
    // reporte de pasajes devueltos

    @Test
    public void testPasajesDevueltosOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA9999", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 11, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA9999", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // devolver pasaje
        r = miSistema.devolverPasaje("MF34111", "AA9999");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("VM32132", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // reporte de pasajes devueltos
        r = miSistema.pasajesDevueltos("Aerolineas Argentinas");
        assertEquals("MF34111-AA9999|\nVM32132-AA1111|\nCB34555-AA1111|", r.valorString);
    }

    @Test
    public void testPasajesDevueltosError1() {
        // crear aerolinea
        Retorno r = miSistema.crearAerolinea("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // reporte de pasajes devueltos
        r = miSistema.pasajesDevueltos("Aerolineas yui");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
    
    // vista de distribucion de vuelo
    
    @Test
    public void testVistaDeVueloOK() {
        // registrar cliente
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear aerolinea
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // registrar avion
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        // crear vuelo
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // comprar pasaje (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        // vista de distribucion de vuelo
        r = miSistema.vistaDeVuelo("AA1111");
        // Esta prueba no es imprescindible validarla mediante pruebas unitarias, pudiendo hacer una
        // impresion de pantalla con la vista del avion (como se muestra en la letra del obligatorio) 
    }

}
