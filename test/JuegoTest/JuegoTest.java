package JuegoTest;

import org.junit.Test;
import modelo.excepciones.HayJugadoresSinEquipoException;
import modelo.excepciones.JugadoresNoSeleccionadosException;
import modelo.juego.Juego;
import modelo.juego.Jugador;
import modelo.personajes.interfaces.IPersonaje;
import modelo.tablero.Coordenada;

public class JuegoTest {
	@Test
	public void creaJuegoCon2JugadoresYAsignaEquipos(){
		Juego juego = new Juego(10);
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");
		
		juego.agregarJugador1(jugador1);
		juego.agregarJugador2(jugador2);
		juego.asignarEquipoZ(jugador1);
		juego.asignarEquipoVillano(jugador2);
		
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
	
	@Test(expected=HayJugadoresSinEquipoException.class)
	public void creaJuegoYComienzaSinAsignarEquiposLanzaExcepcion(){
		Juego juego = new Juego(10);
		Jugador jugador1 = new Jugador("Juan");
		Jugador jugador2 = new Jugador("Roman");
		
		juego.agregarJugador1(jugador1);
		juego.agregarJugador2(jugador2);
		juego.comenzarJuego();
	}
	
	@Test
	public void creaJuegoCon2JugadoresYJuegaUnaRonda(){
		Juego juego = new Juego(10);
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");
		
		juego.agregarJugador1(jugador1);
		juego.agregarJugador2(jugador2);
		juego.asignarEquipoZ(jugador1);
		juego.asignarEquipoVillano(jugador2);
		
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
