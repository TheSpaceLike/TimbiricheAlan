/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters.Pipes;

import Dominio.Cuadro;
import pipesandfilters.LavadoRepo;

/**
 *
 * @author Alejandro Galindo
 */
public class PipeCuadro implements Pipe<Cuadro, LavadoRepo> {

    @Override
    public void pasar(Cuadro objeto) {
        LavadoRepo sr = LavadoRepo.getInstance();
        sr.asignarCuadro(objeto);
    }   
}