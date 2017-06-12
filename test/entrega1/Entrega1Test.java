package entrega1;

import org.junit.Test;

import modelo.tablero.*;
import modelo.personajes.*;
import modelo.personajes.estados.GokuEstadoKaioKen;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class Entrega1Test {

	@Test
	public void test1UbicarAGoku() {

		Goku goku = new Goku(new Coordenada(1,1));
		
		goku.Ubicar(new Coordenada(1,1));
		
		org.junit.Assert.assertEquals(new Coordenada(1,1), goku.obtenerUbicacion());
	}

	@Test
	public void test1MoverAGoku() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.Mover(new Coordenada(3,3));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=MovimientoFueraRangoException.class)
	public void test1MoverAGokuRangoInalcanzable() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.Mover(new Coordenada(5,5));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=CeldaOcupadaException.class)
	public void test2Ubicar2PersonajesMismaCelda(){
		// Crea un tablero de 10 x 10 celdas
		Tablero tablero = new Tablero(10);

		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1, 1));
		
		// Agrega ubicables al tablero
		tablero.agregarUbicable(goku);
		// aca salta la excepcion
		tablero.agregarUbicable(gohan);
	}
	
	@Test
	public void test4TransformaPersonaje(){
		Goku goku = new Goku(new Coordenada(1,1));
		goku.transformar(new GokuEstadoKaioKen(goku.obtenerUbicacion()));
		
		org.junit.Assert.assertEquals(goku.obtenerEstado().getClass(), GokuEstadoKaioKen.class);
	}
	
	@Test
	public void test5TransformaYMueve(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		goku.transformar(new GokuEstadoKaioKen(goku.obtenerUbicacion()));
		goku.Mover(new Coordenada(4,4));
		
		org.junit.Assert.assertEquals(new Coordenada(4,4), goku.obtenerUbicacion());;
		
	}
	
	
	@Test
	public void test6CrearJuego(){
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador("Jose");
		Jugador jugador2 = new Jugador("Pepe");
		
		juego.AgregarJugador(jugador1);
		juego.AgregarJugador(jugador2);
		
		jugador1.asignarEquipoZ();
		jugador2.asignarEquipoVillano();
		
		org.junit.Assert.assertEquals(3, jugador1.cantidadPersonajesVivos());
		org.junit.Assert.assertEquals(3, jugador2.cantidadPersonajesVivos());
	}
	
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void test7AtaqueFueraRango(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(5,5));
		
		goku.Atacar(cell);
	}
	
	@Test
	public void test7AtaqueValido(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(1,1));
		
		goku.Atacar(cell);

		org.junit.Assert.assertEquals(480, cell.getVida());

	}
	
	@Test(expected=AtaqueMismoEquipoException.class)
	public void test7AtaqueMismoEquipo(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1,1));
		
		goku.Atacar(gohan);

		org.junit.Assert.assertEquals(480, gohan.getVida());

	}

}
