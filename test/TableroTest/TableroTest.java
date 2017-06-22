package TableroTest;

import modelo.personajes.Cell;
import modelo.personajes.Goku;
import modelo.tablero.*;
import org.junit.Test;

public class TableroTest {

    @Test
    public void ocupoUnaCeldayVerificoQueEstaOcupada(){
        Coordenada coordenada = new Coordenada(2,3);
        Celda celda = new Celda(coordenada);

        celda.ocupar();

        org.junit.Assert.assertTrue(celda.estaOcupada());
    }

    @Test
    public void calculoLaDistanciaEntreDosCoordenadasYesCuatro(){
        Coordenada coordenada = new Coordenada (1,3);
        Coordenada coordenada2 = new Coordenada (5, 2);

        org.junit.Assert.assertEquals(4, coordenada.calcularDistancia(coordenada2));
    }


    @Test
    public void agregoConsumibleYverificoQueAlUsarloDesaparece(){
        Tablero tablero = new Tablero(3);
        SemilladelHermitano semilla = new SemilladelHermitano();
        Goku goku = new Goku(new Coordenada(1,1));
        Cell cell = new Cell(new Coordenada(3,3));

        tablero.agregarPersonaje(goku);
        tablero.agregarPersonaje(cell);
        tablero.agregarConsumible(semilla, new Coordenada(2,2));

        tablero.moverPersonaje(goku, new Coordenada(2,2));
        tablero.moverPersonaje(goku, new Coordenada(1,2));
        tablero.moverPersonaje(cell, new Coordenada(2,2));

        org.junit.Assert.assertEquals(cell.getVida(), 500);

    }
}
