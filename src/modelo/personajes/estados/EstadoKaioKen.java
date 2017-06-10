package modelo.personajes.estados;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;

public class EstadoKaioKen implements IEstado {

	@Override
	public void Atacar(Personaje pPersonaje) {


	}

	@Override
	public void Mover(Coordenada pCoordenada) {

	}

	@Override
	public String obtenerEstado() {
		return "KaioKen";
	}


}
