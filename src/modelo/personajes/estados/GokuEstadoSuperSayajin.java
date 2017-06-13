package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GokuEstadoSuperSayajin extends Estado {

	public GokuEstadoSuperSayajin(Stats stats){
		stats.setPoder(60);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(5);
		stats.setKi(stats.getKi() - 50);

	}

	public void Atacar(IPersonajeEquipoZ pPersonaje){
		throw new AtaqueMismoEquipoException();
	}

}
