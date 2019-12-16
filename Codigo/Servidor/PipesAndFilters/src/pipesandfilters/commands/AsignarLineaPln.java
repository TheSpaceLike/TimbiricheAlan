/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.commands;

import DominioDTO.DTOLinea;
import pipesandfilters.Pipes.PipeLineaDTO;

/**
 *
 * @author Alejandro Galindo
 */
class AsignarLineaPln implements IPAFPipeline{
    
    private DTOLinea linea;

    public AsignarLineaPln(DTOLinea linea) {
        this.linea = linea;
    }

    @Override
    public void ejecutar() {
        PipeLineaDTO pl = new PipeLineaDTO();
        pl.pasar(linea);
    }    
}