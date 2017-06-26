package MovimientosTest;

import DBZ.modelo.personajes.Freezer;
import DBZ.modelo.tablero.Tablero;
import org.junit.Test;

import DBZ.modelo.excepciones.MovimientoFueraRangoException;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.tablero.Coordenada;

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

	@Test
	public void FreezerPasaPorArribaDeGokuYLoAtaca(){
		Tablero tablero = new Tablero(3);
		Goku goku = new Goku(new Coordenada(1,2));
		Freezer freezer = new Freezer(new Coordenada(1,1));

		tablero.agregarPersonaje(goku);
		tablero.agregarPersonaje(freezer);

		tablero.moverPersonaje(freezer, new Coordenada(1,3));
		freezer.atacar(goku);

		org.junit.Assert.assertEquals(goku.getVida(), 480);
	}

}
