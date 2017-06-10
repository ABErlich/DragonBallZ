package entrega1;

import org.junit.Test;

import modelo.tablero.*;
import modelo.personajes.*;
import modelo.personajes.estados.EstadoKaioKen;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class Entrega1Test {

	@Test
	public void test1UbicarYMoverAGoku() {

		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		
		goku.Ubicar(new Coordenada(1,1));
		
		org.junit.Assert.assertEquals(new Coordenada(1,1), goku.obtenerUbicacion());
	}

	@Test
	public void test2MoverAGoku() {

		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
	
		goku.Ubicar(new Coordenada(1,1));
		goku.Mover(new Coordenada(3,3));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}

	@Test(expected=CeldaOcupadaException.class)
	public void test2Ubicar2PersonajesMismaCelda(){
		Tablero tablero = new Tablero(10);

		Goku goku = new Goku(new Coordenada(1,1));
		Gohan gohan = new Gohan(new Coordenada(1, 1));
		
		tablero.agregarUbicable(goku);
		// aca salta la excepcion
		tablero.agregarUbicable(gohan);
	}
	
	@Test
	public void test4TransformaPersonaje(){
		Goku goku = new Goku();
		goku.transformar(new EstadoKaioKen());
		
		org.junit.Assert.assertTrue(goku.obtenerEstado() == "KaioKen");
	}
	
	@Test
	public void test5TransformaYMueve(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		goku.transformar(new EstadoKaioKen());
		goku.Mover(new Coordenada(4,4));
		
		org.junit.Assert.assertEquals(new Coordenada(4,4), goku.obtenerUbicacion());;
		
	}
	
	/*
	@Test
	public void test6CrearJuego(){
		Juego juego = new Juego();
		Jugador jugador1 = new Jugador();
		Jugador jugador2 = new Jugador();
		
		juego.AgregarJugador(jugador1);
		juego.AgregarJugador(jugador2);
		
		jugador1.asignarEquipo("GuerrerosZ");
		jugador2.asignarEquipo("Enemigos");
		
		org.junit.Assert.assertEquals(3, jugador1.cantidadPersonajesVivos());
		org.junit.Assert.assertEquals(3, jugador2.cantidadPersonajesVivos());
	}
	
	@Test(expected=AtaqueFueraDeRangoException.class)
	public void test7Ataque(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(tablero);
		Cell cell = new Cell(tablero);
		try{
			goku.Ubicar(new Coordenada(1,1));
			cell.Ubicar(new Coordenada(2,2));
			goku.Atacar(cell);
		} catch(Exception ex){
			
		}
		
		org.junit.Assert.assertEquals(480, cell.getVida());

		cell.Ubicar(new Coordenada(7,7));
		goku.Atacar(cell);

	}
	*/
	

}
