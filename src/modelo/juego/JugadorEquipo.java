package modelo.juego;

import modelo.juego.IJugadorEquipo;
import modelo.personajes.Personaje;

import java.util.Dictionary;
import java.util.Hashtable;

public class JugadorEquipo implements IJugadorEquipo{

	protected Dictionary<String, Personaje> personajes;

	public JugadorEquipo(){
		this.personajes = new Hashtable<String, Personaje>();
	}
	public int cantidadPersonajesVivos(){
		return personajes.size();
	}
	/*
	public Personaje getPersonaje(String pNombrePersonaje){
		Personaje pj = this.personajes.get(pNombrePersonaje);
		if(pj == null){
			throw new NoExisteElPersonajeException();
		}else{
			return pj;
		}
	}
	*/
}
