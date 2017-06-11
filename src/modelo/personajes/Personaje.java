package modelo.personajes;

import modelo.excepciones.CeldaNoExisteException;
import modelo.excepciones.CeldaOcupadaException;
import modelo.personajes.estados.Estado;
import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;

public abstract class Personaje implements IUbicable {

	public Personaje(Coordenada pCoordenada){
		this.ubicacion = pCoordenada;
	}
	
	private Coordenada ubicacion;
	private String Nombre;
	
    protected Estado estado;

	public void Atacar(Personaje pPersonaje){
		//this.estado.Atacar(pPersonaje);
	}

	public void Mover(Coordenada pDestino){
		this.estado.Mover(pDestino, this.ubicacion);
		//this.ubicacion = pDestino;
	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public void Ubicar(Coordenada pCoordenada){
		this.ubicacion = pCoordenada;
	}

	@Override 
	public Coordenada obtenerUbicacion(){
		return this.ubicacion;
	}
	
	public String obtenerEstado(){
		return this.estado.obtenerEstado();
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}
	
}
