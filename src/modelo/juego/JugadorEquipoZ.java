package modelo.juego;

import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.juego.JugadorEquipo;
import modelo.tablero.Coordenada;
import modelo.personajes.Goku;
import modelo.personajes.Gohan;
import modelo.personajes.Piccolo;

public class JugadorEquipoZ extends JugadorEquipo implements IJugadorEquipoZ {

    public JugadorEquipoZ(){
        this.personajes.put("Goku", new Goku(new Coordenada(0,0)));
        this.personajes.put("Gohan", new Gohan(new Coordenada(0,1)));
        this.personajes.put("Piccolo", new Piccolo(new Coordenada(0,2)));
    }	

}
