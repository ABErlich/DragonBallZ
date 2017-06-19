package modelo.juego;

import modelo.tablero.Tablero;
import modelo.excepciones.JugadorYaExisteException;

public class Juego {

	public Juego(){
		this.setTablero(new Tablero(10));
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
		jugador1.agregarRival(jugador2);
		jugador2.agregarRival(jugador1);
		jugadorActual = jugador1;
		jugador1.comenzarTurno();
	}
	
	public void terminarTurno(){
		jugadorActual = jugadorActual.terminarTurno();
		jugadorActual.comenzarTurno();
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

}
