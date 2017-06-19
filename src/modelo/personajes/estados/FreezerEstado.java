package modelo.personajes.estados;

import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class FreezerEstado extends Estado {

	public FreezerEstado() {
    	vidaMaxima = 500;
	}
		
	
	public void rayoMortal(IPersonajeEquipoZ personaje){
		if(ki < 20){
			throw new NoPuedeRealizarAtaqueException();
		}else{
			ki = ki - 20;
			personaje.recibirAtaque(poder, (int) ((int)poder*1.5));
		}
    
	}

	public abstract FreezerEstado transformar();
	
}
