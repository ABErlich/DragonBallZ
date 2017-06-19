package entrega1;

import org.junit.Test;

import modelo.tablero.*;
import modelo.personajes.*;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class Entrega1Test {

	@Test
	public void ubicarAGokuEnCoordenada() {

		Goku goku = new Goku(new Coordenada(1,1));
		
		goku.ubicar(new Coordenada(1,1));
		
		org.junit.Assert.assertEquals(new Coordenada(1,1), goku.obtenerUbicacion());
	}

	@Test
	public void mueveAGokuDeUnaCoordAOtra() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.mover(new Coordenada(3,3));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=MovimientoFueraRangoException.class)
	public void mueveAGokuRangoInalcanzableYLanzaExcepcion() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.mover(new Coordenada(5,5));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=CeldaOcupadaException.class)
	public void ubicar2PersonajesMismaCeldaLanzaExcepcion(){

		Tablero tablero = new Tablero(10);

		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1, 1));
		
		tablero.agregarUbicable(goku);
		tablero.agregarUbicable(gohan);
	}
	
	@Test
	public void transformaAGokuLuegoAtacaCon40Danio(){
		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(2,2));
		
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.transformar();
		
		goku.atacar(cell);
		org.junit.Assert.assertEquals(cell.getVida(), 460);

	}
	
	@Test
	public void transformaAGokuYLuegoMueveConNuevoRango(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.transformar();
		goku.mover(new Coordenada(4,4));
		
		org.junit.Assert.assertEquals(new Coordenada(4,4), goku.obtenerUbicacion());;
		
	}
	
	@Test
	public void creaJuegoConDosJugadores(){
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");
		
		juego.agregarJugador1(jugador1);
		juego.agregarJugador2(jugador2);
		
		jugador1.asignarEquipoZ();
		jugador2.asignarEquipoVillano();
		
		org.junit.Assert.assertEquals(3, jugador1.cantidadPersonajesVivos());
		org.junit.Assert.assertEquals(3, jugador2.cantidadPersonajesVivos());
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void ataqueDeGokuFueraDeRangoLanzaExcepcion(){

		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(5,5));
		
		goku.atacar(cell);
	}
	
	@Test
	public void ataqueValidoDeGoku(){

		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(1,1));
		
		goku.atacar(cell);

		org.junit.Assert.assertEquals(480, cell.getVida());

	}
	
	@Test(expected=AtaqueMismoEquipoException.class)
	public void ataqueMismoEquipoLanzaExcepcion(){

		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1,1));
		
		goku.atacar(gohan);

		org.junit.Assert.assertEquals(480, gohan.getVida());

	}

}
