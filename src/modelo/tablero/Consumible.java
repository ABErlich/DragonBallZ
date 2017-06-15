package modelo.tablero;

import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;

public abstract class Consumible implements IUbicable {

	private Coordenada ubicacion;

	public void Ubicar(Coordenada pCoordenada) {
		this.ubicacion = pCoordenada;
	}

	public Coordenada obtenerUbicacion(){
		return this.ubicacion;
	}

}
