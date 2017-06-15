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
	public void test2ConsumirSemilla(){
		Tablero tablero = new Tablero(10);
		SemilladelHermitano semilla = new SemilladelHermitano(new Coordenada(3,3));
		Goku goku = new Goku(new Coordenada(1,1));
		
		tablero.agregarUbicable(goku);
		tablero.agregarUbicable(semilla);
		
		goku.Mover(new Coordenada(3,3));
		org.junit.Assert.assertEquals(semilla, null);
	}
	*/
}
