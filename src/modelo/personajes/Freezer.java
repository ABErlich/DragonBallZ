package modelo.personajes;

import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.NoPuedeTransformarException;
import modelo.personajes.Personaje;
import modelo.personajes.estados.FreezerEstadoDefinitivo;
import modelo.personajes.estados.FreezerEstadoNormal;
import modelo.personajes.estados.FreezerEstadoSegundaForma;
import modelo.tablero.Coordenada;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class Freezer extends Personaje implements IPersonajeEquipoVillano {

    public Freezer (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new FreezerEstadoNormal(stats);

    }

    public void rayoMortal(IPersonajeEquipoZ pPersonaje){
    	if(this.stats.getKi() < 20){
    		throw new NoPuedeRealizarAtaqueException();
    	}else{
    		this.stats.setKi(this.stats.getKi() - 20);
    		pPersonaje.setVida( (int) (pPersonaje.getVida() - this.stats.getPoder()*1.5) );
    	}
        
    }
    
    public void rayoMortal(IPersonajeEquipoVillano pPersonaje){
        throw new AtaqueMismoEquipoException();
    }
    
    @Override
    public void transformar(){
        if(this.estado instanceof FreezerEstadoNormal && this.stats.getKi() > 20){
        	this.stats.setKi(this.stats.getKi() - 20);
            this.estado = new FreezerEstadoSegundaForma(this.stats);
        }else if(this.estado instanceof FreezerEstadoSegundaForma && this.stats.getKi() > 50){
        	this.stats.setKi(this.stats.getKi() - 50);
            this.estado = new FreezerEstadoDefinitivo(this.stats);
        }else{
            throw new NoPuedeTransformarException();
        }
    }

    
}

