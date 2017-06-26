package DBZ.modelo.personajes.estados;

import DBZ.modelo.excepciones.AtaqueFueraDeRangoException;
import DBZ.modelo.excepciones.NoPuedeRealizarAtaqueException;
import DBZ.modelo.excepciones.PersonajeFueraDeCombateException;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class FreezerEstado extends Estado {

	public FreezerEstado() {
    	vidaMaxima = 500;
	}


	public void rayoMortal(IPersonajeEquipoZ personaje){
		if(ki < 20){
			throw new NoPuedeRealizarAtaqueException();
		}else{
			if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
    			throw new AtaqueFueraDeRangoException();
    		}else{
    			if(this.vida > 0){
    				ki = ki - 20;
    				personaje.recibirAtaque(poder, (int) ((int)poder*1.5));
    			}else{
    				throw new PersonajeFueraDeCombateException();
    			}
    		}

		}

	}

	public abstract FreezerEstado transformar();

}
