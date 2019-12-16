/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentacion.juego;

import Dominio.FormaJuego;

/**
 *
 * 
 */
public interface PnlObservable {
    void agrega(PnlObservador observador);
    void notificaForma(FormaJuego forma);
}
