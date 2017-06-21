package TableroTest;

import org.junit.Test;
import modelo.tablero.Celda;
import modelo.tablero.Coordenada;

public class TableroTest {

    @Test
    public void ocupoUnaCeldayVerificoQueEstaOcupada(){
        Coordenada coordenada = new Coordenada(2,3);
        Celda celda = new Celda(coordenada);

        celda.ocupar();

        org.junit.Assert.assertTrue(celda.estaOcupada());
    }



    @Test
    public void calculoLaDistanciaEntreDosCeldasYesCuatro(){
        Coordenada coordenada = new Coordenada (1,3);
        Coordenada coordenada2 = new Coordenada (5, 2);

        org.junit.Assert.assertEquals(4, coordenada.calcularDistancia(coordenada2));
    }

}
