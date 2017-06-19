package modelo.personajes.interfaces;

import modelo.tablero.Coordenada;

public interface IPersonaje {
	void recibirAtaque(int poderBase,int danio);
	Coordenada obtenerUbicacion();
	boolean vidaMenor30porc();
	void terminoTurno();

}
