package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.excepciones.CeldaNoExisteException;
import fiuba.algo3.modelo.excepciones.CeldaOcupadaException;
import fiuba.algo3.modelo.tablero.Celda;
import fiuba.algo3.modelo.tablero.Coordenada;
import fiuba.algo3.modelo.tablero.IUbicable;

import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {
	
	public Tablero(int pTamanio){
		this.celdas = new Hashtable<Coordenada, Celda>();
		this.ubicables = new Hashtable<IUbicable, Coordenada>();
		
		for(int i = 0; i < pTamanio; i++){
			for(int j = 0; j < pTamanio; j++){
				Coordenada coord = new Coordenada(i,j);
				this.celdas.put(coord, new Celda(coord));
			}
		}
	}
	
	private Dictionary<Coordenada, Celda> celdas;
	private Dictionary<IUbicable, Coordenada> ubicables;
	
	public void Ubicar(IUbicable pUbicable, Coordenada pCoordenada) throws CeldaNoExisteException, CeldaOcupadaException{
		Celda celda = celdas.get(pCoordenada);
		if(celda != null){
			if(!celda.estaOcupada()){
				celda.Ocupar();
				ubicables.put(pUbicable, pCoordenada);
			}else{
				throw new CeldaOcupadaException();
			}
			
		}else{
			throw new CeldaNoExisteException();
		}
		
	}

	public Coordenada obtenerUbicacion(IUbicable pUbicable) {
		return ubicables.get(pUbicable);
	}

	
}
