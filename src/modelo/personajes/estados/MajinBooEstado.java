package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.PersonajeFueraDeCombateException;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class MajinBooEstado extends Estado {

	public MajinBooEstado() {
		vidaMaxima = 300;
	}
	
	public void convierteEnChocolate(IPersonajeEquipoZ personaje){
        if(ki < 30){
            throw new NoPuedeRealizarAtaqueException();
        }else{
        	if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
    			throw new AtaqueFueraDeRangoException();
    		}else{
    			if(this.vida > 0){
    				ki = ki - 30;
    	            personaje.convertirEnChocolate();
    			}else{
    				throw new PersonajeFueraDeCombateException();
    			}
    		}
            
        }
    }
	

	public abstract MajinBooEstado transformar();
	
}
