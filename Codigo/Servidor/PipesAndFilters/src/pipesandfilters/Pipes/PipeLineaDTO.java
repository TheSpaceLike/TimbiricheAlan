/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import DominioDTO.DTOLinea;
import pipesandfilters.Filters.FilterLinea;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeLineaDTO implements Pipe<DTOLinea, FilterLinea>{

    @Override
    public void pasar(DTOLinea objeto) {
        FilterLinea fl = new FilterLinea();
        fl.procesar(objeto);
    }   
}