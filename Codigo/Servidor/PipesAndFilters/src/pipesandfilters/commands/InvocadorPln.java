/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.commands;

import DominioDTO.DTOCuadro;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import java.util.List;
import pipesandfilters.P;

/**
 *
 * @author Alejandro Galindo
 */
public class InvocadorPln implements P{
    
    IPAFPipeline comando;

    @Override
    public void crearSala(List<DTOJugador> jugadores) {
        comando = new CrearSalaPln(jugadores);
        comando.ejecutar();
    }

    @Override
    public void asignarLinea(DTOLinea linea) {
        comando = new AsignarLineaPln(linea);
        comando.ejecutar();
    }

    @Override
    public void asignarCuadro(DTOCuadro cuadro) {
        comando = new AsignarCuadroPln(cuadro);
        comando.ejecutar();
    }

    @Override
    public void retirarJugador(DTOJugador jugador) {
        comando = new RetirarJugadorPln(jugador);
        comando.ejecutar();
    }   
}