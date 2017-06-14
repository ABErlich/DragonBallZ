package modelo.juego;

import modelo.juego.interfaces.IJugadorEquipoVillano;
import modelo.excepciones.NoExisteElPersonajeException;
import modelo.juego.JugadorEquipo;
import modelo.tablero.Coordenada;
import modelo.personajes.Cell;
import modelo.personajes.Freezer;
import modelo.personajes.IPersonajeEquipo;
import modelo.personajes.MajinBoo;
import modelo.personajes.Personaje;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;

public class JugadorEquipoVillano extends JugadorEquipo implements IJugadorEquipoVillano {
	
    public JugadorEquipoVillano(){
        this.personajes.put("Cell", new Cell(new Coordenada(5,0)));
        this.personajes.put("Freezer", new Freezer(new Coordenada(5,1)));
        this.personajes.put("MajinBoo", new MajinBoo(new Coordenada(5,2)));
    }
    

}
