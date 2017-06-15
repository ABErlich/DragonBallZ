package modelo.juego;

import modelo.excepciones.NoExisteElPersonajeException;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.personajes.interfaces.IPersonajeEquipo;
import java.util.Dictionary;
import java.util.Hashtable;

public class JugadorEquipo implements IJugadorEquipo{

	protected Dictionary<String, IPersonajeEquipo> personajes;

	public JugadorEquipo(){
		this.personajes = new Hashtable<String, IPersonajeEquipo>();
	}
	public int cantidadPersonajesVivos(){
		return personajes.size();
	}
	
	public IPersonajeEquipo getPersonaje(String pNombrePersonaje){
		IPersonajeEquipo pj = this.personajes.get(pNombrePersonaje);
		if(pj == null){
			throw new NoExisteElPersonajeException();
		}else{
			return pj;
		}
	}
}
