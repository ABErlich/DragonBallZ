package modelo.personajes.estados;

import modelo.excepciones.UltimoEstadoException;

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
