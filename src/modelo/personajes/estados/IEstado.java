package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public interface IEstado {
	public String obtenerEstado();
	public void Atacar(Personaje pPersonaje);
	public void Mover(Coordenada pCoordenada);
}
