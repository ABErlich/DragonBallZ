package DBZ.modelo.personajes.estados;

import DBZ.modelo.excepciones.UltimoEstadoException;

public class GokuEstadoSuperSayajin extends GokuEstado {

	public GokuEstadoSuperSayajin(){

		poder = 60;
		distanciaAtaque = 4;
		velocidadMov = 5;

	}

	@Override
	public GokuEstado transformar() {
		throw new UltimoEstadoException();
	}

}
