package SocketServer;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * 
 */
public class SocketServer {

    static volatile List<HiloServer> threads = new ArrayList<>();

    static int MAX = 2;

    private ProtocoloInterprete ssp = new ProtocoloInterprete();

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4444);
        System.out.println("El servidor se inicializo en el puerto 4444 ");
        System.out.println("Se soporta un total de: " + MAX + " jugadores");

        Socket s;

        while (true) {
            s = ss.accept();

            if (threads.size() < MAX) {
                System.out.println("Se establecio una nueva conexion por parte del cliente: " + s);

                HiloServer sst = new HiloServer(s, threads, MAX);

                Thread t = new Thread(sst);

                threads.add(sst);

                t.start();
            } else {
                System.out.println("El servidor a llegado a su maxima capacidad...");
            }
        }
    }
}
