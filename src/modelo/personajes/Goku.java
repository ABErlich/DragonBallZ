package modelo.personajes;

import modelo.personajes.Personaje;
import modelo.personajes.estados.Estado;
import modelo.personajes.estados.GokuEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.IPersonajeEquipoZ;

public class Goku extends Personaje implements IPersonajeEquipoZ {
	
    public Goku (Coordenada pCoordeanda){
    	super(pCoordeanda);
    	this.estado = new GokuEstadoNormal();
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

