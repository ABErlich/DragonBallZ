package DBZ.modelo.juego.interfaces;

import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.tablero.Tablero;

public interface IJugadorEquipo {
	int cantidadPersonajesVivos();
	IPersonaje getPersonaje(String pNombrePersonaje);
	void terminoTurno();
	void ubicarPersonajes(Tablero tablero);
	boolean puedeUsarPersonaje(IPersonaje personaje);
}
