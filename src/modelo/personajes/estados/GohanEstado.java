package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.NoPuedeRealizarAtaqueException;
import modelo.excepciones.PersonajeFueraDeCombateException;
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

	public abstract GohanEstado transformar(IJugadorEquipoZ equipo);
}
