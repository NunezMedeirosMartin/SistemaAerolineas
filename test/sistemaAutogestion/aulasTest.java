package sistemaAutogestion;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class aulasTest {

    private Sistema miSistema;

    public aulasTest() {
    }

    @Before
    public void setUp() {
        miSistema = new Sistema();
    }

    @Test
    public void testCrearAerolineaOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.crearAerolinea("Copa Airlines", "Panamá", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testCrearAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 0);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", -3);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("TAP Portugal");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAerolineaERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAerolinea("Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionOK() {

        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA700", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 18, "Aerolineas Argentinas");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 3, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarAvion("AA345", 14, "Aerolineas Argentinas");
        assertEquals(Retorno.error2().resultado, r.resultado);
    }

    @Test
    public void testRegistrarAvionERROR3() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Porter Airlines");
        assertEquals(Retorno.error3().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 15, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.ok().resultado, r.resultado);

    }

    @Test
    public void testEliminarAvionERROR1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Gol Brasil", "AA345");
        assertEquals(Retorno.error1().resultado, r.resultado);
    }

    @Test
    public void testEliminarAvionERROR2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB800", 21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "YY111");
        assertEquals(Retorno.error2().resultado, r.resultado);

    }


    @Test
    public void testEliminarAvionnERROR3() {
    Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 9,3 );
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("5561207", "1234", 1);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        
        r = miSistema.eliminarAvion("Aerolineas Argentinas", "AA345");
        assertEquals(Retorno.error3().resultado, r.resultado);
    }
    @Test
    public void testListarAerolineas() {
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

    @Test
    public void testListarAvionesDeAerolinea() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345",12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563",21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.listarAvionesDeAerolinea("Aerolineas Argentinas");
        assertEquals("AA311-21|\nAA345-12|\n" , r.valorString);
            
    }
     @Test
    public void testListarAvionesDeAerolineaError1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Delta Air Lines", "Estados Unidos", 30);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345",12, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("IB563",21, "Iberia");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("AA311", 21, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.listarAvionesDeAerolinea("American Airlines");
        assertEquals(Retorno.error1().resultado, r.resultado);
            
    }
    
    @Test
    public void registrarClienteOK() {
        Retorno r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("4663421", "Angelina", 38);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("3456789", "Dylan", 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
    }
    
    @Test
    public void registrarClienteERROR1() {
        Retorno r = miSistema.registrarCliente("5561207", "Martina", 0);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.registrarCliente("4663421", "Angelina", -1);
        assertEquals(Retorno.error1().resultado, r.resultado);
        r = miSistema.registrarCliente("3456789", "Dylan", -3);
        assertEquals(Retorno.error1().resultado, r.resultado);
    }
    
    @Test
    public void registrarClienteERROR2() {
        Retorno r = miSistema.registrarCliente("556127", "Martina", 19);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarCliente("46634261", "Angelina", 38);
        assertEquals(Retorno.error2().resultado, r.resultado);
        r = miSistema.registrarCliente("3456767789", "Dylan", 12);
        assertEquals(Retorno.error2().resultado, r.resultado);
    }
    
    @Test
    public void registrarClienteERROR3() {
        Retorno r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("4663421", "Angelina", 38);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("3456789", "Dylan", 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.error3().resultado, r.resultado);
        r = miSistema.registrarCliente("4663421", "Angelina", 38);
        assertEquals(Retorno.error3().resultado, r.resultado);
        r = miSistema.registrarCliente("3456789", "Dylan", 12);
        assertEquals(Retorno.error3().resultado, r.resultado);
    }
    
    
    @Test
    public void testListarClientes() {
        Retorno r = miSistema.registrarCliente("5561207", "Martina Enciso", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("4663421", "Angelina Flores", 38);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("3456789", "Dylan Flores", 12);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.listarClientes();
        assertEquals("3456789-Dylan Flores-12|\n4663421-Angelina Flores-38|\n5561207-Martina Enciso-19|\n", r.valorString);
    }
    
    @Test
    public void crearVueloOK() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado); 

    }
    
    @Test
    public void crearVueloError1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.error1().resultado, r.resultado);


    }
    
    @Test
    public void crearVueloError2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.crearVuelo("1234", "Aerolinea Inexistente", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.error2().resultado, r.resultado); 
       

    }
    
    @Test
    public void crearVueloError3() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "EE111", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.error3().resultado, r.resultado); 
       

    }
    
     @Test
    public void crearVueloError4() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado); 
        r = miSistema.crearVuelo("2345", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.error4().resultado, r.resultado); 

    }
    
    @Test
    public void crearVueloError5() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 11, 5);
        assertEquals(Retorno.error5().resultado, r.resultado); 
        
    }

    
    @Test
    public void crearVueloError6() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);


        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);


        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 15, 6);
        assertEquals(Retorno.error6().resultado, r.resultado); 

    }
    
    @Test
    public void comprarPasajeOk() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 9,3 );
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("5561207", "1234", 1);
        assertEquals(Retorno.ok().resultado, r.resultado); 
    }

    @Test
    public void comprarPasajeError1() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);


        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);


        r = miSistema.comprarPasaje("1111111", "1234", 2);
        assertEquals(Retorno.error1().resultado, r.resultado); 
    }
    
    @Test
    public void comprarPasajeError2() {
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearAerolinea("Iberia", "España", 20);
        assertEquals(Retorno.ok().resultado, r.resultado);


        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarAvion("MMLOL", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);


        r = miSistema.comprarPasaje("5561207", "1111", 2);
        assertEquals(Retorno.error2().resultado, r.resultado); 
    }
    

     @Test
    public void testDevolverPasajeOK() {
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99822", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 3, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("GV99822", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Devolución de pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);


    }
 
    
     @Test
    public void testDevolverPasajeError1() {
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Devolución de pasaje 
        r = miSistema.devolverPasaje("udigfb", "AA1111");
        assertEquals(Retorno.error1().resultado, r.resultado);

    }
    @Test

     public void testDevolverPasajeError2() {
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Devolución de pasaje 
        r = miSistema.devolverPasaje("VM32132", "AA0000");
        assertEquals(Retorno.error2().resultado, r.resultado);

    }
    
    @Test

     public void testDevolverPasajeError3() {
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Camila Barcos", 54);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99882", "Gerardo Vercias", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);

        //Devolución de pasaje 
        r = miSistema.devolverPasaje("CB34555", "AA1111");
        assertEquals(Retorno.error3().resultado, r.resultado);

    }
     
    @Test
    public void testListarVuelosOK() {
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Veronida Miguez", 34);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 12, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 2, 10, 2024, 6, 9);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 5, 9, 2024, 3, 12);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.listarVuelos();
        assertEquals("AA1111-Aerolineas Argentinas-FLY221-0-0-15|\nAA2222-Aerolineas Argentinas-FLY221-0-0-15|\nAA3333-Aerolineas Argentinas-FLY221-0-0-15|\n", r.valorString);

        }
     
    @Test
    public void testListarVuelosDeClientesOK() {

        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA2222", "Aerolineas Argentinas", "FLY221", "Uruguay", 11, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.crearVuelo("AA3333", "Aerolineas Argentinas", "FLY221", "Uruguay", 14, 12, 2024, 6, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);

        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA2222", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("MF34111", "AA3333", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Devolución de pasaje (se deberían otorgar a los dos clientes que están esperando)
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.vuelosDeCliente("MF34111");
        assertEquals("AA3333-CPR|\nAA2222-CPR|\nAA1111-CPR|\nAA1111-DEV|", r.valorString);

    }
     

    
    @Test
            public void testPasajesDevueltosOK() {
        //Creación de clientes
        Retorno r = miSistema.registrarCliente("MF34111", "Martina Fernandez", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Valentina Gonzalez", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Fernando Lima", 64);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99822", "Francisco Cerro", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aerolineas
        r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de aviones
        r = miSistema.registrarAvion("FLY221", 9, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Creación de vuelos
        r = miSistema.crearVuelo("AA1111", "Aerolineas Argentinas", "FLY221", "Uruguay", 10, 12, 2024, 3, 3);
        assertEquals(Retorno.ok().resultado, r.resultado);
        //Compra de pasajes (hay disponible)
        r = miSistema.comprarPasaje("MF34111", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "AA1111", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);

        //Devolución de pasaje 
        r = miSistema.devolverPasaje("MF34111", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.devolverPasaje("VM32132", "AA1111");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        //listar 
        r = miSistema.pasajesDevueltos("Aerolineas Argentinas");
        assertEquals("MF34111-AA1111|\nVM32132-AA1111|\n", r.valorString);
        

    }
            
    @Test
    public void vistaDistribucionDeVuelo(){
        Retorno r = miSistema.crearAerolinea("Aerolineas Argentinas", "Argentina", 10);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.registrarAvion("AA345", 15, "Aerolineas Argentinas");
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.registrarCliente("5561207", "Martina", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("VM32132", "Valentina Gonzalez", 23);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("CB34555", "Fernando Lima", 64);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.registrarCliente("GV99822", "Francisco Cerro", 19);
        assertEquals(Retorno.ok().resultado, r.resultado);

        r = miSistema.crearVuelo("1234", "Aerolineas Argentinas", "AA345", "Uru", 31, 01, 2005, 6,3 );
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        r = miSistema.comprarPasaje("5561207", "1234", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("VM32132", "1234", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("CB34555", "1234", 1);
        assertEquals(Retorno.ok().resultado, r.resultado);
        r = miSistema.comprarPasaje("GV99822", "1234", 2);
        assertEquals(Retorno.ok().resultado, r.resultado);
        
        
        r = miSistema.vistaDeVuelo("1234");
        assertEquals("************\n"+
                      "* PRIMERA *\n" +
                     "************\n" +
                 " * GV99822 *  * XXXXXXXX *  * XXXXXXXX * \n" +
                 "************\n" +
                 "* ECONÓMICA *\n" +
                 "************\n" +
                 " * 5561207 *  * VM32132 *  * CB34555 * \n" +
                "************\n" +
                 " * XXXXXXXX *  * XXXXXXXX *  * XXXXXXXX * \n" +
                 "************\n", r.valorString);
        
 
        
    }
            
   
    


}

  