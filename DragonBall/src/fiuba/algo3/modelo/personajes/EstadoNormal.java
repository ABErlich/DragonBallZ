package fiuba.algo3.modelo.personajes;

import fiuba.algo3.modelo.tablero.Coordenada;

public class EstadoNormal implements IEstadoGoku {
	
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
