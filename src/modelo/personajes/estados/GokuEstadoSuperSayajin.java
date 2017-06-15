package modelo.personajes.estados;

import modelo.personajes.Stats;

public class GokuEstadoSuperSayajin extends GokuEstado {

	public GokuEstadoSuperSayajin(Stats stats){
		stats.setPoder(60);
		stats.setDistanciaAtaque(4);
		stats.setVelocidadMov(5);
		stats.setKi(stats.getKi() - 50);

	}

}
