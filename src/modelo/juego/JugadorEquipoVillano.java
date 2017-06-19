package modelo.juego;

import modelo.juego.interfaces.IJugadorEquipoVillano;
import modelo.juego.JugadorEquipo;
import modelo.tablero.Coordenada;
import modelo.personajes.Cell;
import modelo.personajes.Freezer;
import modelo.personajes.MajinBoo;

public class JugadorEquipoVillano extends JugadorEquipo implements IJugadorEquipoVillano {
	
    public JugadorEquipoVillano(){
        this.personajes.put("Cell", new Cell(new Coordenada(0,5)));
        this.personajes.put("Freezer", new Freezer(new Coordenada(1,5)));
        this.personajes.put("MajinBoo", new MajinBoo(new Coordenada(2,5)));
    }
    

}
