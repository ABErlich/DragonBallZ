package modelo.personajes;

import modelo.personajes.estados.Estado;
import modelo.tablero.IUbicable;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.*;
import modelo.personajes.Stats;

public abstract class Personaje implements IUbicable, IPersonajeEquipo {

	public Personaje(){
		stats = new Stats();
	}
	
	protected Stats stats;
	private String Nombre;
    protected Estado estado;

	public void Atacar(modelo.personajes.interfaces.IPersonajeEquipoZ pPersonaje){
		this.estado.Atacar(pPersonaje, this.stats);
	}

	public void Atacar(modelo.personajes.interfaces.IPersonajeEquipoVillano pPersonaje){
		this.estado.Atacar(pPersonaje, this.stats);
	}

	public void Mover(Coordenada pDestino){
		this.estado.Mover(pDestino, this.stats);
		//this.ubicacion = pDestino;
	}

	public void RecibirAtaque(int danio){

	}

	@Override
	public void Ubicar(Coordenada pCoordenada){
		this.stats.setUbicacion(pCoordenada);
	}

	@Override 
	public Coordenada obtenerUbicacion(){
		return this.stats.getUbicacion();
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
	
	public Stats getStats(){
		return this.stats;
	}

	public int getVida(){
		return this.stats.getVida();
	}

	public void setVida(int pVida){
		this.stats.setVida(pVida);
	}
	
}
