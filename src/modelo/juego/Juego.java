package modelo.juego;

import java.util.ArrayList;

public class Juego {

	public static void main(String[] args) {
		

	}
	
	private ArrayList<Jugador> jugadores;
	private Mapa mapa;
	
	public void AgregarJugador(Jugador pJugador){
		jugadores.add(pJugador);
	}
	public void setMapa(Mapa pMapa){
		this.mapa = pMapa;
	}
	
	public void Comenzar(){
		
	}
	
	public void Terminar(){
		
	}

}
