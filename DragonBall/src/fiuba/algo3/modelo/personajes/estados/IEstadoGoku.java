package fiuba.algo3.modelo.personajes.estados;

import fiuba.algo3.modelo.personajes.Personaje;
import fiuba.algo3.modelo.tablero.Coordenada;

public interface IEstadoGoku extends IEstado {
	
	public void Atacar(Personaje pPersonaje);
	public void Mover(Coordenada pCoordenada);
	public void RecibirAtaque(int danio);

	
}
