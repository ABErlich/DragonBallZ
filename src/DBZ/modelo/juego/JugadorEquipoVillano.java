package DBZ.modelo.juego;

import DBZ.modelo.juego.interfaces.IJugadorEquipoVillano;

import DBZ.modelo.juego.JugadorEquipo;
import DBZ.modelo.tablero.Coordenada;
import DBZ.modelo.tablero.Tablero;
import DBZ.modelo.personajes.Cell;
import DBZ.modelo.personajes.Freezer;
import DBZ.modelo.personajes.MajinBoo;

public class JugadorEquipoVillano extends JugadorEquipo implements IJugadorEquipoVillano {

    public JugadorEquipoVillano(Tablero tablero){

    	int tamaniotablero = tablero.getTamanio();

        this.personajes.put("Cell", new Cell(new Coordenada(tamaniotablero-3,tamaniotablero-1)));
        this.personajes.put("Freezer", new Freezer(new Coordenada(tamaniotablero-2,tamaniotablero-1)));
        this.personajes.put("MajinBoo", new MajinBoo(new Coordenada(tamaniotablero-1,tamaniotablero-1)));
    }




}
