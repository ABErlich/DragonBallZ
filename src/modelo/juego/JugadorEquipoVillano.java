package modelo.juego;

import modelo.juego.interfaces.IJugadorEquipoVillano;
import modelo.juego.JugadorEquipo;
import modelo.tablero.Coordenada;
import modelo.tablero.Tablero;
import modelo.personajes.Cell;
import modelo.personajes.Freezer;
import modelo.personajes.MajinBoo;

public class JugadorEquipoVillano extends JugadorEquipo implements IJugadorEquipoVillano {
	
    public JugadorEquipoVillano(Tablero tablero){
    	
    	int tamaniotablero = tablero.getTamanio(); 
    	
        this.personajes.put("Cell", new Cell(new Coordenada(tamaniotablero-1,tamaniotablero-1)));
        this.personajes.put("Freezer", new Freezer(new Coordenada(tamaniotablero-2,tamaniotablero-1)));
        this.personajes.put("MajinBoo", new MajinBoo(new Coordenada(tamaniotablero-3,tamaniotablero-1)));
    }
    

}
