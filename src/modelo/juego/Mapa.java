package modelo.juego;

import modelo.tablero.Tablero;

public class Mapa {
	
	public Mapa(String pNombre, int pTamanio){
		this.setTablero(new Tablero(pTamanio));
		this.Nombre = pNombre;
	}
	
	private String Nombre;
	private Tablero tablero;

	public String getNombre() {
		return Nombre;
	}

	public void setNombre(String nombre) {
		Nombre = nombre;
	}

	public Tablero getTablero() {
		return tablero;
	}

	public void setTablero(Tablero tablero) {
		this.tablero = tablero;
	}
	
}
