package entrega2;

import org.junit.Test;

import modelo.personajes.*;
import modelo.excepciones.*;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.juego.JugadorEquipoZ;
import modelo.juego.JugadorEquipoVillano;
import modelo.tablero.Coordenada;


public class Entrega2Test {

	@Test(expected=NoPuedeTransformarException.class)
	public void transformarGohanFallaPorFaltaDeKi() {
		IJugadorEquipoZ equipo = new JugadorEquipoZ();
		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		gohan.transformar(equipo);
	}

	@Test
	public void transformarGohanASayajin2LuegoAtacaCon100Danio(){
		IJugadorEquipoZ equipo = new JugadorEquipoZ();

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
	public void transformarPiccoloFallaGohanConMasDel30PorcDeVida() {
		IJugadorEquipoZ equipo = new JugadorEquipoZ();
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");
		piccolo.transformar(equipo);
	}
	
	@Test
	public void transformarPiccoloLuegoAtacaCon60Danio(){
		IJugadorEquipoZ equipo = new JugadorEquipoZ();

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
	public void transformarCellFallaFaltanAbsorciones() {
		IJugadorEquipo equipo = new JugadorEquipoVillano();
		Cell cell = (Cell) equipo.getPersonaje("Cell");

		cell.transformar();
	}
	
	@Test
	public void cellAbsorberVida() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ = new JugadorEquipoZ();
		Cell cell = (Cell) equipoV.getPersonaje("Cell");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");

		for(int i = 0; i < 20; i ++){
			cell.terminoTurno();
		}
		cell.absorber(goku);

		org.junit.Assert.assertEquals(cell.getVida(), 520);
		org.junit.Assert.assertEquals(goku.getVida(), 480);
		
	}
	
	@Test
	public void transformarCellLuegoDeAbsorberAtacaCon40Danio() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		Cell cell = (Cell) equipoV.getPersonaje("Cell");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");
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
	public void majinBooConvierteChocolateAGokuInhabilitadoExcepcion() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		MajinBoo majinBoo = (MajinBoo) equipoV.getPersonaje("MajinBoo");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");
		
		for(int i = 0; i < 20; i ++){
			majinBoo.terminoTurno();
		}
		majinBoo.convierteEnChocolate(goku);

		goku.atacar(majinBoo);
		
	}

	public void estadoEspecialDeGokuConMenosDel30porcDeVida() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		MajinBoo majinBoo = (MajinBoo) equipoV.getPersonaje("MajinBoo");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");

		for(int i = 0; i < 15; i ++){
			majinBoo.atacar(goku);
		}

		goku.atacar(majinBoo);

		org.junit.Assert.assertEquals(majinBoo.getVida(), 276);
	}
	

}
