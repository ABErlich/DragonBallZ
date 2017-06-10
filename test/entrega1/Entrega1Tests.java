package entrega1;

import org.junit.Test;

import modelo.tablero.*;
import modelo.personajes.*;
import modelo.personajes.estados.EstadoKaioKen;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;

public class Entrega1Tests {

	@Test
	public void test1ColocarYMoverAGoku() {

		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(tablero);
		
		try {
			goku.Ubicar(new Coordenada(1,1));
			goku.Mover(new Coordenada(3,3));
		} catch (CeldaNoExisteException e) {

		} catch (CeldaOcupadaException e){
			
		}
		
		Coordenada coord = tablero.obtenerUbicacion(goku);
		
		org.junit.Assert.assertEquals(3, coord.getCoordX());
	}
	
	@Test(expected=CeldaOcupadaException.class)
	public void test2Colocar2PersonajesMismaCelda() throws CeldaNoExisteException{
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan(tablero);
		
		goku.Ubicar(new Coordenada(1,1));
		gohan.Ubicar(new Coordenada(1,1));
		
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
		Goku goku = new Goku(tablero);
		try {
			goku.Ubicar(new Coordenada(1,1));
			goku.Mover(new Coordenada(4,4));
		} catch (CeldaNoExisteException e) {

		}
		
		Coordenada coord = tablero.obtenerUbicacion(goku);
		
		org.junit.Assert.assertEquals(4, coord.getCoordX());;
		
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
