package modelo.personajes;


import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
public interface IEquipoVillano {
	public void Atacar(Personaje pPersonaje);
	public void Mover(Coordenada pCoordenada);
}
