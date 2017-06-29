package DBZ;

import org.junit.Test;

import DBZ.modelo.excepciones.AtaqueFueraDeRangoException;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.personajes.Cell;
import DBZ.modelo.personajes.Gohan;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.tablero.Coordenada;

public class AtaquesTest {

	@Test
	public void gokuAtacaACellCon20Danio(){

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

	@Test(expected=AtaqueFueraDeRangoException.class)
	public void ataqueFueraRangoLanzaExcepcion(){

		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(5,5));

		goku.atacar(cell);
	}
}
