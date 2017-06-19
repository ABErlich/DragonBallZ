package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class GokuEstado extends Estado {

    public GokuEstado() {
    	vidaMaxima = 500;
	}
	
	@Override
	public void atacar(IPersonajeEquipoZ pPersonaje){
		throw new AtaqueMismoEquipoException();
	}
	
	@Override
	public void atacar(IPersonajeEquipoVillano personaje){
		if(personaje.obtenerUbicacion().calcularDistancia(ubicacion) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			if(vida < 150){
				personaje.recibirAtaque((int)(calcularDanio()*1.2));
			}else{
				personaje.recibirAtaque(calcularDanio());
			}
		}
	}
	
	public void kamehameha(IPersonajeEquipoVillano personaje){
    	if(ki < 20){
    		throw new NoPuedeRealizarAtaqueException();
    	}else{
    		ki = ki - 20;
    		if(this.vidaMenor30porc()){
    			personaje.recibirAtaque((int) ((calcularDanio()*1.5)*1.2));
    		}else{
    			personaje.recibirAtaque((int) (calcularDanio()*1.5));
    		}
    		
    	}
    }

	public abstract GokuEstado transformar();
	
}
