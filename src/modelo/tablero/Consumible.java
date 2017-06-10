package modelo.tablero;

import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;

public class Consumible implements IUbicable {

	private Coordenada ubicacion;

	@Override
	public void Ubicar(Coordenada pCoordenada) {
		this.ubicacion = pCoordenada;
	}
	@Override
	public Coordenada obtenerUbicacion(){
		return this.ubicacion;
	}

}
