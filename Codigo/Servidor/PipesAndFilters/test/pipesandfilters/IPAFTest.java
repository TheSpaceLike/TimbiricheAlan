/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import pipesandfilters.commands.InvocadorPln;
import DominioDTO.DTOCuadro;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import DominioDTO.DTOSala;
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * 
 */
public class IPAFTest {
    
    private List<DTOJugador> jugadores;
    
    public IPAFTest() {
        jugadores = new ArrayList<>();
        jugadores.add(new DTOJugador("Jugador1", "laRuta", 0));
        jugadores.add(new DTOJugador("Jugador2", "laRuta", 0));
        jugadores.add(new DTOJugador("Jugador3", "laRuta", 0));
        jugadores.add(new DTOJugador("Jugador4", "laRuta", 0));
    }

    /**
     * Test of crearSala method, of class IPAF.
     */
    @Test
    public void testCrearSala() {
        
        P instance = new InvocadorPln();
        Repo accesoRepo = new AccesoRepo();
        
        instance.crearSala(jugadores);
        
    }

    /**
     * Test of asignarLinea method, of class IPAF.
     */
    @Test
    public void testAsignarLinea() {
        P instance = new InvocadorPln();
        Repo accesoRepo = new AccesoRepo();
        
        DTOLinea linea = new DTOLinea("VERTICAL", 2, jugadores.get(0));
        
        instance.crearSala(jugadores);
        instance.asignarLinea(linea);
        
    }

    /**
     * Test of asignarCuadro method, of class IPAF.
     */
    @Test
    public void testAsignarCuadro() {
        P instance = new InvocadorPln();
        Repo accesoRepo = new AccesoRepo();
        
        DTOCuadro cuadro = new DTOCuadro(4, jugadores.get(1));
        
        //Crea la sala denuevo por si se ejecuta antes que testCrearSala()
        instance.crearSala(jugadores);
        instance.asignarCuadro(cuadro);
        
    }

    /**
     * Test of retirarJugador method, of class IPAF.
     */
    @Test
    public void testRetirarJugador() {
        P instance = new InvocadorPln();
        Repo accesoRepo = new AccesoRepo();
        
        DTOCuadro cuadro = new DTOCuadro(0, jugadores.get(1));
        DTOCuadro cuadro1 = new DTOCuadro(1, jugadores.get(1));
        DTOCuadro cuadro2 = new DTOCuadro(2, jugadores.get(1));
        
        //Crea la sala denuevo por si se ejecuta antes que testCrearSala()
        instance.crearSala(jugadores);
        instance.asignarCuadro(cuadro);
        instance.asignarCuadro(cuadro1);
        instance.asignarCuadro(cuadro2);
        
    }    
}