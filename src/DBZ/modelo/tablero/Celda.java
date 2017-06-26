package DBZ.modelo.tablero;

import DBZ.modelo.tablero.Coordenada;

public class Celda {

	public Celda(Coordenada coordenada){
		this.coordenada = coordenada;
		this.ocupada = false;
	}

	public Coordenada getCoordenada(){
		return coordenada;
	}

	private Coordenada coordenada;
	private boolean ocupada;

	public void ocupar() {
		this.ocupada = true;
	}
	public void desocupar(){
		this.ocupada = false;
	}
	public boolean estaOcupada(){
		return ocupada;
	}

}
