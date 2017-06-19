package modelo.tablero;

import modelo.tablero.Coordenada;

public interface IUbicable {
	
	public void ubicar(Coordenada pCoordenada);
	public Coordenada obtenerUbicacion();
	
}
