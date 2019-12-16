/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;

/**
 *
 * 
 */
public class DTOSala implements Serializable{
    private DTOTablero tableroDTO;
    private DTOMarcador marcadorDTO;

    public DTOSala(DTOTablero tableroDTO, DTOMarcador marcadorDTO) {
        this.tableroDTO = tableroDTO;
        this.marcadorDTO = marcadorDTO;
    }

    public DTOTablero getTableroDTO() {
        return tableroDTO;
    }

    public void setTableroDTO(DTOTablero tableroDTO) {
        this.tableroDTO = tableroDTO;
    }

    public DTOMarcador getMarcadorDTO() {
        return marcadorDTO;
    }

    public void setMarcadorDTO(DTOMarcador marcadorDTO) {
        this.marcadorDTO = marcadorDTO;
    }

    @Override
    public String toString() {
        return "SalaDTO{" + "tableroDTO=" + tableroDTO + ", marcadorDTO=" + marcadorDTO + '}';
    }
}