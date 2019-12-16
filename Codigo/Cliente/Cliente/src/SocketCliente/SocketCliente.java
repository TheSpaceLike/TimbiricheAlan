/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;


import Dominio.Posicion;
import DominioDTO.DTOCuadro;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;
import presentacion.inicio.IActualizable;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import DominioDTO.DTOMarcador;
import java.io.IOException;
import java.io.ObjectInputStream;
import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;


/**
 *
 * 
 */
public class SocketCliente implements Runnable {

    private Jugador jugador;
    private Socket socket;
    private ObjectInputStream clientInput;
    private ObjectOutputStream clientOutput;
    private IActualizable actualizable;
    private Object objeto;

    private static SocketCliente instance;

    private SocketCliente(Jugador jugador, IActualizable actualizable) {
        this.jugador = jugador;
        this.actualizable = actualizable;
    }

    public static SocketCliente getInstance(Jugador jugador, IActualizable actualizable) {
        if (instance == null) {
            instance = new SocketCliente(jugador, actualizable);
        } else {
            instance.actualizable = actualizable;
        }
        return instance;
    }

    public synchronized void connectServ(String address, int port) throws IOException {
        socket = new Socket(address, port);
        clientOutput = new ObjectOutputStream(socket.getOutputStream());
        clientOutput.flush();
        clientInput = new ObjectInputStream(socket.getInputStream());
    }

    public synchronized void SendServ(Object mensaje) throws IOException {
        clientOutput.writeObject(mensaje);
        clientOutput.flush();
    }

    public synchronized void ListenServ() throws IOException, ClassNotFoundException {
        Thread t = new Thread(this);
        t.start();
    }

    @Override
    public void run() {
        while (true) {
            try {
                objeto = clientInput.readObject();

                if (objeto instanceof List) {
                    List<DTOJugador> DTOJugadores = (List<DTOJugador>) objeto;
                    List<Jugador> jugadores = new ArrayList<>();

                    for (DTOJugador jugador : DTOJugadores) {
                        jugadores.add(new Jugador(jugador.getNombreJugador(), jugador.getRutaAvatar()));
                    }

                    objeto = jugadores;
                } else if (objeto instanceof String) {
                    String string = (String) objeto;
                    objeto = string;
                } else if (objeto instanceof DTOMarcador) {
                    DTOMarcador DTOMarcador = (DTOMarcador) objeto;
                    List<DTOJugador> DTOJugadores = DTOMarcador.getJugadores();
                    List<Jugador> jugadores = new ArrayList<>();

                    for (DTOJugador jugador : DTOJugadores) {
                        jugadores.add(new Jugador(jugador.getNombreJugador(), jugador.getRutaAvatar(), jugador.getPuntaje()));
                    }

                    Marcador marcador = new Marcador(jugadores);

                    objeto = marcador;
                } else if (objeto instanceof DTOLinea) {
                    DTOLinea DTOLinea = (DTOLinea) objeto;

                    Linea linea = new Linea(
                            Posicion.valueOf(DTOLinea.getPosicion()),
                            new Jugador(
                                    DTOLinea.getJugador().getNombreJugador(),
                                    DTOLinea.getJugador().getRutaAvatar(),
                                    DTOLinea.getJugador().getPuntaje()),
                            DTOLinea.getIndice());

                    objeto = linea;
                } else if (objeto instanceof DTOCuadro) {
                    DTOCuadro DTOCuadro = (DTOCuadro) objeto;

                    Cuadro cuadro = new Cuadro(
                            new Jugador(
                                    DTOCuadro.getJugador().getNombreJugador(),
                                    DTOCuadro.getJugador().getRutaAvatar(),
                                    DTOCuadro.getJugador().getPuntaje()),
                            DTOCuadro.getIndice());

                    objeto = cuadro;
                }

                SwingUtilities.invokeLater(new Runnable() {
                    @Override
                    public void run() {
                        actualizable.upDate(objeto);
                    }
                });

                System.out.println(objeto);
            } catch (IOException | ClassNotFoundException ex) {
                Logger.getLogger(SocketCliente.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
