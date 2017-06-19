package modelo.juego;

import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import modelo.excepciones.JugadorYaExisteException;
import modelo.excepciones.JugadoresNoSeleccionadosException;
import modelo.personajes.interfaces.IPersonaje;

public class Juego {

	public Juego(){
		this.tablero = new Tablero(10);
	}
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugadorActual;
	private Tablero tablero;
	
	
	public void agregarJugador1(Jugador jugador){
		if(jugador1 == null){
			jugador1 = jugador;
		}else{
			throw new JugadorYaExisteException();
		}
	}
	
	public void agregarJugador2(Jugador jugador){
		if(jugador2 == null){
			jugador2 = jugador;
		}else{
			throw new JugadorYaExisteException();
		}
	}
	
	public void comenzarJuego(){
		if(jugador1 == null || jugador2 == null){
			throw new JugadoresNoSeleccionadosException();
		}
		jugador1.agregarRival(jugador2);
		jugador2.agregarRival(jugador1);
		
		double selector = Math.random();
		if(selector > 0.5){
			jugadorActual = jugador1;
		}else{
			jugadorActual = jugador2;
		}
		this.comenzarTurno();
	}
	
	public void moverPersonaje(String nombrepersonaje, Coordenada coordenada){
		IPersonaje personaje = jugadorActual.getPersonaje(nombrepersonaje);
		tablero.moverPersonaje(personaje, coordenada);
	}
	
	private void comenzarTurno() {
		
		
	}

	public void terminarTurno(){
		jugadorActual = jugadorActual.terminarTurno();
	}

	public void asignarEquipoZ(Jugador jugador) {
		jugador.asignarEquipoZ(this.tablero);
		jugador.ubicarPersonajes(tablero);
	}

	public void asignarEquipoVillano(Jugador jugador) {
		jugador.asignarEquipoVillano(this.tablero);
		jugador.ubicarPersonajes(tablero);
	}

	public Object cantidadPersonajesVivos(Jugador jugador) {
		return jugador.cantidadPersonajesVivos();
	}


}
