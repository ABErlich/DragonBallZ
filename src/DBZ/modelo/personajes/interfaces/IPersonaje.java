package DBZ.modelo.personajes.interfaces;

import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;
import DBZ.modelo.tablero.Consumible;
import DBZ.modelo.tablero.Coordenada;

public interface IPersonaje {

    void atacar(IPersonaje atacado);
	void atacar(IPersonajeEquipoVillano personaje);
	void recibirAtaque(int poderBase,int danio);
	void mover(Coordenada nuevaCoordenada);

	Coordenada obtenerUbicacion();
	int getVida();
	boolean vidaMenor30porc();
	void terminoTurno();
	void consumir(Consumible consumible);
	void transformar();
	void transformar(IJugadorEquipoZ equipo);
	void ataqueEspecial(IPersonaje atacado);
	String getNombreEstado();
	boolean personajeVivo();
}
