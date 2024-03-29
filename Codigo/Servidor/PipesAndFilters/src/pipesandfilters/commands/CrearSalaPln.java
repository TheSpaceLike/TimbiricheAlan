/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.commands;

import DominioDTO.DTOJugador;
import java.util.List;
import pipesandfilters.Pipes.PipeJugadoresDTO;
import pipesandfilters.Pipes.PipeTamanio;

/**
 *
 * @author Alejandro Galindo
 */
class CrearSalaPln implements IPAFPipeline{

    private List<DTOJugador> jugadores;

    public CrearSalaPln(List<DTOJugador> jugadores) {
        this.jugadores = jugadores;
    }
    
    @Override
    public void ejecutar() {
        PipeJugadoresDTO pj = new PipeJugadoresDTO();
        pj.pasar(jugadores);
        PipeTamanio pt = new PipeTamanio();
        pt.pasar(jugadores.size());
    }
    
}
