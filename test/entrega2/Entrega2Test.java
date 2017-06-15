package entrega2;

import org.junit.Test;

import modelo.personajes.*;
import modelo.excepciones.*;
import modelo.juego.interfaces.IJugadorEquipo;
import modelo.juego.JugadorEquipoZ;
import modelo.juego.JugadorEquipoVillano;
import modelo.personajes.estados.*;


public class Entrega2Test {

	
	@Test(expected=NoPuedeTransformarException.class)
	public void test1TransformarGohanFalla() {
		IJugadorEquipo equipo = new JugadorEquipoZ();
		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		gohan.transformar(new GohanEstadoSuperSayajinFase1(gohan.getStats()));
		gohan.transformar(equipo);
	}

	
	@Test
	public void test1TransformarGohan(){
		IJugadorEquipo equipo = new JugadorEquipoZ();

		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		Goku goku = (Goku) equipo.getPersonaje("Goku");
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");

		goku.setVida(10);
		piccolo.setVida(10);

		gohan.transformar(new GohanEstadoSuperSayajinFase1(gohan.getStats()));
		gohan.setKi(50);
		gohan.transformar(equipo);
		org.junit.Assert.assertEquals(gohan.obtenerEstado().getClass(), GohanEstadoSuperSayajinFase2.class);
	}

	
	@Test(expected=NoPuedeTransformarException.class)
	public void test2TransformarPiccoloFalla() {
		IJugadorEquipo equipo = new JugadorEquipoZ();
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");
		piccolo.transformar(new PiccoloEstadoFortalecido(piccolo.getStats()));
		piccolo.transformar();
	}
	
	@Test
	public void test2TransformarPiccolo(){
		IJugadorEquipo equipo = new JugadorEquipoZ();

		Gohan gohan = (Gohan) equipo.getPersonaje("Gohan");
		Piccolo piccolo = (Piccolo) equipo.getPersonaje("Piccolo");

		gohan.setVida(10);

		piccolo.transformar(new PiccoloEstadoFortalecido(piccolo.getStats()));
		piccolo.transformar(equipo);
		org.junit.Assert.assertEquals(piccolo.obtenerEstado().getClass(), PiccoloEstadoProtector.class);

	}
	
	@Test(expected=NoPuedeTransformarException.class)
	public void test3TransformarCellFalla() {
		IJugadorEquipo equipo = new JugadorEquipoVillano();
		Cell cell = (Cell) equipo.getPersonaje("Cell");

		cell.transformar();
	}
	
	@Test
	public void test3CellAbsorberVida() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ = new JugadorEquipoZ();
		Cell cell = (Cell) equipoV.getPersonaje("Cell");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");

		cell.setKi(50);
		cell.absorber(goku);

		org.junit.Assert.assertEquals(cell.getVida(), 520);
		org.junit.Assert.assertEquals(goku.getVida(), 480);
		
	}
	
	@Test
	public void test3TransformarCell() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		Cell cell = (Cell) equipoV.getPersonaje("Cell");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");

		cell.setKi(50);
		cell.absorber(goku);
		cell.absorber(goku);
		cell.absorber(goku);
		cell.absorber(goku);
		cell.transformar();

		org.junit.Assert.assertEquals(cell.obtenerEstado().getClass(), CellEstadoSemiPerfecto.class);
	}
	
	@Test(expected=PersonajeInhabilitadoException.class)
	public void test4MajinBooChocolate() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		MajinBoo majinBoo = (MajinBoo) equipoV.getPersonaje("MajinBoo");
		Goku goku = (Goku) equipoZ.getPersonaje("Goku");
		
		majinBoo.setKi(50);
		majinBoo.convierteEnChocolate(goku);

		goku.Atacar(majinBoo);
		
	}
	/*
	public void test5EspecialGoku() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		Personaje majinBoo = equipoV.getPersonaje("MajinBoo");
		Personaje goku = equipoZ.getPersonaje("Goku");

		goku.setVida(10);
		goku.atacar(majinBoo);

		org.junit.Assert.assertEquals(majinBoo.getVida(), 276);
	}
	
	*/
}
