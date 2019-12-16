/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pipesandfilters;

import Dominio.Cuadro;
import Dominio.Jugador;
import Dominio.Linea;
import Dominio.Marcador;
import Dominio.Sala;
import DominioDTO.DTOCuadro;
import DominioDTO.DTOJugador;
import DominioDTO.DTOLinea;
import DominioDTO.DTOMarcador;
import DominioDTO.DTOSala;
import DominioDTO.DTOTablero;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Alejandro Galindo
 */
public class AccesoRepo implements Repo {

    private LavadoRepo sr = LavadoRepo.getInstance();

    @Override
    public DTOMarcador obtenerMarcador() {
        Marcador marcador = sr.obtenerMarcador();

        List<DTOJugador> jugadoresDTO = new ArrayList<>();
        for (Jugador jugador : marcador.getJugadores()) {
            jugadoresDTO.add(new DTOJugador(jugador.getNombre(), jugador.getRutaAvatar(), jugador.getPuntaje()));
        }
        DTOMarcador marcadorDTO = new DTOMarcador(jugadoresDTO);

        return marcadorDTO;
    }

    @Override
    public DTOLinea getLastLine() {
        Linea linea = sr.obtenerUltimaLinea();
        if (linea != null) {
            DTOLinea lineaDTO
                    = new DTOLinea(
                            linea.getPosicion().toString(),
                            linea.getIndice(),
                            new DTOJugador(
                                    linea.getJugador().getNombre(),
                                    linea.getJugador().getRutaAvatar(),
                                    linea.getJugador().getPuntaje()));
            return lineaDTO;
        }else{
            return null;
        }
    }

    @Override
    public DTOCuadro LastCuadro() {
        Cuadro cuadro = sr.obtenerUltimoCuadro();
        DTOCuadro cuadroDTO
                = new DTOCuadro(cuadro.getIndice(),
                        new DTOJugador(cuadro.getJugador().getNombre(),
                                cuadro.getJugador().getRutaAvatar(),
                                cuadro.getJugador().getPuntaje()));

        return cuadroDTO;
    }

    @Override
    public int obtenerTurnoSiguiente() {
        return sr.obtenerTurnoSiguiente();
    }
}
