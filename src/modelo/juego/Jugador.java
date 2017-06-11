package modelo.juego;

import modelo.juego.JugadorEquipoVillano;
import modelo.juego.JugadorEquipoZ;

import modelo.excepciones.JugadorPoseeEquipoException;
import modelo.excepciones.JugadorNoPoseeEquipoException;

public class Jugador {
	
	private String Nombre;
	private IJugadorEquipo equipo;

	public Jugador(String pNombre){
		this.Nombre = pNombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void asignarEquipoZ(){
		if(this.equipo == null){
			this.equipo = new JugadorEquipoZ();
		}else{
			throw new JugadorPoseeEquipoException();
		}
		
	}

	public void asignarEquipoVillano(){
		if(this.equipo == null){
			this.equipo = new JugadorEquipoVillano();
		}else{
			throw new JugadorPoseeEquipoException();
		}
	}

	public int cantidadPersonajesVivos(){
		if(this.equipo != null){
			return this.equipo.cantidadPersonajesVivos();
		}else{
			throw new JugadorNoPoseeEquipoException();
		}
		
	}
	
}
