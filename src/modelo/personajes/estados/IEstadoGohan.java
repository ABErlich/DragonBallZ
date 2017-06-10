package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public interface IEstadoGohan extends IEstado {
	
	public void Atacar(Personaje pPersonaje);
	public void Mover(Coordenada pCoordenada);
	public void RecibirAtaque(int danio);

	
}
