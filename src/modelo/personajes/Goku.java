package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.Estado;
import modelo.personajes.estados.GokuEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.PersonajeEquipoZ;

public class Goku extends PersonajeEquipoZ {
	
    public Goku (Coordenada pCoordeanda){
    	super(pCoordeanda);
    	this.estado = new GokuEstadoNormal(ubicacion);
    }

    /*

    public void kamehameha(){
        ki = ki - 20;
        poder = 30;
    }
     */
	public void transformar(Estado pEstado) {
		this.estado = pEstado;
	}
}

