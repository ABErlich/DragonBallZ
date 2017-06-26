package AtaquesEspecialesTest;

import org.junit.Test;

import DBZ.modelo.excepciones.PersonajeInhabilitadoException;
import DBZ.modelo.personajes.Cell;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.personajes.MajinBoo;
import DBZ.modelo.tablero.Coordenada;
import static org.junit.Assert.assertEquals;

public class AtaquesEspecialesTest {
	@Test
	public void cellAbsorberVidaVerificaDanioYCuracion() {

		Cell cell = new Cell(new Coordenada(1,1));
		Goku goku = new Goku(new Coordenada(2,1));

		for(int i = 0; i < 20; i ++){
			cell.terminoTurno();
		}
		cell.ataqueEspecial(goku);

		assertEquals(cell.getVida(), 520);
		assertEquals(goku.getVida(), 480);

	}

	@Test(expected=PersonajeInhabilitadoException.class)
	public void majinBooConvierteGokuAChocolate() {

		MajinBoo majinBoo = new MajinBoo(new Coordenada(4,4));
		Goku goku = new Goku(new Coordenada(5,5));

		for(int i = 0; i < 20; i ++){
			majinBoo.terminoTurno();
		}
		majinBoo.ataqueEspecial(goku);

		goku.atacar(majinBoo);

	}
	@Test
	public void estadoEspecialGokuPocaVidaPega20porcMasDanio() {

		MajinBoo majinBoo = new MajinBoo(new Coordenada(4,4));
		Goku goku = new Goku(new Coordenada(5,5));

		for(int i = 0; i < 15; i ++){
			majinBoo.atacar(goku);
		}

		goku.atacar(majinBoo);

		assertEquals(majinBoo.getVida(), 281);
	}

	@Test
	public void estadoConvertidoChocolateExpiraLuegoDe3turnos(){
		MajinBoo majinBoo = new MajinBoo(new Coordenada(2,2));
		Goku goku = new Goku(new Coordenada(1,1));

		for(int i = 0 ; i < 10; i++){
			majinBoo.terminoTurno();
		}
		majinBoo.ataqueEspecial(goku);

		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();

		goku.atacar(majinBoo);

		assertEquals(majinBoo.getVida(), 284);
	}
}
