/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Marcador;
import pipesandfilters.LavadoRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeMarcador implements Pipe<Marcador, LavadoRepo> {

    @Override
    public void pasar(Marcador objeto) {
        LavadoRepo sr = LavadoRepo.getInstance();
        sr.asignarMarcador(objeto);
    }   
}
