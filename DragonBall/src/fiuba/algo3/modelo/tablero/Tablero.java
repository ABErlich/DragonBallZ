package fiuba.algo3.modelo.tablero;

import fiuba.algo3.modelo.tablero.Celda;
import fiuba.algo3.modelo.tablero.Coordenada;
import fiuba.algo3.modelo.tablero.IUbicable;

import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {
	
	public Tablero(int pTamanio){
		this.celdas = new Hashtable<Coordenada, Celda>();
		this.celdasOcupadas = new Hashtable<IUbicable, Celda>();
		
		for(int i = 0; i < pTamanio; i++){
			for(int j = 0; j < pTamanio; j++){
				Coordenada coord = new Coordenada(i,j);
				this.celdas.put(coord, new Celda(coord));
			}
		}
	}
	
	private Dictionary<Coordenada, Celda> celdas;
	private Dictionary<IUbicable, Celda> celdasOcupadas;
	
	public boolean PuedeUbicar(Coordenada pCoordenada){
		if(celdasOcupadas.get(pCoordenada) != null){
			return false;
		}else{
			return true;
		}
	}
	
	public void Ubicar(IUbicable pUbicable, Coordenada pCoordenada){
		celdasOcupadas.put(pUbicable, celdas.get(pCoordenada));
	}

	public Coordenada obtenerPosicionDe(IUbicable pUbicable) {
		return celdasOcupadas.get(pUbicable).getCoordenada();
	}

	
}
