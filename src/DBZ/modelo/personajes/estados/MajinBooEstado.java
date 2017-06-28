package DBZ.modelo.personajes.estados;

import DBZ.modelo.excepciones.AtaqueFueraDeRangoException;
import DBZ.modelo.excepciones.NoPuedeRealizarAtaqueException;
import DBZ.modelo.excepciones.PersonajeFueraDeCombateException;
import DBZ.modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class MajinBooEstado extends Estado {

	public MajinBooEstado() {
		vidaMaxima = 300;
		vivo = true;
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
