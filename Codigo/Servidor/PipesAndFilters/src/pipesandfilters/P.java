/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import DominioDTO.*;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public interface P {
    void crearSala(List<DTOJugador> jugadores);
    void asignarLinea(DTOLinea linea);
    void asignarCuadro(DTOCuadro cuadro);
    void retirarJugador(DTOJugador jugador);
}