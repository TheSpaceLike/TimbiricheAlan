/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import DominioDTO.DTOJugador;
import pipesandfilters.Filters.FilterJugador;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeJugadorDTO implements Pipe<DTOJugador, FilterJugador>{

    @Override
    public void pasar(DTOJugador objeto) {
        FilterJugador fj = new FilterJugador();
        fj.procesar(objeto);
    }   
}