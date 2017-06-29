package DBZ;

import org.junit.Test;

import DBZ.modelo.excepciones.NoPuedeTransformarException;
import DBZ.modelo.juego.JugadorEquipoVillano;
import DBZ.modelo.juego.JugadorEquipoZ;
import DBZ.modelo.juego.interfaces.IJugadorEquipo;
import DBZ.modelo.juego.interfaces.IJugadorEquipoZ;
import DBZ.modelo.personajes.Cell;
import DBZ.modelo.personajes.Gohan;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.personajes.Piccolo;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.Tablero;

public class TransformacionesTest {
	@Test
	public void transformaAGokuAKaioKenYAtacaCon40Danio(){
		Goku goku = new Goku(new Coordenada(1,1));
		Cell cell = new Cell(new Coordenada(2,2));

		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.transformar();

		goku.atacar(cell);
		org.junit.Assert.assertEquals(cell.getVida(), 460);

	}
	@Test
	public void transformaAGokuYLoMueveVerificandoRango(){
		Tablero tablero = new Tablero(10);
		Goku goku = new Goku(new Coordenada(1,1));

		tablero.agregarPersonaje(goku);

		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.terminoTurno();
		goku.transformar();
		tablero.moverPersonaje(goku, new Coordenada(4,4));

		org.junit.Assert.assertEquals(new Coordenada(4,4), goku.obtenerUbicacion());;

	}

	@Test(expected=NoPuedeTransformarException.class)
	public void transformarGohanLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		IJugadorEquipoZ equipo = new JugadorEquipoZ(tablero);
		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		gohan.transformar(equipo);
		gohan.transformar(equipo);
	}

	@Test
	public void transformarGohanASayajin2YAtaca100Danio(){
		Tablero tablero = new Tablero(10);
		IJugadorEquipoZ equipo = new JugadorEquipoZ(tablero);

		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		Goku goku = (Goku) equipo.getPersonaje("Goku");
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");
		Cell cell = new Cell(new Coordenada(1,1));

		// PONER A GOKU Y PICCOLO CON POCA VIDA
		for(int i = 0; i < 20 ; i++){
			cell.atacar(goku);
			cell.atacar(piccolo);
		}


		for(int i = 0; i < 20; i ++){
			gohan.terminoTurno();
		}
		// transformo en Ssj1
		gohan.transformar(equipo);
		// transformo en Ssj1
		gohan.transformar(equipo);
		gohan.atacar(cell);

		org.junit.Assert.assertEquals(cell.getVida(), 400);
	}

	@Test(expected=NoPuedeTransformarException.class)
	public void transformarPiccoloLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		IJugadorEquipoZ equipo = new JugadorEquipoZ(tablero);
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");
		piccolo.transformar(equipo);
	}

	@Test
	public void transformarPiccoloAProtectorYAtaca60Danio(){
		Tablero tablero = new Tablero(10);
		IJugadorEquipoZ equipo = new JugadorEquipoZ(tablero);

		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");
		Cell cell = new Cell(new Coordenada(1,1));

		for(int i = 0; i < 20 ; i++){
			cell.atacar(gohan);
		}
		for(int i = 0; i < 20; i ++){
			piccolo.terminoTurno();
		}

		piccolo.transformar(equipo);
		piccolo.transformar(equipo);
		piccolo.atacar(cell);

		org.junit.Assert.assertEquals(cell.getVida(), 440);

	}

	@Test(expected=NoPuedeTransformarException.class)
	public void transformarCellLanzaExcepcion() {
		Tablero tablero = new Tablero(10);
		IJugadorEquipo equipo = new JugadorEquipoVillano(tablero);
		Cell cell = (Cell) equipo.getPersonaje("Cell");

		cell.transformar();
	}

	@Test
	public void transformarCellASemiPerfecto() {

		Cell cell = new Cell(new Coordenada(3,4));
		Goku goku = new Goku(new Coordenada(3,3));
		Gohan gohan = new Gohan(new Coordenada(1,4));

		for(int i = 0; i < 20; i ++){
			cell.terminoTurno();
		}

		cell.ataqueEspecial(goku);
		cell.ataqueEspecial(goku);
		cell.ataqueEspecial(goku);
		cell.ataqueEspecial(goku);
		cell.transformar();
		cell.atacar(gohan);

		org.junit.Assert.assertEquals(gohan.getVida(), 260);
	}
}
