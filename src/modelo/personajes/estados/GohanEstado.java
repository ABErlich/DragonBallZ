package modelo.personajes.estados;

import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.juego.interfaces.IJugadorEquipoZ;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;

public abstract class GohanEstado extends Estado {

	public GohanEstado(){
		vidaMaxima = 300;
	}
	
	public void masenko(IPersonajeEquipoVillano personaje){
		if(ki < 10){
			throw new NoPuedeRealizarAtaqueException();
		}else{
			ki = ki - 10;
			personaje.recibirAtaque((int) (poder*1.25));
		}
	}

	public abstract GohanEstado transformar(IJugadorEquipoZ equipo);
}
