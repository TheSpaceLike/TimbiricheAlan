/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Filters;

import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Posicion;
import DominioDTO.DTOLinea;
import pipesandfilters.Pipes.PipeLinea;

/**
 *
 * @author Alejandro Galindo
 */
public class FilterLinea implements Filter<DTOLinea, Linea, PipeLinea>{

    @Override
    public void procesar(DTOLinea objeto) {
        Jugador jugador = new Jugador(objeto.getJugador().getNombreJugador(), objeto.getJugador().getRutaAvatar());
        Linea linea = new Linea(Posicion.valueOf(objeto.getPosicion()), jugador, objeto.getIndice());
        PipeLinea pl = new PipeLinea();
        pl.pasar(linea);
    }
}
