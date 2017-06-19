package modelo.juego;

import modelo.juego.JugadorEquipoVillano;
import modelo.juego.JugadorEquipoZ;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.personajes.interfaces.IPersonaje;
import modelo.tablero.Tablero;
import modelo.excepciones.JugadorPoseeEquipoException;
import modelo.excepciones.PersonajeEquipoContrarioException;
import modelo.excepciones.JugadorNoPoseeEquipoException;

public class Jugador {
	
	private String Nombre;
	private Jugador rival;
	private IJugadorEquipo equipo;

	public Jugador(String nombre){
		this.Nombre = nombre;
	}

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public void asignarEquipoZ(Tablero tablero){
		if(this.equipo == null){
			this.equipo = new JugadorEquipoZ(tablero);
		}else{
			throw new JugadorPoseeEquipoException();
		}
	}

	public void asignarEquipoVillano(Tablero tablero){
		if(this.equipo == null){
			this.equipo = new JugadorEquipoVillano(tablero);
		}else{
			throw new JugadorPoseeEquipoException();
		}
	}
	
	public IPersonaje getPersonaje(String nombrePersonaje){
		IPersonaje personaje = equipo.getPersonaje(nombrePersonaje);
		if(personaje != null){
			return personaje;
		}else{
			throw new PersonajeEquipoContrarioException();
		}
	}

	public int cantidadPersonajesVivos(){
		if(this.equipo != null){
			return this.equipo.cantidadPersonajesVivos();
		}else{
			throw new JugadorNoPoseeEquipoException();
		}
		
	}
	
	public void agregarRival(Jugador rival){
		this.rival = rival;
	}
	

	public Jugador terminarTurno() {
		this.equipo.terminoTurno();
		return rival;
	}

	public void ubicarPersonajes(Tablero tablero) {
		if(this.equipo == null){
			throw new JugadorNoPoseeEquipoException();
		}
		this.equipo.ubicarPersonajes(tablero);
	}

	
	
}
