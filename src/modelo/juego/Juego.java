package modelo.juego;

import java.util.ArrayList;
import modelo.tablero.Tablero;

public class Juego {

	/*public static void main(String[] args) {
		

	}*/
	public Juego(){
		this.setTablero(new Tablero(10));
		jugadores = new ArrayList<Jugador>();
	}
	
	private ArrayList<Jugador> jugadores;
	private Tablero tablero;
	
	public void AgregarJugador(Jugador pJugador){
		jugadores.add(pJugador);
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
