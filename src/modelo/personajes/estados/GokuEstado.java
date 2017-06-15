package modelo.personajes.estados;

import modelo.excepciones.AtaqueFueraDeRangoException;
import modelo.excepciones.AtaqueMismoEquipoException;
import modelo.personajes.Stats;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;
import modelo.personajes.interfaces.IPersonajeEquipoZ;

public class GokuEstado extends Estado {

	@Override
	public void Atacar(IPersonajeEquipoZ pPersonaje, Stats stats){
		throw new AtaqueMismoEquipoException();
	}
	
	@Override
	public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats){
		if(this.calcularDistancia(pPersonaje.obtenerUbicacion(), stats.getUbicacion()) > stats.getDistanciaAtaque()){
			throw new AtaqueFueraDeRangoException();
		}else{
			if(stats.getVida() < 150){
				pPersonaje.setVida((int)(pPersonaje.getVida() - stats.getPoder()*1.2));
			}else{
				pPersonaje.setVida(pPersonaje.getVida() - stats.getPoder());
			}
			 
		}
	}
	
}
