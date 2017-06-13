package modelo.personajes.estados;

import modelo.personajes.interfaces.IPersonajeEquipoZ;
import modelo.personajes.Stats;
import modelo.excepciones.AtaqueMismoEquipoException;

public class GokuEstadoKaioKen extends Estado {

	public GokuEstadoKaioKen(Stats stats){
		stats.setPoder(40);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(3);
		stats.setKi(stats.getKi() - 20);
	}

	@Override
	public void Atacar(IPersonajeEquipoZ pPersonaje, Stats stats) {
		throw new AtaqueMismoEquipoException();
	}


}
