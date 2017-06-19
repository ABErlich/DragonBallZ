package entrega1;

import org.junit.Test;

import modelo.tablero.*;
import modelo.personajes.*;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class Entrega1Test {

	@Test
	public void test1UbicarAGoku() {

		Goku goku = new Goku(new Coordenada(1,1));
		
		goku.ubicar(new Coordenada(1,1));
		
		org.junit.Assert.assertEquals(new Coordenada(1,1), goku.obtenerUbicacion());
	}

	@Test
	public void test1MoverAGoku() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.mover(new Coordenada(3,3));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=MovimientoFueraRangoException.class)
	public void test1MoverAGokuRangoInalcanzable() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.mover(new Coordenada(5,5));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=CeldaOcupadaException.class)
	public void test2Ubicar2PersonajesMismaCelda(){

		Tablero tablero = new Tablero(10);

		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1, 1));
		
		tablero.agregarPersonaje(goku);
		tablero.agregarPersonaje(gohan);
	}
	
	@Test
	public void test4TransformaPersonaje(){
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
	public void test5TransformaYMueve(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarPersonaje(goku);
		
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.transformar();
		goku.mover(new Coordenada(4,4));
		
		org.junit.Assert.assertEquals(new Coordenada(4,4), goku.obtenerUbicacion());;
		
	}
	
	@Test
	public void test6CrearJuego(){
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");
		
		juego.agregarJugador1(jugador1);
		juego.agregarJugador2(jugador2);
		juego.asignarEquipoZ(jugador1);
		juego.asignarEquipoVillano(jugador2);
		
		org.junit.Assert.assertEquals(3, juego.cantidadPersonajesVivos(jugador1));
		org.junit.Assert.assertEquals(3, juego.cantidadPersonajesVivos(jugador2));
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void test7AtaqueFueraRango(){

		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(5,5));
		
		goku.atacar(cell);
	}
	
	@Test
	public void test7AtaqueValido(){

		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(1,1));
		
		goku.atacar(cell);

		org.junit.Assert.assertEquals(480, cell.getVida());

	}
	
	@Test(expected=AtaqueMismoEquipoException.class)
	public void test7AtaqueMismoEquipo(){

		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1,1));
		
		goku.atacar(gohan);

		org.junit.Assert.assertEquals(480, gohan.getVida());

	}

}
