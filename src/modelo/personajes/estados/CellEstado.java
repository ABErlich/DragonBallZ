package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.PersonajeFueraDeCombateException;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class CellEstado extends Estado {
	
	protected int cantAbsorciones;
	
	public CellEstado(){
		cantAbsorciones = 0;
		vidaMaxima = 500;
	}
	
	public void atacar(IPersonajeEquipoZ personaje){
		if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
			throw new AtaqueFueraDeRangoException();
		}else{
			if(this.vida > 0){
				personaje.recibirAtaque(poder, calcularDanio());
			}else{
				throw new PersonajeFueraDeCombateException();
			}
		}
	}
	public void absorber(IPersonajeEquipoZ personaje){
        if(ki < 5){
            throw new NoPuedeRealizarAtaqueException();
        }else{
        	if(ubicacion.calcularDistancia(personaje.obtenerUbicacion()) > distanciaAtaque){
    			throw new AtaqueFueraDeRangoException();
    		}else{
    			if(this.vida > 0){
    				this.cantAbsorciones += 1;
    	            ki = ki - 5;
    	            vida = vida + poder;
    	            personaje.recibirAtaque(poder, poder);
    			}else{
    				throw new PersonajeFueraDeCombateException();
    			}
    		}
        }
	}

	public abstract CellEstado transformar();

}
