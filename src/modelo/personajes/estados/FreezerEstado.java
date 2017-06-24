package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.PersonajeFueraDeCombateException;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

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
