package modelo.personajes.interfaces;

import modelo.tablero.Consumible;
import modelo.tablero.Coordenada;

public interface IPersonaje {
	
    void atacar(IPersonajeEquipoZ personajeAtacado);
	void atacar(IPersonajeEquipoVillano personaje);
	void recibirAtaque(int poderBase,int danio);
	void mover(Coordenada nuevaCoordenada);
	
	Coordenada obtenerUbicacion();
	int getVida();
	boolean vidaMenor30porc();
	void terminoTurno();
	void consumir(Consumible consumible);
	boolean estaVivo();

}
