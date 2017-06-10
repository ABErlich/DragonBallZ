package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class EstadoNormal implements IEstado {
	
	public void Atacar(Personaje pPersonaje){

	}

	public void Mover(Coordenada pCoordenada){

	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public String obtenerEstado() {
		return "Normal";
	}
}
