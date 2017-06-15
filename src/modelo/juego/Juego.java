package modelo.juego;

import java.util.ArrayList;
import modelo.tablero.Tablero;
import modelo.excepciones.JugadorYaExisteException;

public class Juego {

	public Juego(){
		this.setTablero(new Tablero(10));
	}
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Tablero tablero;
	
	public void AgregarJugador1(Jugador pJugador){
		if(jugador1 == null){
			jugador1 = pJugador;
		}else{
			throw new JugadorYaExisteException();
		}
	}

	public void AgregarJugador2(Jugador pJugador){
		if(jugador2 == null){
			jugador2 = pJugador;
		}else{
			throw new JugadorYaExisteException();
		}
	}
	
	public void Comenzar(){
		
	}
	
	public void Terminar(){
		
	}
	
	public Tablero getTablero() {
		return tablero;
	}
	
	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}

}
