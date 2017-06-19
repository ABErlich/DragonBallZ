package modelo.juego;

import modelo.excepciones.NoExisteElPersonajeException;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.personajes.interfaces.IPersonaje;
import modelo.tablero.Tablero;

import java.util.Dictionary;
import java.util.Enumeration;
import java.util.Hashtable;

public class JugadorEquipo implements IJugadorEquipo{

	protected Dictionary<String, IPersonaje> personajes;

	public JugadorEquipo(){
		this.personajes = new Hashtable<String, IPersonaje>();
	}
	
	public int cantidadPersonajesVivos(){
		Enumeration<String> enumKey = personajes.keys();
		int cantpjvivos = 0;
		while(enumKey.hasMoreElements()) {
		    String key = enumKey.nextElement();
		    if(personajes.get(key).estaVivo()){
		    	cantpjvivos++;
		    };
		}
		return cantpjvivos;
	}
	
	public IPersonaje getPersonaje(String pNombrePersonaje){
		IPersonaje pj = this.personajes.get(pNombrePersonaje);
		if(pj == null){
			throw new NoExisteElPersonajeException();
		}else{
			return pj;
		}
	}
	
	public void terminoTurno() {
		Enumeration<String> enumKey = personajes.keys();
		while(enumKey.hasMoreElements()) {
		    String key = enumKey.nextElement();
		    personajes.get(key).terminoTurno();
		    
		}
	}
	
	public void ubicarPersonajes(Tablero tablero) {
		Enumeration<String> enumKey = personajes.keys();
		while(enumKey.hasMoreElements()) {
		    String key = enumKey.nextElement();
		    tablero.agregarPersonaje(personajes.get(key));
		}
	}
}
