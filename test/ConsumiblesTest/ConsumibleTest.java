package ConsumiblesTest;

import org.junit.Test;

import DBZ.modelo.personajes.Freezer;
import DBZ.modelo.personajes.Goku;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.EsferaDelDragon;
import DBZ.modelo.tablero.NubeVoladora;
import DBZ.modelo.tablero.SemilladelHermitano;
import DBZ.modelo.tablero.Tablero;

public class ConsumibleTest {
	@Test
	public void semillaAlPisarEntrega100Vida(){
		Tablero tablero = new Tablero(10);
		SemilladelHermitano semilla = new SemilladelHermitano();
		Goku goku = new Goku(new Coordenada(1,1));

		tablero.agregarPersonaje(goku);
		tablero.agregarConsumible(semilla, new Coordenada(3,3));

		tablero.moverPersonaje(goku, new Coordenada(3,3));
		goku.mover(new Coordenada(3,3));


		org.junit.Assert.assertEquals(goku.getVida(), 600);
	}

	@Test
	public void semillaDesapareceAlPisarla(){
		Tablero tablero = new Tablero(10);
		SemilladelHermitano semilla = new SemilladelHermitano();
		Goku goku = new Goku(new Coordenada(1,1));

		tablero.agregarPersonaje(goku);
		tablero.agregarConsumible(semilla, new Coordenada(3,3));

		tablero.moverPersonaje(goku, new Coordenada(3,3));

		org.junit.Assert.assertEquals(semilla.estaConsumido(), true);
	}

	@Test
	public void consumirEsferaDragonOtorgaMasAtaque(){
		Tablero tablero = new Tablero(10);
		EsferaDelDragon esfera = new EsferaDelDragon();
		Goku goku = new Goku(new Coordenada(1,1));
		Freezer freezer = new Freezer(new Coordenada(2,2));

		tablero.agregarPersonaje(goku);
		tablero.agregarConsumible(esfera, new Coordenada(3,3));

		tablero.moverPersonaje(goku,new Coordenada(3,3));

		goku.atacar(freezer);

		org.junit.Assert.assertEquals(freezer.getVida(), 375);
	}

	@Test
	public void consumirNubeVoladoraOtorgaMasVelocidad(){
		Tablero tablero = new Tablero(10);
		NubeVoladora nube = new NubeVoladora();
		Goku goku = new Goku(new Coordenada(1,1));

		tablero.agregarPersonaje(goku);
		tablero.agregarConsumible(nube, new Coordenada(3,3));

		tablero.moverPersonaje(goku, new Coordenada(3,3));

		tablero.moverPersonaje(goku, new Coordenada(7,7));

		org.junit.Assert.assertEquals(goku.obtenerUbicacion(), new Coordenada(7,7));
	}

}
