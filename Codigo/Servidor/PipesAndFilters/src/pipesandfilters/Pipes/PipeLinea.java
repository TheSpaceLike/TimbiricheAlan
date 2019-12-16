/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Linea;
import pipesandfilters.LavadoRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeLinea implements Pipe<Linea, LavadoRepo>{

    @Override
    public void pasar(Linea objeto) {
        LavadoRepo sr = LavadoRepo.getInstance();
        sr.asignarLinea(objeto);
    }
    
}
