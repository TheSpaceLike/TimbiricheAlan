/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Tablero;
import pipesandfilters.LavadoRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeTablero implements Pipe<Tablero, LavadoRepo>{

    @Override
    public void pasar(Tablero objeto) {
        LavadoRepo sr = LavadoRepo.getInstance();
        sr.asignarTablero(objeto);
    }
    
}
