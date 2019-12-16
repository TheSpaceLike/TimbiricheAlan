/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketServer;

import DominioDTO.DTOCuadro;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import DominioDTO.MsjSockets;
import java.util.List;
import pipesandfilters.AccesoRepo;
import pipesandfilters.P;
import pipesandfilters.commands.InvocadorPln;
import pipesandfilters.Repo;

/**
 *
 *
 */
public class ProtocoloInterprete {

    private P ipaf;
    private Repo repo;

    public ProtocoloInterprete() {
       init();
    }

    
    private void init(){
           this.ipaf = new InvocadorPln();
           this.repo = new AccesoRepo();    
       }

       public Object interpretarEntrada(Object msjNuevo) {

           //En esta parte es donde se realiza la conexion y el cliente (socketCliente) 
           //manda la informacion del cliente por medio del hilo.
           if (msjNuevo instanceof DTOJugador) {
            return MsjSockets.NUEVOJUGADOR;

           //Cuando se reciban los objetos de transferencia de datos (DTOMovimiento)
           //este lo mando al PAF para interpretar los datos y asignarlos y recibir una respuesta.
        } else if (msjNuevo instanceof DTOLinea) {
            DTOLinea lineaP = (DTOLinea) msjNuevo;
            ipaf.asignarLinea(lineaP);
            DTOLinea xl = repo.getLastLine();
            System.out.println(xl);
            return xl;

            
        } else if (msjNuevo instanceof DTOCuadro) {
            DTOCuadro cuadroP = (DTOCuadro) msjNuevo;
            ipaf.asignarCuadro(cuadroP);

            DTOCuadro xc = repo.LastCuadro();
            System.out.println(xc);
            return xc;

            //Aqui si un cliente vota este voto se pasa a verificar 
            //y posteriormente se notifica mendiante una respuesta.
        } else if (msjNuevo == MsjSockets.VOTO) {
            return MsjSockets.VOTO;
        } else if (msjNuevo == MsjSockets.TURNOFINALIZADO) {
            return repo.obtenerTurnoSiguiente();
        } else if (msjNuevo == MsjSockets.MARCADOR){
            return repo.obtenerMarcador();
        }

        return null;
    }

    public Object empezarPartida(List<DTOJugador> jugadoresDTO) {
        ipaf.crearSala(jugadoresDTO);
        return repo.obtenerMarcador();
    }
}
