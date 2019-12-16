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

    private ObjectInputStream input;
    private ObjectOutputStream output;
    private ProtocoloInterprete ssp;
    private Socket s;
    private boolean votado;
    private int MAX;
    private volatile DTOJugador DTOjugador;
    private volatile List<HiloServer> threads;
    

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
        Object msjNuevo;

        while (true) {
            try {

              //Aqui se lee la entrada
                msjNuevo = input.readObject();

               // El interprete pasa a procesar el mensaje.
                Object msjLast = ssp.interpretarEntrada(msjNuevo);

               //Un cliente nuevo
                if (msjLast == MsjSockets.NUEVOJUGADOR) {
                    System.out.println("Entro el jugador: " + msjNuevo);
                    this.DTOjugador = (DTOJugador) msjNuevo;

                  //Se crea un lista de clientes.
                    List<DTOJugador> jugadores = new ArrayList<>();
                    for (HiloServer thread : threads) {
                        jugadores.add(thread.getJugadorDTO());
                    }

                //Se comunica a todos los clientes para actualizar.
                    comunicarTodos(jugadores);

                    if (threads.size() == MAX) {
                        Object comenzarPartida = ssp.empezarPartida(jugadores);
                        comunicarTodos(comenzarPartida);
                    }

                  //Si voto el cliente
                } else if (msjLast == MsjSockets.VOTO) {
                   //No voto el cliente
                    if (this.votado == false) {
                        this.votado = true;
                        msjLast = this.DTOjugador.getNombreJugador() + " a votado";
                    //Si ya habia votado el cliente
                    } else {
                        this.votado = false;
                        msjLast = this.DTOjugador.getNombreJugador() + " Se cancelo el voto";
                    }

                    //Regresar la accion 
                    comunicarTodos(msjLast);
                } else if (msjLast instanceof DTOLinea) {
                    comunicarTodos(msjLast);
                } else if (msjLast instanceof DTOCuadro) {
                    comunicarTodos(msjLast);
                    Object marcador = ssp.interpretarEntrada(MsjSockets.MARCADOR);
                    comunicarTodos(marcador);
                }else if (msjLast instanceof DTOMarcador){
                    comunicarTodos(msjLast);
                }

            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    //Aqui se obtienen los datos
    public DTOJugador getJugadorDTO() {
        return DTOjugador;
    }

    public void setJugadorDTO(DTOJugador jugadorDTO) {
        this.DTOjugador = jugadorDTO;
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

    public synchronized void comunicarPropio(Object msj) {
        try {
            this.output.writeObject(msj);
            this.output.flush();
        } catch (IOException ex) {
            Logger.getLogger(HiloServer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Metodo para comunicar a todos los clientes.
    public synchronized void comunicarTodos(Object mensaje) {
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
