package modelo.juego.interfaces;

import modelo.personajes.interfaces.IPersonajeEquipo;

public interface IJugadorEquipo {
	int cantidadPersonajesVivos();
	IPersonajeEquipo getPersonaje(String pNombrePersonaje);
}
