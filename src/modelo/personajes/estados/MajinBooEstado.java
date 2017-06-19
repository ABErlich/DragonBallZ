package modelo.personajes.estados;

import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public abstract class MajinBooEstado extends Estado {

	public MajinBooEstado() {
		vidaMaxima = 300;
	}
	
	public void convierteEnChocolate(IPersonajeEquipoZ personaje){
        if(ki < 30){
            throw new NoPuedeRealizarAtaqueException();
        }else{
            ki = ki - 30;
            personaje.convertirEnChocolate();
        }
    }
	

	public abstract MajinBooEstado transformar();
	
}
