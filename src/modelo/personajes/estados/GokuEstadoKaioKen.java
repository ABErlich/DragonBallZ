package modelo.personajes.estados;

import modelo.personajes.Stats;

public class GokuEstadoKaioKen extends GokuEstado {

	public GokuEstadoKaioKen(Stats stats){
		stats.setPoder(40);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(3);
		stats.setKi(stats.getKi() - 20);
	}

}
