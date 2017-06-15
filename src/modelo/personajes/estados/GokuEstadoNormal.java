package modelo.personajes.estados;

import modelo.personajes.Stats;

public class GokuEstadoNormal extends GokuEstado {

	public GokuEstadoNormal(Stats stats){
		stats.setVida(500);
		stats.setPoder(20);
		stats.setDistanciaAtaque(2);
		stats.setVelocidadMov(2);
		stats.setKi(0);
	}

}
