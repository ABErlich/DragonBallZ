package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.PersonajeFueraDeCombateException;
import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;

public abstract class PiccoloEstado extends Estado {

	public PiccoloEstado() {
		vidaMaxima = 500;
	}
	
	public void makankosappo(IPersonajeEquipoVillano personaje){
    
    	if(ki < 10){
    		throw new NoPuedeRealizarAtaqueException();
    	}else{
    		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
    			throw new AtaqueFueraDeRangoException();
    		}else{
    			if(this.vida > 0){
    				ki = ki - 10;
    	    		personaje.recibirAtaque(poder, (int) (poder*1.25));
    			}else{
    				throw new PersonajeFueraDeCombateException();
    			}
    		}
    		
    	}
    }

	public abstract PiccoloEstado transformar(IJugadorEquipoZ equipo);
	
}
