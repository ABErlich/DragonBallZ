package modelo.juego.interfaces;

import modelo.personajes.IPersonajeEquipo;
import modelo.personajes.Personaje;

public interface IJugadorEquipo {
	int cantidadPersonajesVivos();
	IPersonajeEquipo getPersonaje(String pNombrePersonaje);
}
