package modelo.juego.interfaces;

import modelo.personajes.Personaje;

public interface IJugadorEquipo {
	int cantidadPersonajesVivos();
	Personaje getPersonaje(String pNombrePersonaje);
}
