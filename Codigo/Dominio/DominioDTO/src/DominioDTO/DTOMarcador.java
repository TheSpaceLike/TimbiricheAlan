/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;
import java.util.List;

/**
 *
 * 
 */
public class DTOMarcador implements Serializable{
    private List<DTOJugador> jugadores;
    private int siguiente;

    public DTOMarcador(List<DTOJugador> jugadores) {
        this.jugadores = jugadores;
        this.siguiente = 0;
    }

    public DTOMarcador(List<DTOJugador> jugadores, int siguiente) {
        this.jugadores = jugadores;
        this.siguiente = siguiente;
    }

    public List<DTOJugador> getJugadores() {
        return jugadores;
    }

    public void setJugadores(List<DTOJugador> jugadores) {
        this.jugadores = jugadores;
    }

    public int getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(int siguiente) {
        this.siguiente = siguiente;
    }

    @Override
    public String toString() {
        return "MarcadorDTO{" + "jugadores=" + jugadores + ", siguiente=" + siguiente + '}';
    }
}