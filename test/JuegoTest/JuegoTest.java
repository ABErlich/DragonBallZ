package JuegoTest;

import org.junit.Test;
import DBZ.modelo.excepciones.HayJugadoresSinEquipoException;
import DBZ.modelo.excepciones.JugadoresNoSeleccionadosException;
import DBZ.modelo.juego.Juego;
import DBZ.modelo.juego.Jugador;
import DBZ.modelo.personajes.interfaces.IPersonaje;
import DBZ.modelo.tablero.Coordenada;

public class JuegoTest {
	@Test
	public void creaJuegoCon2JugadoresYAsignaEquipos(){
		Juego juego = new Juego(10);
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");

		juego.agregarJugadorZ(jugador1);
		juego.agregarJugadorVillano(jugador2);

		org.junit.Assert.assertEquals(3, juego.cantidadPersonajesVivos(jugador1));
		org.junit.Assert.assertEquals(3, juego.cantidadPersonajesVivos(jugador2));
	}

	@Test(expected=JugadoresNoSeleccionadosException.class)
	public void creaJuegoSinJugadoresLanzaExcepcion(){
		Juego juego = new Juego(10);
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Roman");

		juego.comenzarJuego();

	}

	@Test
	public void creaJuegoCon2JugadoresYJuegaUnaRonda(){
		Juego juego = new Juego(10);
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");

		juego.agregarJugadorZ(jugador1);
		juego.agregarJugadorVillano(jugador2);

		Jugador jugadorActual = juego.comenzarJuego();
		IPersonaje pj;
		if(jugadorActual == jugador1){
			pj = jugadorActual.getPersonaje("Goku");
			juego.moverPersonaje(pj, new Coordenada(2,2));
			juego.terminarTurno();
			org.junit.Assert.assertEquals(pj.obtenerUbicacion(), new Coordenada(2,2));
		}else{
			pj = jugadorActual.getPersonaje("Cell");
			juego.moverPersonaje(pj, new Coordenada(8,8));
			juego.terminarTurno();
			org.junit.Assert.assertEquals(pj.obtenerUbicacion(), new Coordenada(8,8));
		}

	}

}
