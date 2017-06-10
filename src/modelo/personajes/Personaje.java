package modelo.personajes;

import modelo.excepciones.CeldaNoExisteException;
import modelo.excepciones.CeldaOcupadaException;
import modelo.personajes.estados.IEstado;
import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;

public abstract class Personaje implements IUbicable, IEstado {

	public Personaje(Coordenada pCoordenada){
		this.ubicacion = pCoordenada;
	}
	
	public Personaje(){
	}
	
	private Coordenada ubicacion;
	private String Nombre;
	
    protected IEstado estado;
	protected int vida;
	protected int poder;
	protected int distanciaAtaque;
	protected int velocidadMov;
	protected int ki;
	
	public void Atacar(Personaje pPersonaje){
		pPersonaje.RecibirAtaque(poder);
	}

	public void Mover(Coordenada pCoordenada){
		this.ubicacion = pCoordenada;
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
