package MovimientosTest;

import org.junit.Test;

import modelo.excepciones.MovimientoFueraRangoException;
import modelo.personajes.Goku;
import modelo.tablero.Coordenada;

public class MovimientosTest {
	
	@Test
	public void ubicarAGoku() {

		Goku goku = new Goku(new Coordenada(1,1));
		
		goku.ubicar(new Coordenada(1,1));
		
		org.junit.Assert.assertEquals(new Coordenada(1,1), goku.obtenerUbicacion());
	}

	@Test
	public void moverAGoku() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.mover(new Coordenada(3,3));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}
	
	@Test(expected=MovimientoFueraRangoException.class)
	public void moverAGokuRangoInalcanzableLanzaExcepcion() {

		Goku goku = new Goku(new Coordenada(1,1));

		goku.mover(new Coordenada(5,5));
		
		org.junit.Assert.assertEquals(new Coordenada(3, 3), goku.obtenerUbicacion());
	}
}
