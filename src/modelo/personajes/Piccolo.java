package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.PiccoloEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;

public class Piccolo extends Personaje implements IPersonajeEquipoVillano {

    public Piccolo (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new PiccoloEstadoNormal(stats);

    }

    public void transformar(){}
    /*

    public void makankosappo(){
        ki = ki - 10;
        poder = 31; //Deberia ser 31.25, pero por ser int y no float se tomo el valor mas proximo.
    }
    */
}

