package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.tablero.Coordenada;
import fiuba.algo3.modelo.tablero.Ubicable;

public class Celda {
	
	public Celda(Coordenada pCoordenada){
		this.coordenada = pCoordenada;
	}

	private Coordenada coordenada;
	private boolean ocupada;
	private Ubicable ubicable;
	
}
