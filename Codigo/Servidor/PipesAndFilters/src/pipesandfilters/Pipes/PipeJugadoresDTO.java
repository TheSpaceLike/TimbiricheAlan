/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import DominioDTO.DTOJugador;
import java.util.List;
import pipesandfilters.Filters.FilterJugadores;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeJugadoresDTO implements Pipe<List<DTOJugador>, FilterJugadores> {

    @Override
    public void pasar(List<DTOJugador> objeto) {
        FilterJugadores fj = new FilterJugadores();
        fj.procesar(objeto);
    }
    
}
