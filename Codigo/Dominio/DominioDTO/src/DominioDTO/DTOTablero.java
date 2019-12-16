/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DominioDTO;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

/**
 *
 * 
 */
public class DTOTablero implements Serializable{
    private List<DTOLinea> lineasVerticalesDTO;
    private List<DTOLinea> lineasHorizontalesDTO;
    private List<DTOCuadro> listaCuadrosDTO;

    public DTOTablero(List<DTOLinea> lineasVerticalesDTO, List<DTOLinea> lineasHorizontalesDTO, List<DTOCuadro> listaCuadrosDTO) {
        this.lineasVerticalesDTO = lineasVerticalesDTO;
        this.lineasHorizontalesDTO = lineasHorizontalesDTO;
        this.listaCuadrosDTO = listaCuadrosDTO;
    }

    public List<DTOLinea> getLineasVerticalesDTO() {
        return lineasVerticalesDTO;
    }

    public void setLineasVerticalesDTO(List<DTOLinea> lineasVerticalesDTO) {
        this.lineasVerticalesDTO = lineasVerticalesDTO;
    }

    public List<DTOLinea> getLineasHorizontalesDTO() {
        return lineasHorizontalesDTO;
    }

    public void setLineasHorizontalesDTO(List<DTOLinea> lineasHorizontalesDTO) {
        this.lineasHorizontalesDTO = lineasHorizontalesDTO;
    }

    public List<DTOCuadro> getListaCuadrosDTO() {
        return listaCuadrosDTO;
    }

    public void setListaCuadrosDTO(List<DTOCuadro> listaCuadrosDTO) {
        this.listaCuadrosDTO = listaCuadrosDTO;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.lineasVerticalesDTO);
        hash = 23 * hash + Objects.hashCode(this.lineasHorizontalesDTO);
        hash = 23 * hash + Objects.hashCode(this.listaCuadrosDTO);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final DTOTablero other = (DTOTablero) obj;
        if (!Objects.equals(this.lineasVerticalesDTO, other.lineasVerticalesDTO)) {
            return false;
        }
        if (!Objects.equals(this.lineasHorizontalesDTO, other.lineasHorizontalesDTO)) {
            return false;
        }
        if (!Objects.equals(this.listaCuadrosDTO, other.listaCuadrosDTO)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "TableroDTO{ verticales" + lineasVerticalesDTO + ", horizontales " + lineasHorizontalesDTO + ", cuadrados " + listaCuadrosDTO + '}';
    }
}