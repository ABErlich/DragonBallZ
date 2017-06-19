package modelo.tablero;

import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;

public abstract class Consumible implements IUbicable {

	protected Coordenada ubicacion;

	public void ubicar(Coordenada pCoordenada) {
		this.ubicacion = pCoordenada;
	}

	public Coordenada obtenerUbicacion(){
		return this.ubicacion;
	}

}
