/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.commands;

import DominioDTO.DTOCuadro;
import pipesandfilters.Pipes.PipeCuadroDTO;

/**
 *
 * @author Alejandro Galindo
 */
class AsignarCuadroPln implements IPAFPipeline {

    private DTOCuadro cuadro;

    public AsignarCuadroPln(DTOCuadro cuadro) {
        this.cuadro = cuadro;
    }
    
    @Override
    public void ejecutar() {
        PipeCuadroDTO pc = new PipeCuadroDTO();
        pc.pasar(cuadro);
    }
    
}
