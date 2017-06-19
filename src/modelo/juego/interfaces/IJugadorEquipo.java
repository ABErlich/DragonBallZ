package modelo.juego.interfaces;

import modelo.personajes.interfaces.IPersonaje;

public interface IJugadorEquipo {
	int cantidadPersonajesVivos();
	IPersonaje getPersonaje(String pNombrePersonaje);
	void terminoTurno();
}
