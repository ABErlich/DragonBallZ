package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.tablero.Coordenada;

public class Celda {
	
	public Celda(Coordenada pCoordenada){
		this.coordenada = pCoordenada;
	}
	
	public Coordenada getCoordenada(){
		return coordenada;
	}
	
	private Coordenada coordenada;

	
}
