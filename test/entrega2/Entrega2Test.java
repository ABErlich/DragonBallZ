package entrega2;

import org.junit.Test;

import modelo.personajes.*;
import modelo.excepciones.*;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.juego.JugadorEquipoZ;
import modelo.juego.JugadorEquipoVillano;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;


public class Entrega2Test {

	@Test(expected=NoPuedeTransformarException.class)
	public void test1TransformarGohanFalla() {
		Tablero tablero = new Tablero(10); 
		IJugadorEquipoZ equipo = new JugadorEquipoZ(tablero);
		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		gohan.transformar(equipo);
		gohan.transformar(equipo);
	}

	@Test
	public void test1TransformarGohanASayajin2(){
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
	public void test2TransformarPiccoloFalla() {
		Tablero tablero = new Tablero(10);
		IJugadorEquipoZ equipo = new JugadorEquipoZ(tablero);
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");
		piccolo.transformar(equipo);
	}
	
	@Test
	public void test2TransformarPiccolo(){
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
	public void test3TransformarCellFalla() {
		Tablero tablero = new Tablero(10);
		IJugadorEquipo equipo = new JugadorEquipoVillano(tablero);
		Cell cell = (Cell) equipo.getPersonaje("Cell");

		cell.transformar();
	}
	
	@Test
	public void test3CellAbsorberVida() {

		Cell cell = new Cell(new Coordenada(1,1));
		Goku goku = new Goku(new Coordenada(2,1));

		for(int i = 0; i < 20; i ++){
			cell.terminoTurno();
		}
		cell.absorber(goku);

		org.junit.Assert.assertEquals(cell.getVida(), 520);
		org.junit.Assert.assertEquals(goku.getVida(), 480);
		
	}
	
	@Test
	public void test3TransformarCell() {

		Cell cell = new Cell(new Coordenada(3,4));
		Goku goku = new Goku(new Coordenada(3,3));
		Gohan gohan = new Gohan(new Coordenada(1,4));

		for(int i = 0; i < 20; i ++){
			cell.terminoTurno();
		}
		
		cell.absorber(goku);
		cell.absorber(goku);
		cell.absorber(goku);
		cell.absorber(goku);
		cell.transformar();
		cell.atacar(gohan);

		org.junit.Assert.assertEquals(gohan.getVida(), 260);
	}
	
	@Test(expected=PersonajeInhabilitadoException.class)
	public void test4MajinBooChocolate() {

		MajinBoo majinBoo = new MajinBoo(new Coordenada(4,4));
		Goku goku = new Goku(new Coordenada(5,5));
		
		for(int i = 0; i < 20; i ++){
			majinBoo.terminoTurno();
		}
		majinBoo.convierteEnChocolate(goku);

		goku.atacar(majinBoo);
		
	}

	public void test5EspecialGoku() {
		Tablero tablero = new Tablero(10);
		IJugadorEquipo equipoV = new JugadorEquipoVillano(tablero);
		IJugadorEquipo equipoZ= new JugadorEquipoZ(tablero);
		MajinBoo majinBoo = (MajinBoo) equipoV.getPersonaje("MajinBoo");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");

		for(int i = 0; i < 15; i ++){
			majinBoo.atacar(goku);
		}

		goku.atacar(majinBoo);

		org.junit.Assert.assertEquals(majinBoo.getVida(), 276);
	}
	

}
