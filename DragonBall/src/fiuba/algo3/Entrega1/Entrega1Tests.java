package fiuba.algo3.Entrega1;

import org.junit.Test;

import fiuba.algo3.modelo.tablero.*;
import fiuba.algo3.modelo.personajes.*;
import fiuba.algo3.modelo.excepciones.*;

public class Entrega1Tests {

	@Test
	public void test1ColocarYMoverAGoku() {
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(tablero);
		
		goku.Ubicar(new Coordenada(1,1));
		goku.Mover(new Coordenada(3,3));
		
		Coordenada coord = tablero.obtenerPosicionDe(goku);
		
		org.junit.Assert.assertEquals(3, coord.getCoordX());
	}
	
	@Test(expected=CeldaOcupadaException.class)
	public void test2Colocar2PersonajesMismaCelda(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(tablero);
		Gohan gohan = new Gohan();
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
		Goku goku = new Goku();
		goku.Ubicar(new Coordenada(1,1));
		goku.Mover(new Coordenada(4,4));
		
		Coordenada coord = tablero.obtenerPosicionDe(goku);
		
		org.junit.Assert.assertEquals(4, coord.getCoordX());;
		
	}
	
	

}
