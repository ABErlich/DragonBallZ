package modelo.personajes.estados;

import modelo.excepciones.NoPuedeRealizarAtaqueException;
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
    		ki = ki - 10;
    		personaje.recibirAtaque((int) (poder*1.25));
    	}
    }

	public abstract PiccoloEstado transformar(IJugadorEquipoZ equipo);
	
}
