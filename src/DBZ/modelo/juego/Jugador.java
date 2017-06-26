package DBZ.modelo.juego;

import DBZ.modelo.juego.JugadorEquipoVillano;
import DBZ.modelo.juego.JugadorEquipoZ;
import DBZ.modelo.juego.interfaces.IJugadorEquipo;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.tablero.Tablero;
import DBZ.modelo.excepciones.JugadorPoseeEquipoException;
import DBZ.modelo.excepciones.PersonajeEquipoContrarioException;
import DBZ.modelo.excepciones.JugadorNoPoseeEquipoException;

public class Jugador {

	private String Nombre;
	public Jugador rival;
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
			this.equipo.ubicarPersonajes(tablero);
		}else{
			throw new JugadorPoseeEquipoException();
		}
	}

	public void asignarEquipoVillano(Tablero tablero){
		if(this.equipo == null){
			this.equipo = new JugadorEquipoVillano(tablero);
			this.equipo.ubicarPersonajes(tablero);
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

	public boolean tieneEquipo() {
		if(this.equipo == null){
			return false;
		}else{
			return true;
		}
	}

	public IJugadorEquipoZ getEquipo() {
		return (IJugadorEquipoZ) this.equipo;
	}



}
