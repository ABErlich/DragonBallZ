package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IEquipoVillano;
import modelo.personajes.IEquipoZ;

public interface IEstado {
	public String obtenerEstado();
	public void Atacar(IEquipoZ pPersonaje);
	public void Atacar(IEquipoVillano pPersonaje);
	public void Mover(Coordenada pCoordenada);
}
