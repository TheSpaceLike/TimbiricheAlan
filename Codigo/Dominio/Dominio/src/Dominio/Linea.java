/**
 * Linea.java
 */
package Dominio;

/**
 *
 * 
 */
public class Linea extends FormaJuego {
    
    private Posicion posicion;

    public Linea(Posicion posicion, int indice, int width, int height, int x, int y) {
        super(null, indice, width, height, x, y);
        this.posicion = posicion;
    }

    public Linea(Posicion posicion, Jugador jugador, int indice) {
        super(jugador, indice, 0, 0, 0, 0);
        this.posicion = posicion;
    }
    
    public Linea(Posicion posicion, int indice){
        super(null, indice, 0, 0, 0, 0);
        this.posicion = posicion;
    }

    public Posicion getPosicion() {
        return posicion;
    }

    public void setPosicion(Posicion posicion) {
        this.posicion = posicion;
    }
}