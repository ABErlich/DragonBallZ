package modelo.tablero;

import modelo.tablero.Coordenada;

public class Celda {
	
	public Celda(Coordenada pCoordenada){
		this.coordenada = pCoordenada;
		this.ocupada = false;
	}
	
	public Coordenada getCoordenada(){
		return coordenada;
	}
	
	private Coordenada coordenada;
	private boolean ocupada;

	public void Ocupar() {
		this.ocupada = true;
	}
	public void Desocupar(){
		this.ocupada = false;
	}
	public boolean estaOcupada(){
		return ocupada;
	}
	
}
