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

       public Object procesarEntrada(Object MsjEntrante) {


           if (MsjEntrante instanceof DTOJugador) {
            return MsjSockets.JUGADOR_NUEVO;

           
        } else if (MsjEntrante instanceof DTOLinea) {
            DTOLinea lineaP = (DTOLinea) MsjEntrante;
            ipaf.asignarLinea(lineaP);
            DTOLinea oul = repo.getLastLine();
            System.out.println(oul);
            return oul;

            
        } else if (MsjEntrante instanceof DTOCuadro) {
            DTOCuadro cuadroP = (DTOCuadro) MsjEntrante;
            ipaf.asignarCuadro(cuadroP);

            DTOCuadro ouc = repo.LastCuadro();
            System.out.println(ouc);
            return ouc;

      
        } else if (MsjEntrante == MsjSockets.VOTO) {
            return MsjSockets.VOTO;
        } else if (MsjEntrante == MsjSockets.TURNO_TERMINADO) {
            return repo.obtenerTurnoSiguiente();
        } else if (MsjEntrante == MsjSockets.MARCADOR){
            return repo.obtenerMarcador();
        }

        return null;
    }

    public Object empezarPartida(List<DTOJugador> jugadoresDTO) {
        ipaf.crearSala(jugadoresDTO);
        return repo.obtenerMarcador();
    }
}
