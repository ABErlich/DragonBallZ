package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.tablero.Coordenada;
import modelo.personajes.IPersonajeEquipoVillano;
import modelo.personajes.estados.CellEstadoNormal;

public class Cell extends Personaje implements IPersonajeEquipoVillano{
	
    public Cell (Coordenada pCoordenada){
    	super(pCoordenada);
        this.estado = new CellEstadoNormal(ubicacion);
    }
    

    /*
    public void semiPerfecto(){
        poder = 40;
        distanciaAtaque = 4;
        velocidadMov = 3;
    }

    public void perfecto(){
        poder = 80;
        distanciaAtaque  = 4;
        velocidadMov = 4;
    }

    public void absorber(){
        ki = ki - 5;
        vida = vida + 20;
    }
    */
}

