package entrega3;

import org.junit.Test;

import modelo.personajes.Goku;
import modelo.personajes.estados.GohanEstadoSuperSayajinFase2;
import modelo.tablero.*;


public class Entrega3Test {

	
	@Test
	public void test1UbicarSemilla() {
		SemilladelHermitano semilla = new SemilladelHermitano(new Coordenada(3,3));
		
		org.junit.Assert.assertEquals(semilla.obtenerUbicacion(), new Coordenada(3,3));
	}
	
	/*
	@Test
	public void test2SemillaDesapareceAlPisar(){
		Tablero tablero = new Tablero(10);
		SemilladelHermitano semilla = new SemilladelHermitano(new Coordenada(3,3));
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		tablero.agregarUbicable(semilla);
		
		goku.Mover(new Coordenada(3,3));
		tablero.actualizarPosiciones();

		org.junit.Assert.assertEquals(goku.getVida(), 600);
	}
	
	@Test
	public void test3ConsumirSemilla(){
		Tablero tablero = new Tablero(10);
		SemilladelHermitano semilla = new SemilladelHermitano(new Coordenada(3,3));
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		tablero.agregarUbicable(semilla);
		
		goku.Mover(new Coordenada(3,3));
		tablero.actualizarPosiciones();

		org.junit.Assert.assertEquals(semilla, null);
	}

	@Test
	public void test3ConsumirEsferaDragon(){
		Tablero tablero = new Tablero(10);
		EsferaDelDragon esfera = new EsferaDelDragon(new Coordenada(3,3));
		Goku goku = new Goku(new Coordenada(1,1));
		Freezer freezer = new Freezer(new Coordenada(2,2));
		
		tablero.agregarUbicable(goku);
		tablero.agregarUbicable(esfera);
		
		goku.Mover(new Coordenada(3,3));
		tablero.actualizarPosiciones();

		goku.atacar(freezer);

		org.junit.Assert.assertEquals(freezer.getVida(), 375);
	}
	
	@Test
	public void test3ConsumirNubeVoladora(){
		Tablero tablero = new Tablero(10);
		NubeVoladora nube = new NubeVoladora(new Coordenada(3,3));
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		tablero.agregarUbicable(nube);
		
		goku.Mover(new Coordenada(3,3));
		tablero.actualizarPosiciones();

		goku.Mover(new Coordenada(7,7));

		org.junit.Assert.assertEquals(goku.getUbicacion(), new Coordenada(7,7));
	}
	
	*/
	
}
