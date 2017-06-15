package modelo.personajes;

import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.NoPuedeTransformarException;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.Personaje;
import modelo.personajes.estados.MajinBooEstadoNormal;
import modelo.tablero.Coordenada;
import modelo.personajes.estados.EstadoConvertidoEnChocolate;
import modelo.personajes.estados.MajinBooEstadoBooMalo;
import modelo.personajes.estados.MajinBooEstadoBooOriginal;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class MajinBoo extends Personaje implements IPersonajeEquipoVillano {

    public MajinBoo (Coordenada pCoordenada){
    	stats.setUbicacion(pCoordenada);
    	this.estado = new MajinBooEstadoNormal(stats);

    }

    public void convierteEnChocolate(IPersonajeEquipoZ pPersonaje){
        if(this.stats.getKi() < 30){
            throw new NoPuedeRealizarAtaqueException();
        }else{
            this.stats.setKi(this.stats.getKi() - 30);
            pPersonaje.transformar(new EstadoConvertidoEnChocolate(pPersonaje.obtenerEstado()));
        }
    }

    public void convierteEnChocolate(IPersonajeEquipoVillano pPersonaje){
        throw new AtaqueMismoEquipoException();
    }
    
    @Override
    public void transformar(){
        if(this.estado instanceof MajinBooEstadoNormal && this.stats.getKi() > 20){
        	this.stats.setKi(this.stats.getKi() - 20);
            this.estado = new MajinBooEstadoBooMalo(this.stats);
        }else if(this.estado instanceof MajinBooEstadoBooMalo && this.stats.getKi() > 50){
        	this.stats.setKi(this.stats.getKi() - 50);
            this.estado = new MajinBooEstadoBooOriginal(this.stats);
        }else{
            throw new NoPuedeTransformarException();
        }
    }
    
}

