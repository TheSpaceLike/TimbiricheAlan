/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DominioDTO.DTOCuadro;
import DominioDTO.DTOLinea;
import DominioDTO.DTOMarcador;
import DominioDTO.DTOSala;

/**
 *
 * @author Alejandro Galindo
 */
public interface Repo {
    DTOMarcador obtenerMarcador();
    DTOLinea getLastLine();
    DTOCuadro LastCuadro();
    int obtenerTurnoSiguiente();
}
