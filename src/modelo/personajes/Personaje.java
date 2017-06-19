package modelo.personajes;

import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;
import modelo.tablero.IUbicable;
import modelo.personajes.interfaces.*;

public abstract class Personaje implements IUbicable, IPersonaje {

	private String Nombre;

	public String getNombre() {
		return Nombre;
	}
	
	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public abstract void mover(Coordenada coordenada);
	
	public abstract void consumir(Consumible consumible);
	
}
