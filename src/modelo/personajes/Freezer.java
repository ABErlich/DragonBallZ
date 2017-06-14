package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.FreezerEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;

public class Freezer extends Personaje implements IPersonajeEquipoVillano {

    public Freezer (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new FreezerEstadoNormal(stats);

    }
    public void transformar(){}
    /*

    public void rayoMortal(){
        ki = ki - 20;
        poder = 30;
    }
    */
}

