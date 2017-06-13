package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.MajinBooEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;

public class MajinBoo extends Personaje implements IPersonajeEquipoVillano {

    public MajinBoo (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new MajinBooEstadoNormal(stats);

    }

    /*

    public void convierteEnChocolate(){
        ki = ki - 30;
    }
    */
}

