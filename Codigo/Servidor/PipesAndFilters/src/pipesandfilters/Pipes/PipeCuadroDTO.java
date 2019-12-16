/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import DominioDTO.DTOCuadro;
import pipesandfilters.Filters.FilterCuadro;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeCuadroDTO implements Pipe<DTOCuadro, FilterCuadro>{

    @Override
    public void pasar(DTOCuadro objeto) {
        FilterCuadro fc = new FilterCuadro();
        fc.procesar(objeto);
    }
    
}
