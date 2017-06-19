package AtaquesTest;

import org.junit.Test;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.Cell;
import modelo.personajes.Gohan;
import modelo.personajes.Goku;
import modelo.tablero.Coordenada;

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
