package AtaquesEspecialesTest;

import org.junit.Test;

import modelo.excepciones.PersonajeInhabilitadoException;
import modelo.juego.JugadorEquipoVillano;
import modelo.juego.JugadorEquipoZ;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.personajes.Cell;
import modelo.personajes.Goku;
import modelo.personajes.MajinBoo;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;

public class AtaquesEspecialesTest {
	@Test
	public void cellAbsorberVidaVerificaDanioYCuracion() {

		Cell cell = new Cell(new Coordenada(1,1));
		Goku goku = new Goku(new Coordenada(2,1));

		for(int i = 0; i < 20; i ++){
			cell.terminoTurno();
		}
		cell.ataqueEspecial(goku);

		org.junit.Assert.assertEquals(cell.getVida(), 520);
		org.junit.Assert.assertEquals(goku.getVida(), 480);
		
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

		org.junit.Assert.assertEquals(majinBoo.getVida(), 281);
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
		
		org.junit.Assert.assertEquals(majinBoo.getVida(), 284);
	}
}
