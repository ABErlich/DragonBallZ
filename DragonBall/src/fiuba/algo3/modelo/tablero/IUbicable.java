package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.excepciones.CeldaNoExisteException;
import fiuba.algo3.modelo.tablero.Coordenada;

public interface IUbicable {
	
	public void Ubicar(Coordenada pCoordenada) throws CeldaNoExisteException;
	
}
