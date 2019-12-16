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

    static volatile List<HiloServer> hilos = new ArrayList<>();

    static int MAXIMA = 4;

    private ProtocoloInterprete ssp = new ProtocoloInterprete();

    /**
     * 
     */
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(4444);
        Socket s;
        System.out.println("--Servidor ON--");
        System.out.println("La capacidad maxima de clientes es de: "+MAXIMA);
        System.out.println("Ya pueden ingresar los clientes");
        System.out.println("Utiliza la IP -localhost-");
        System.out.println("Utiliza el PUERTO -4444-");        

        while (true) {
            s = ss.accept();

            if (hilos.size() < MAXIMA) { 
                System.out.println("Se establecio una nueva conexion por parte del cliente: " + s);

                HiloServer sst = new HiloServer(s, hilos, MAXIMA); 

                Thread hilo = new Thread(sst);

                hilos.add(sst);
                
                

                hilo.start();
            } else {
                System.out.println("El servidor a llegado a su maxima capacidad...");
            }
        }
    }
}
