package modelo.personajes;

import modelo.excepciones.CeldaNoExisteException;
import modelo.excepciones.CeldaOcupadaException;
import modelo.personajes.estados.Estado;
import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;

public abstract class Personaje implements IUbicable, IPersonajeEquipo {

	public Personaje(Coordenada pCoordenada){
		this.ubicacion = pCoordenada;
	}
	
	protected Coordenada ubicacion;
	private String Nombre;
	
    protected Estado estado;

	public void Atacar(IPersonajeEquipoZ pPersonaje){
		this.estado.Atacar(pPersonaje);
	}

	public void Atacar(IPersonajeEquipoVillano pPersonaje){
		this.estado.Atacar(pPersonaje);
	}

	public void Mover(Coordenada pDestino){
		this.estado.Mover(pDestino);
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
	
	public Estado obtenerEstado(){
		return this.estado;
	}
	
	public String getNombre() {
		return Nombre;
	}
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public int getVida(){
		return this.estado.getVida();
	}

	public void setVida(int pVida){
		this.estado.setVida(pVida);
	}
	
}
