/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SocketCliente;

import presentacion.inicio.IActualizable;

/**
 *
 * 
 */
public interface ICliente { 
    boolean ConnectServ(String address, int port);
    boolean SendServ(Object mensaje);
    void ListenServ();
}
