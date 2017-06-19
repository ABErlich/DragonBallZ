package modelo.juego.interfaces;

import modelo.personajes.interfaces.IPersonaje;
import modelo.tablero.Tablero;

public interface IJugadorEquipo {
	int cantidadPersonajesVivos();
	IPersonaje getPersonaje(String pNombrePersonaje);
	void terminoTurno();
	void ubicarPersonajes(Tablero tablero);
}
