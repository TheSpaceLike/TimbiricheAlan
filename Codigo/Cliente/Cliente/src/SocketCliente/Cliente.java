/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import DominioDTO.DTOCuadro;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import DominioDTO.MsjSockets;
import java.io.IOException;
import presentacion.inicio.IActualizable;


public class Cliente implements ICliente {

    private static Cliente instance;

    private SocketCliente SocketCliente;
      

    public Cliente(Jugador jugador, IActualizable actualizable) {
        this.SocketCliente = SocketCliente.getInstance(jugador, actualizable);
    }

    @Override
    public boolean ConnectServ(String address, int port) {
        try {
            SocketCliente.connectServ(address, port);
            return true;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public boolean SendServ(Object Msj) {
        try {
            if (Msj instanceof Jugador) {
                Jugador jugador = (Jugador) Msj;
                DTOJugador MsjNuevo = new DTOJugador(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje());
                SocketCliente.SendServ(MsjNuevo);
                return true;
            } else if (Msj instanceof Linea) {
                Linea line = (Linea) Msj;
                DTOLinea MsjNuevo = 
                        new DTOLinea(
                                line.getPosicion().toString(), 
                                line.getIndice(), 
                                new DTOJugador(
                                        line.getJugador().getNombre(), 
                                        line.getJugador().getRutaAvatar(), 
                                        line.getJugador().getPuntaje()));
                
                SocketCliente.SendServ(MsjNuevo);
                return true;
            } else if (Msj instanceof Cuadro) {
                Cuadro cuadro = (Cuadro) Msj;
                DTOCuadro MsjNuevo = 
                        new DTOCuadro(
                                cuadro.getIndice(), 
                                new DTOJugador(
                                        cuadro.getJugador().getNombre(), 
                                        cuadro.getJugador().getRutaAvatar(), 
                                        cuadro.getJugador().getPuntaje()));
                
                SocketCliente.SendServ(MsjNuevo);
                return true;
            } else if (Msj instanceof String){
                SocketCliente.SendServ(Msj);
                return true;
            } else if(Msj instanceof MsjSockets){
                SocketCliente.SendServ(Msj);
                return true;
            }
            return false;
        } catch (IOException ex) {
            return false;
        }
    }

    @Override
    public void ListenServ() {
        try {
            SocketCliente.ListenServ();
        } catch (IOException | ClassNotFoundException ex) {
            System.out.println("No se hizo la machaca con el servidor.");
        }
    }

}
