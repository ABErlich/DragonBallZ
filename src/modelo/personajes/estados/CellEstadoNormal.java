package modelo.personajes.estados;

import modelo.personajes.Stats;
import modelo.personajes.interfaces.IPersonajeEquipoVillano;


import modelo.excepciones.AtaqueMismoEquipoException;

public class CellEstadoNormal extends Estado {

	public CellEstadoNormal(Stats stats){
		stats.setVida(500);
		stats.setPoder(20);
		stats.setDistanciaAtaque(3);
		stats.setVelocidadMov(2);
		stats.setKi(0);
	}
	
	@Override
	public void Atacar(IPersonajeEquipoVillano pPersonaje, Stats stats){
		throw new AtaqueMismoEquipoException();
	}


}
