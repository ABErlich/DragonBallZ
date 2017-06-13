package entrega2;

import org.junit.Test;

import modelo.tablero.*;
import modelo.personajes.*;
import modelo.personajes.estados.GokuEstadoKaioKen;
import modelo.excepciones.*;
import modelo.juego.Juego;
import modelo.juego.Jugador;

/*
public class Entrega2Test {

	
	@Test(expected=NoPuedeTransformarException.class)
	public void test1TransformarGohanFalla() {
		IJugadorEquipo equipo = new JugadorEquipoZ();
		Gohan gohan = equipo.getPersonaje("Gohan");
		gohan.transformar(new GohanEstadoSuperSayajinFase1());
		gohan.transformar();
		org.junit.Assert.assertEquals(gohan.obtenerEstado().getClass(), GohanEstadoSuperSayajinFase2.class);
	}
	
	@Test
	public void test1TransformarGohan(){
		IJugadorEquipo equipo = new JugadorEquipoZ();

		Gohan gohan = equipo.getPersonaje("Gohan");
		Goku goku = equipo.getPersonaje("Goku");
		Piccolo piccolo = equipo.getPersonaje("Piccolo");

		goku.setVida(10);
		piccolo.setVida(10);

		gohan.transformar(new GohanEstadoSuperSayajinFase1());
		gohan.transformar();
	}

	@Test(expected=NoPuedeTransformarException.class)
	public void test2TransformarPiccoloFalla() {
		IJugadorEquipo equipo = new JugadorEquipoZ();
		Piccolo piccolo = equipo.getPersonaje("Piccolo");
		piccolo.transformar(new PiccoloEstadoFortalecido());
		piccolo.transformar();
	}
	
	@Test
	public void test2TransformarPiccolo(){
		IJugadorEquipo equipo = new JugadorEquipoZ();

		Gohan gohan = equipo.getPersonaje("Gohan");
		Piccolo piccolo = equipo.getPersonaje("Piccolo");

		gohan.setVida(10);

		piccolo.transformar(new PiccoloEstadoFortalecido());
		piccolo.transformar();
		org.junit.Assert.assertEquals(piccolo.obtenerEstado().getClass(), PiccoloEstadoProtector.class);

	}

	@Test(expected=NoPuedeTransformarException.class)
	public void test3TransformarCellFalla() {
		IJugadorEquipo equipo = new JugadorEquipoVillano();
		Cell cell = equipo.getPersonaje("Cell");

		cell.transformar();
		
	}

	@Test
	public void test3CellAbsorberVida() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		Cell cell = equipoV.getPersonaje("Cell");
		Goku goku = equipoZ.getPersonaje("Goku");

		cell.setKi(50);
		cell.absorber(goku);

		org.junit.Assert.assertEquals(cell.getVida(), 520);
		org.junit.Assert.assertEquals(goku.getVida(), 480);
		
	}

	@Test
	public void test3TransformarCell() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		Cell cell = equipoV.getPersonaje("Cell");
		Goku goku = equipoZ.getPersonaje("Goku");

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
		MajinBoo majinBoo = equipoV.getPersonaje("MajinBoo");
		Goku goku = equipoZ.getPersonaje("Goku");

		majinBoo.convierteEnChocolate(goku);

		goku.atacar(majinBoo);
		
	}

	public void test5EspecialGoku() {
		IJugadorEquipo equipoV = new JugadorEquipoVillano();
		IJugadorEquipo equipoZ= new JugadorEquipoZ();
		MajinBoo majinBoo = equipoV.getPersonaje("MajinBoo");
		Goku goku = equipoZ.getPersonaje("Goku");

		goku.setVida(10);
		goku.atacar(majinBoo);

		org.junit.Assert.assertEquals(majinBoo.getVida(), 276);
	}
	
	

}
*/