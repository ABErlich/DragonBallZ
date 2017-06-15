package modelo.tablero;

import modelo.excepciones.CeldaNoExisteException;
import modelo.excepciones.CeldaOcupadaException;
import modelo.tablero.Celda;
import modelo.tablero.Coordenada;
import modelo.tablero.IUbicable;

import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {
	
	public Tablero(int pTamanio){
		this.celdas = new Hashtable<Coordenada, Celda>();
		this.ubicables = new Hashtable<IUbicable, Celda>();
		
		if(pTamanio < 6){
			for(int i = 0; i < 6; i++){
				for(int j = 0; j < 6; j++){
					Coordenada coord = new Coordenada(i,j);
					this.celdas.put(coord, new Celda(coord));
				}
			}
		}else{
			
			for(int i = 0; i < pTamanio; i++){
				for(int j = 0; j < pTamanio; j++){
					Coordenada coord = new Coordenada(i,j);
					this.celdas.put(coord, new Celda(coord));
				}
			}
		}
	}
	
	private Dictionary<Coordenada, Celda> celdas;
	private Dictionary<IUbicable, Celda> ubicables;
	
	public void agregarUbicable(IUbicable pUbicable){
		// obtengo la celda en la cual se pondra el ubicable
		Celda celda = celdas.get(pUbicable.obtenerUbicacion());
		// si la celda no existe lanzo la excepcion
		// si esta ocupada lanzo otra excepcion
		if(celda != null){
			if(!celda.estaOcupada()){
				celda.Ocupar();
				ubicables.put(pUbicable, celda);
			}else{
				throw new CeldaOcupadaException();
			}
			
		}else{
			throw new CeldaNoExisteException();
		}
	}

	public Coordenada obtenerUbicacion(IUbicable pUbicable) {
		return ubicables.get(pUbicable).getCoordenada();
	}
	
	public void actualizarPosiciones(){
		
	}

	
}
