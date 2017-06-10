package modelo.tablero;

import modelo.excepciones.CeldaNoExisteException;
import modelo.tablero.Coordenada;

public interface IUbicable {
	
	public void Ubicar(Coordenada pCoordenada);
	public Coordenada obtenerUbicacion();
	
}
