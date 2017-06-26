package DBZ.modelo.juego;

import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;
import DBZ.modelo.juego.JugadorEquipo;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.Tablero;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.personajes.Gohan;
import DBZ.modelo.personajes.Piccolo;

public class JugadorEquipoZ extends JugadorEquipo implements IJugadorEquipoZ {

    public JugadorEquipoZ(Tablero tablero){
        this.personajes.put("Goku", new Goku(new Coordenada(0,0)));
        this.personajes.put("Gohan", new Gohan(new Coordenada(0,1)));
        this.personajes.put("Piccolo", new Piccolo(new Coordenada(0,2)));
    }

}
