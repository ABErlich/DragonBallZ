package DBZ.modelo.personajes.estados;

import DBZ.modelo.excepciones.AtaqueFueraDeRangoException;
import DBZ.modelo.excepciones.AtaqueMismoEquipoException;
import DBZ.modelo.excepciones.NoPuedeRealizarAtaqueException;
import DBZ.modelo.excepciones.PersonajeFueraDeCombateException;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoVillano;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;

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
				personaje.recibirAtaque(poder, (int)(calcularDanio()*1.2));
			}else{
				personaje.recibirAtaque(poder, calcularDanio());
			}
		}
	}

	public void kamehameha(IPersonajeEquipoVillano personaje){
    	if(ki < 20){
    		throw new NoPuedeRealizarAtaqueException();
    	}else{
    		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
    			throw new AtaqueFueraDeRangoException();
    		}else{
    			if(this.vida > 0){
    				ki = ki - 20;
    	    		if(this.vidaMenor30porc()){
    	    			personaje.recibirAtaque(poder, (int) ((calcularDanio()*1.5)*1.2));
    	    		}else{
    	    			personaje.recibirAtaque(poder, (int) (calcularDanio()*1.5));
    	    		}
    			}else{
    				throw new PersonajeFueraDeCombateException();
    			}
    		}


    	}
    }

	public abstract GokuEstado transformar();

}
