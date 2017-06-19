package modelo.tablero;

import modelo.excepciones.CeldaNoExisteException;
import modelo.excepciones.CeldaOcupadaException;
import modelo.excepciones.PersonajeNoExisteException;
import modelo.personajes.Personaje;
import modelo.tablero.Celda;
import modelo.tablero.Coordenada;
import java.util.ArrayList;
import java.util.Dictionary;
import java.util.Hashtable;

public class Tablero {

	public Tablero(int tamanio){
		this.celdas = new Hashtable<Coordenada, Celda>();
		this.consumibles = new Hashtable<Coordenada,Consumible>();
		this.personajes = new ArrayList<Personaje>();
		
		if(tamanio < 6){
			for(int i = 0; i < 6; i++){
				for(int j = 0; j < 6; j++){
					Coordenada coord = new Coordenada(i,j);
					this.celdas.put(coord, new Celda(coord));
				}
			}
		}else{
			
			for(int i = 0; i < tamanio; i++){
				for(int j = 0; j < tamanio; j++){
					Coordenada coord = new Coordenada(i,j);
					this.celdas.put(coord, new Celda(coord));
				}
			}
		}
	}
	
	private Hashtable<Coordenada, Consumible> consumibles;
	private Dictionary<Coordenada, Celda> celdas;
	private ArrayList<Personaje> personajes;
	
	public void agregarPersonaje(Personaje personaje){
		// obtengo la celda en la cual se pondra el ubicable
		Celda celda = celdas.get(personaje.obtenerUbicacion());
		// si la celda no existe lanzo la excepcion
		// si esta ocupada lanzo otra excepcion
		if(celda != null){
			if(!celda.estaOcupada()){
				celda.ocupar();
				personajes.add(personaje);
			}else{
				throw new CeldaOcupadaException();
			}
			
		}else{
			throw new CeldaNoExisteException();
		}
	}
	
	public void agregarConsumible(Consumible consumible, Coordenada coordenada){
		// obtengo la celda en la cual se pondra el ubicable
		Celda celda = celdas.get(coordenada);
		// si la celda no existe lanzo la excepcion
		// si esta ocupada lanzo otra excepcion
		if(celda != null){
			if(!celda.estaOcupada()){
				consumibles.put(coordenada, consumible);
			}else{
				throw new CeldaOcupadaException();
			}
			
		}else{
			throw new CeldaNoExisteException();
		}
	}

	public void moverPersonaje(Personaje personaje, Coordenada nuevaCoordenada) {
		Coordenada coordenadaPj = personaje.obtenerUbicacion();
		if(personajes.contains(personaje)){
			Celda celda = celdas.get(nuevaCoordenada);
			// si la celda no existe lanzo la excepcion
			// si esta ocupada por otro personaje lanzo otra excepcion
			if(celda != null){
				if(!celda.estaOcupada()){
					celda.ocupar();
					celdas.get(coordenadaPj).desocupar();
					personajes.get(personajes.indexOf(personaje)).mover(nuevaCoordenada);
					this.actualizarEstadoConsumibles(personaje);
				}else{
					throw new CeldaOcupadaException();
				}
				
			}else{
				throw new CeldaNoExisteException();
			}
		}else{
			throw new PersonajeNoExisteException();
		}
	}
	
	private void actualizarEstadoConsumibles(Personaje personaje){
		Coordenada coordenadaPj = personaje.obtenerUbicacion();
		Consumible consumible = consumibles.get(coordenadaPj);
		
		if(consumible != null && consumible.estaConsumido() == false){
			personaje.consumir(consumible);
		}
	}

	
}
