package DBZ.modelo.tablero;

import DBZ.modelo.tablero.Coordenada;

public interface IUbicable {

	public void ubicar(Coordenada pCoordenada);
	public Coordenada obtenerUbicacion();

}
