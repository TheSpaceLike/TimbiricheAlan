/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServer;

import DominioDTO.DTOCuadro;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import DominioDTO.DTOMarcador;
import DominioDTO.MsjSockets;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * 
 */
public class HiloServer implements Runnable {

    private volatile DTOJugador jugadorDTO;
    private ObjectInputStream input;
    private ObjectOutputStream output;
    private volatile List<HiloServer> threads;
    private ProtocoloInterprete ssp;
    private Socket s;
    private boolean votado;
    private int MAX;

    public HiloServer(Socket s, List<HiloServer> hilo, int MAX) throws IOException {
        this.s = s;
        this.threads = hilo;
        this.votado = false;
        this.ssp = new ProtocoloInterprete();
        this.output = new ObjectOutputStream(s.getOutputStream());
        this.output.flush();
        this.input = new ObjectInputStream(s.getInputStream());
        this.MAX = MAX;
    }

    @Override
    public void run() {
        Object MsjEntrante;

        while (true) {
            try {

              
                MsjEntrante = input.readObject();

               
                Object MsjSaliendo = ssp.procesarEntrada(MsjEntrante);

              
                if (MsjSaliendo == MsjSockets.JUGADOR_NUEVO) {
                    System.out.println("Entro jugador: " + MsjEntrante);
                    this.jugadorDTO = (DTOJugador) MsjEntrante;

                  
                    List<DTOJugador> jugadores = new ArrayList<>();
                    for (HiloServer thread : threads) {
                        jugadores.add(thread.getJugadorDTO());
                    }

                
                    transmitirATodos(jugadores);

                    if (threads.size() == MAX) {
                        Object empezarPartida = ssp.empezarPartida(jugadores);
                        transmitirATodos(empezarPartida);
                    }

                  
                } else if (MsjSaliendo == MsjSockets.VOTO) {
                   
                    if (this.votado == false) {
                        this.votado = true;
                        MsjSaliendo = this.jugadorDTO.getNombreJugador() + " votado";
                        
                    } else {
                        this.votado = false;
                        MsjSaliendo = this.jugadorDTO.getNombreJugador() + " Se ha cancelado el voto";
                    }

                    
                    transmitirATodos(MsjSaliendo);
                } else if (MsjSaliendo instanceof DTOLinea) {
                    transmitirATodos(MsjSaliendo);
                } else if (MsjSaliendo instanceof DTOCuadro) {
                    transmitirATodos(MsjSaliendo);
                    Object marcador = ssp.procesarEntrada(MsjSockets.MARCADOR);
                    transmitirATodos(marcador);
                }else if (MsjSaliendo instanceof DTOMarcador){
                    transmitirATodos(MsjSaliendo);
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public DTOJugador getJugadorDTO() {
        return jugadorDTO;
    }

    public void setJugadorDTO(DTOJugador jugadorDTO) {
        this.jugadorDTO = jugadorDTO;
    }

    public ObjectInputStream getInput() {
        return input;
    }

    public ObjectOutputStream getOutput() {
        return output;
    }

    public boolean isVotado() {
        return votado;
    }

    public void setVotado(boolean votado) {
        this.votado = votado;
    }

    public synchronized void transmitirASiMismo(Object msj) {
        try {
            this.output.writeObject(msj);
            this.output.flush();
        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public synchronized void transmitirATodos(Object mensaje) {
        for (HiloServer thread : threads) {
            try {
                thread.output.writeObject(mensaje);
                thread.output.flush();
            } catch (IOException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

}
