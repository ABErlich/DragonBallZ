package modelo.personajes;

import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.personajes.Personaje;
import modelo.personajes.estados.GokuEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Goku extends Personaje implements IPersonajeEquipoZ {
	
    public Goku (Coordenada pCoordeanda){
    	stats.setUbicacion(pCoordeanda);
    	this.estado = new GokuEstadoNormal(stats);
    }
    
    public void kamehameha(IPersonajeEquipoZ pPersonaje){
    	throw new AtaqueMismoEquipoException();
    }
    
    public void kamehameha(IPersonajeEquipoVillano pPersonaje){
    	if(this.stats.getKi() < 20){
    		throw new NoPuedeRealizarAtaqueException();
    	}else{
    		this.stats.setKi(this.stats.getKi() - 20);
    		if(this.stats.getVida() < 150){
    			pPersonaje.setVida( (int) (pPersonaje.getVida() - (this.stats.getPoder()*1.5)*1.2) );
    		}else{
    			pPersonaje.setVida( (int) (pPersonaje.getVida() - this.stats.getPoder()*1.5) );
    		}
    		
    	}
    }
    
	public void transformar(){}
}

